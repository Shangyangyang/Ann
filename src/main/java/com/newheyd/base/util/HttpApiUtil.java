package com.newheyd.base.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpApiUtil {

    /**
     * 公共方法，请勿改动
     * @param host
     * @param port
     * @param uri
     * @param apiKey
     * @param param
     * @return
     */
    public static String postRequest(String host, String port, String uri, String apiKey, Map<String,String> param) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        clientBuilder.readTimeout(60, TimeUnit.SECONDS);
        OkHttpClient httpClient = clientBuilder.build();

        FormBody.Builder formBuilder = new FormBody.Builder();

        if (param != null) {
            for (String key : param.keySet()) {
                formBuilder.add(key, param.get(key));
            }
        }

        RequestBody requestBody = formBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();
        // 公共方法，请勿改动
        requestBuilder.url("http://" + host + ":" + port + uri);
        // requestBuilder.url("https://" + uri);
        requestBuilder.addHeader("appKey", apiKey);
        Request request = requestBuilder.post(requestBody).build();

        Call call = httpClient.newCall(request);

        try {
            Response response = call.execute();
            return response.body().string();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

    }


    public static String postRequestOld(String host, String port, String uri, String apiKey, Map<String,String> param) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        clientBuilder.readTimeout(60, TimeUnit.SECONDS);
        OkHttpClient httpClient = clientBuilder.build();

        FormBody.Builder formBuilder = new FormBody.Builder();

        if (param != null) {
            for (String key : param.keySet()) {
                formBuilder.add(key, param.get(key));
            }
        }

        RequestBody requestBody = formBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url("http://" + host + ":" + port + uri);
        requestBuilder.addHeader("ApiKey", apiKey);

        Request request = requestBuilder.post(requestBody).build();

        Call call = httpClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    /*
    public static void getRequest(){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        //clientBuilder.proxy(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", Integer.valueOf("808"))));
        clientBuilder.connectTimeout(60,TimeUnit.SECONDS);
        clientBuilder.readTimeout(60,TimeUnit.SECONDS);
        OkHttpClient httpClient = clientBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url("http://localhost:9960/gateway/api/1/smzt_dbryxx_dbjk?name=袁达&id_card=370123199002061734&start=1&limit=100");
        requestBuilder.addHeader("ApiKey","508945377823555584");

        Request request = requestBuilder.build();

        Call call = httpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    */

    /**
     * 获取营业执照信息
     * @param paramMap(NAME:单位名称，必填；CODE：组织机构代码，必填）
     * @return JSONObject(code:200表示成功，否则表示失败，data(JSONObject):REGNO 注册号;UNISCID 统一社会信用代码;ENTNAME 企业名称;ENTTYPE 企业类型;DOM 营业场所;
     * LEREP 法定代表人;ESTDATE 成立日期;OPFROM 经营期限自;OPTO 经营期限至;REVDATE 吊销时间;CANDATE 注销时间;BUSSCOPE 经营范围
     *REGORG 登记机关;ENTSTATUS 企业状态)
     * 返回示例（）：
     * {"code":200,"data":{"msg":"服务调用成功","code":"200","data":[{"DOM":"山东省济南市历下区经十路12111号中润世纪中心1号楼2201",
     * "ENTSTATUS":"在营（开业）企业","BUSSCOPE":"计算机软硬件开发、销售及相关技术咨询；计算机网络工程施工、系统集成；非专控通讯设备的安装、销售；
     * 计算机耗材、电子产品、办公设备的销售；电子工程施工、安防工程的设计施工（凭资质证经营）。（未取得专项许可证的项目除外）",
     * "REGNO":"370000228064467","ENTTYPE":"股份有限公司(非上市、自然人投资或控股)","ENTNAME":"山东新中天信息技术股份有限公司",
     * "LEREP":"李峰","REGORG":"济南市历下区市场监督管理局","ESTDATE":"2007-02-05 00:00:00","UNISCID":"91370102798677204A",
     * "OPFROM":"2007-02-05 00:00:00"}],"error":""},"message":""}
     *
     * http://jncredit.jinan.gov.cn/jnxy/jnxy/credit/creditindex.do?type=1&keyWord=
     */
    public static JSONObject getYingYeZhiZhaoInfo(Map<String,String> paramMap){
        JSONObject resultObject = JSON.parseObject(postRequest("172.20.3.79", "9960", "/gateway/api/1/gsjyyzzxx", "606808389200117760", paramMap));
        JSONObject dataObject = new JSONObject();

        //如果访问错误 || !"200".equals(resultObject.getJSONObject("data").getString("code"))
        if(!"200".equals(resultObject.getString("code"))){
            dataObject.put("code","-1");
            return dataObject;
        }

            return resultObject;
    }

}
