package cn.ainannan.sys.websocket;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import cn.ainannan.base.result.ResultObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

/**
 * websocket
 *
 * @author hufx
 * @version 1.0
 * @date 2017年6月2日上午10:27:40
 */
@ServerEndpoint(value = "/websocket/{fuserid}", encoders = { ServerEncoder.class })
@Component
public class WebSocketUtil {
	private static Logger log = LoggerFactory.getLogger(WebSocketUtil.class);

	private static int onlineCount = 0; // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。

	private static CopyOnWriteArraySet<WebSocketUtil> webSocketSet = new CopyOnWriteArraySet<WebSocketUtil>(); // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。

	private Session session; // 与某个客户端的连接会话，需要通过它来给客户端发送数据

	private String fuserid; // 保存当前登录用户ID

	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "fuserid") String fuserid) {
		try {
			this.session = session; // 设置当前session
			this.fuserid = fuserid;
			WebSocketUtil _this = getcurrentWenSocket(this.fuserid); // 当前登录用户校验 每个用户同时只能连接一次
			if (_this != null) {
				sendMessage("您已有连接信息，不能重复连接 !");
				return;
			}
			webSocketSet.add(this); // 将当前websocket加入set中
			addOnlineCount(); // 在线数加1
			sendMessage("连接成功！");
			System.out.println("有一新连接！当前在线人数为" + getOnlineCount());
		} catch (IOException e) {
			System.out.println("连接异常！");
			log.error("websocket连接异常  : 登录人ID = " + this.fuserid + " , Exception = " + e.getMessage());
		}
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		boolean b = webSocketSet.remove(this); // 从set中删除
		if (b && getOnlineCount() > 0) {
			subOnlineCount(); // 在线数减1
		}
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message
	 *            客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		try {
			WebSocketUtil _this = null;
			for (WebSocketUtil item : webSocketSet) {
				if (item.session.getId() == session.getId()) {
					_this = item;
				}
			}
			if (_this == null) {
				this.sendMessage("未连接不能发送消息！");
				return;
			}
			System.out.println("来自客户端的消息:" + message);
			if("heart beat".equals(message)) this.sendMessage("heart beat");
			// this.sendMessage("来自服务端的消息: <已读> " + message);

		} catch (IOException e) {
			System.out.println("发送消息异常！");
			log.error("websocket发送消息异常  : 登录人ID = " + this.fuserid + " , Exception = " + e.getMessage());
		}
	}

	/**
	 * 发生错误时调用
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误！");
		log.error("websocket发生错误  : 登录人ID = " + this.fuserid);
	}

	/**
	 * 获取所有的连接列表
	 *
	 * @return
	 */
	public static List<String> getFuseridList() {
		List<String> strList = Lists.newArrayList();
		for (WebSocketUtil item : webSocketSet) {
			strList.add(item.fuserid);
		}
		return strList;
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketUtil.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketUtil.onlineCount--;
	}

	/**
	 * 根据当前登录用户ID获取他的websocket对象
	 *
	 * @param fuserid
	 *            用户ID
	 * @return MyWebSocket
	 * @author hufx
	 * @date 2017年6月2日上午10:35:32
	 */
	public static WebSocketUtil getcurrentWenSocket(String fuserid) {
		if (fuserid == null || "".equals(fuserid) || webSocketSet == null || webSocketSet.size() < 1) {
			return null;
		}
		Iterator<WebSocketUtil> iterator = webSocketSet.iterator();
		while (iterator.hasNext()) {
			WebSocketUtil _this = iterator.next();
			if (fuserid.equals(_this.fuserid)) {
				return _this;
			}
		}
		return null;
	}

	/**
	 * 给当前用户发消息（单条）
	 *
	 * @param message
	 *            消息
	 * @throws IOException
	 *             void
	 * @author hufx
	 * @date 2017年6月1日下午2:05:36
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}

	public void sendObj(ResultObject message) throws IOException, EncodeException {
		this.session.getBasicRemote().sendObject(message);
	}

	public static void sendObj(String fuserid, ResultObject message) {
		try {
			WebSocketUtil _this = getcurrentWenSocket(fuserid);
			if (_this == null) {
				return;
			}

			_this.sendObj(message);
		} catch (IOException e) {
			System.out.println("发送消息异常！");
		} catch (EncodeException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 给指定用户发指定消息（单人单条）
	 *
	 * @param fuserid
	 *            用户ID
	 * @param message
	 *            消息 void
	 * @author hufx
	 * @date 2017年6月2日上午11:13:26
	 */
	public static void sendMessage(String fuserid, String message) {
		try {
			if (fuserid == null || "".equals(fuserid) || StringUtils.isBlank(message)) {
				return;
			}
			WebSocketUtil _this = getcurrentWenSocket(fuserid);
			if (_this == null) {
				return;
			}
			_this.sendMessage(message);
		} catch (IOException e) {
			System.out.println("发送消息异常！");
		}
	}

	/**
	 * 给指定人群发消息（单条）
	 *
	 * @param fuseridList
	 *            用户ID列表
	 * @param message
	 *            消息 void
	 * @author hufx
	 * @date 2017年6月2日上午11:25:29
	 */
	public static void sendMessageList(List<String> fuseridList, String message) {
		try {
			if (fuseridList == null || fuseridList.size() < 1 || StringUtils.isBlank(message)) {
				return;
			}
			for (String fuserid : fuseridList) {
				WebSocketUtil _this = getcurrentWenSocket(fuserid);
				if (_this == null) {
					continue;
				}
				_this.sendMessage(message);
			}
		} catch (Exception e) {
			System.out.println("发送消息异常！");
			log.error("websocket发送消息异常  : 登录人ID = " + fuseridList.toString() + " , Exception = " + e.getMessage());
		}
	}

	/**
	 * 给所有在线用户发消息（单条）
	 *
	 * @param message
	 *            消息
	 * @throws IOException
	 *             void
	 * @author hufx
	 * @date 2017年6月2日上午11:11:05
	 */
	public static void sendMessageAll(String message) {
		try {
			if (webSocketSet == null || webSocketSet.size() < 1 || StringUtils.isBlank(message)) {
				return;
			}
			for (WebSocketUtil item : webSocketSet) {
				item.sendMessage(message);
			}
		} catch (IOException e) {
			System.out.println("发送消息异常！");
			log.error("websocket发送消息异常  : Exception = " + e.getMessage());
		}
	}

}