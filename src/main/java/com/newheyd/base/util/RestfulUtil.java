package com.newheyd.base.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newheyd.base.bean.ResultObject;
import com.newheyd.base.pub.bean.Dict;
import okhttp3.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestfulUtil {
       public static ResultObject restful(String url){
        RestTemplate restTemplate = new RestTemplate();
        ResultObject result = restTemplate.getForObject(url, ResultObject.class);
        return result;
    }

    //RequestBody body = new FormBody.Builder().add("name", "于传芝").add("idcard", "370105194504142950").build();请用此种格式设置body
    public static ResultObject getRestful(String baseUrl, RequestBody body, String url){
        OkHttpClient client = new OkHttpClient();
        String ticket= RSAEncryptUtil.encrypt("newheyd");
        FormBody.Builder add= new FormBody.Builder();
        //RequestBody body = new FormBody.Builder().add("name", "于传芝").add("idcard", "370105194504142950").build();
       // Request request = new Request.Builder().url("http://localhost:80"+"/rkk/citizenInfo/getByIdcard"+"?ticket="+ticket).post(body).build();
        Request request = new Request.Builder().url(baseUrl+url+"?ticket="+ticket).post(body).build();
        // 3 创建请求方式
        try {
            Response response = client.newCall(request).execute();
            ResultObject result = JSONObject.parseObject(response.body().string(),ResultObject.class);
            return result;
        }catch (Exception ex) {
            return  null;
        }
    }

    /**
     * 获取字典项 map key:label value:value 键值 用于导入时，汉字匹配
     * @param baseUrl 访问地址，本地：localhost:端口号 服务器：221.214.107.246:8090
     * @param dictType 字典项类型
     * @return
     */
    public static Map getDictData(String baseUrl, String dictType){
        RequestBody typeDody = new FormBody.Builder().add("type",dictType).build();
        ResultObject typeResult = getRestful(baseUrl,typeDody, "/home/dict/list");
        Map typeMap=new HashedMap();
        if(typeResult.getCode() == 200){
            JSONObject obj= (JSONObject) typeResult.getData();
            // 返回json的数组
            JSONArray jsonArray = obj.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                Dict dict=  JSONObject.parseObject(jsonObject2.toString(),Dict.class);
                typeMap.put((String) jsonObject2.get("label"),(String) jsonObject2.get("value"));
            }
            return  typeMap;
        }
        return  null;
    }

}
