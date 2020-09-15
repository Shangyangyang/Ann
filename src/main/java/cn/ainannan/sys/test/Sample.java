package cn.ainannan.sys.test;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "19929081";
    public static final String API_KEY = "mOejdhzA9cVuExqGRllQPv1C";
    public static final String SECRET_KEY = "y0LHeIvGYS6u4DwX2j42hgszGyqLVkVS";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String image = "H:\\尚羊羊\\图片\\个人相册\\个人证件\\IMG_20180505_110620.jpg";
        JSONObject res = sample(client, image);
        System.out.println(res.toString(2));

    }

    public static JSONObject sample(AipOcr client, String image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");


        // 参数为本地图片路径
        return client.basicGeneral(image, options);

        // 参数为本地图片二进制数组
        //byte[] file = readImageFile(image);
        //res = client.basicGeneral(file, options);
        //System.out.println(res.toString(2));


        // 通用文字识别, 图片参数为远程url图片
        //JSONObject res = client.basicGeneral(image, options);
        //System.out.println(res.toString(2));

        /**
         * 返回结果解析
         {
         "log_id": 6383703856468045362, 唯一ID
         "words_result": [{     返回的行集合
         "probability": {   	行置信度信息
         "average": 0.9968,     行置信度平均值
         "min": 0.991555,       行置信度最小值
         "variance": 7.0E-6     行置信度方差
         },
         "words": "来让哥哥抱抱"
         }],
         "words_result_num": 1, 返回的行数
         "language": -1,
         "direction": 0
         }

         */
    }
}