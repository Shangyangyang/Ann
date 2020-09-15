package cn.ainannan.sys.websocket;


import cn.ainannan.base.result.ResultObject;
import com.alibaba.fastjson.JSON;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ServerEncoder implements Encoder.Text<ResultObject> {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public String encode(ResultObject messagepojo) throws EncodeException {
        return JSON.toJSONString(messagepojo);
    }
}