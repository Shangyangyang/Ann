package cn.ainannan.timeline.picManager.service;

import cn.ainannan.timeline.picManager.bean.TimelinePic;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;


@ServerEndpoint(value = "/picSimilar/{fuserid}")
@Component
public class PicSimilarUtil {
	private static Logger log = LoggerFactory.getLogger(PicSimilarUtil.class);

	private static int onlineCount = 0; // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。

	private static CopyOnWriteArraySet<PicSimilarUtil> webSocketSet = new CopyOnWriteArraySet<PicSimilarUtil>(); // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。

	private Session session; // 与某个客户端的连接会话，需要通过它来给客户端发送数据

	private String fuserid; // 保存当前登录用户ID
	
	private static Float similarSize = 68F;

	//此处是解决无法注入的关键
	private static ApplicationContext applicationContext;
	//要注入的service或者dao
	private  TimelinePicService picService;
	
	public static void setApplicationContext(ApplicationContext applicationContext) {
		PicSimilarUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "fuserid") String fuserid) {
		try {
			this.session = session; // 设置当前session
			this.fuserid = fuserid;
			PicSimilarUtil _this = getcurrentWenSocket(this.fuserid); // 当前登录用户校验 每个用户同时只能连接一次
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
	 * @throws InterruptedException 
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws InterruptedException {
		try {
			PicSimilarUtil _this = null;
			for (PicSimilarUtil item : webSocketSet) {
				if (item.session.getId() == session.getId()) {
					_this = item;
				}
			}
			if (_this == null) {
				this.sendMessage("未连接不能发送消息！");
				return;
			}
			System.out.println("来自客户端的消息:" + message);
			
			
			picService = applicationContext.getBean(TimelinePicService.class);
			
			System.out.println(null == picService);
			

			int limitNum = 0;
			TimelinePic queryPic = new TimelinePic();
			queryPic.setLimitNum(limitNum);
			List<TimelinePic> list = picService.getFingerPrintList(queryPic);
			
			// 获取实体类
			TimelinePic p = new TimelinePic(); 
			p.setShortId(message.replace("\"", ""));

			QueryWrapper<TimelinePic> query = new QueryWrapper<TimelinePic>();
			query.eq("short_id", message.replace("\"", ""));

			TimelinePic resultPic = picService.getOne(query);
			
			while (list.size() != 0) {
				
				List<TimelinePic> resultList = list.stream().filter(item -> 
				cn.ainannan.commons.utils.StringUtils.getSimilarityRatio(
						resultPic.getFingerPrint(), 
						item.getFingerPrint()
					) > similarSize && !resultPic.getId().equals(item.getId()))
				.collect(Collectors.toList());
				
				resultList.stream().forEach(item -> {
					System.out.println(item.getFingerPrint());
				});
				
				if(resultList.size() > 0) {
					/*List<String> strList = Lists.newArrayList();
							
					resultList.forEach(item -> {
						strList.add(item.getSrc());
					});*/
					
					String listStr = JSONArray.toJSONString(resultList);
					
					this.sendMessage(listStr);
				}
				
				limitNum += 500;
				queryPic = new TimelinePic();
				queryPic.setLimitNum(limitNum);
				
				Thread.sleep(1000);
				
				list = picService.getFingerPrintList(queryPic);
			}
			
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
		System.out.println(error);
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
		for (PicSimilarUtil item : webSocketSet) {
			strList.add(item.fuserid);
		}
		return strList;
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		PicSimilarUtil.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		PicSimilarUtil.onlineCount--;
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
	public static PicSimilarUtil getcurrentWenSocket(String fuserid) {
		if (fuserid == null || "".equals(fuserid) || webSocketSet == null || webSocketSet.size() < 1) {
			return null;
		}
		Iterator<PicSimilarUtil> iterator = webSocketSet.iterator();
		while (iterator.hasNext()) {
			PicSimilarUtil _this = iterator.next();
			if (_this.fuserid == fuserid) {
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
			PicSimilarUtil _this = getcurrentWenSocket(fuserid);
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
				PicSimilarUtil _this = getcurrentWenSocket(fuserid);
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
			for (PicSimilarUtil item : webSocketSet) {
				item.sendMessage(message);
			}
		} catch (IOException e) {
			System.out.println("发送消息异常！");
			log.error("websocket发送消息异常  : Exception = " + e.getMessage());
		}
	}

}