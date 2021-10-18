package cn.ainannan.sys.test.controller;

import cn.ainannan.AnnApplication;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.service.SyncService;
import cn.ainannan.tool.dj.service.DjService;
import com.google.common.collect.Lists;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
// @RunWith(SpringJUnit4ClassRunner.class)
// junit5 改用以下方式
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnnApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class TestController {
    @Autowired
    private TimelinePicMapper picDao;

    @Autowired
    private SyncService syncService;
    @Autowired
    private DjService djService;

    @RequestMapping("getFile")
    public void getFile(HttpServletResponse resp) {


        String filePath = "D:\\opt\\upFiles\\video\\001swuO5lx07yLKy0jqo010412006qRQ0E010_1629770945238.mp4";

        File file = new File(filePath);
        try {
            FileUtils.sendFile(file, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("index")
    public String index(HttpServletRequest req) {
        System.out.println("req.getParameterMap() = " + req.getParameterMap());

        Map<String, String[]> parameterMap = req.getParameterMap();

        for (String s : parameterMap.keySet()) {
            System.out.println("s = " + s);
            System.out.println("parameterMap = " + parameterMap.get(s));

            String[] strings = parameterMap.get(s);

            System.out.println("strings.length = " + strings.length);

            for (String string : strings) {
                System.out.println("string = " + string);
            }

            System.out.println("----------------------------");


        }
        System.out.println("+++++++++++++++++++++++++++++++++++");



        return "hello ann";
    }

    @RequestMapping("abc")
    public String abc() {
        return "hello abc";
    }

    @RequestMapping("ccc")
    public String ccc() {
        return "hello ccc";
    }


    @RequestMapping("receive")
    public String receive(@RequestParam("list") List<String> list) {

        for (String s : list) {
            System.out.println("s = " + s);
        }


        return "hello ann";

    }

    /**
     * mybatis 查询子集合的试验
     */
    @Test()
    public void method2() {
        String url = "http://223.99.3.4:8077/jeecg-boot//shanti.measurement/shtEvaluation/receive";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("evaluationList", "[{ \t\"XYJ_XINLV\": \"81\", \t\"CESHINIANLING\": 29, \t\"ZWTQQ\": \"17.70\", \t\"XINGBIEBIANMA\": \"1\", \t\"XINGBIE\": \"男\", \t\"ID\": 3, \t\"YEAJXL\": \"\", \t\"CHUSHENGRIQI\": \"1989-08-09\", \t\"GUWOCHENG\": \"\", \t\"ZHIYE\": \"\", \t\"YEAJXLGPS\": \"\", \t\"GLC_DATE\": \"2019-08-06 15:16\", \t\"XINGZHENGJIBIE\": \"\", \t\"SHENGAOGPS\": \"39.731,116.568\", \t\"WD_YWDATE\": \"\", \t\"JIGUAN\": \"\", \t\"TIZHONG\": \"83.80\", \t\"GTTZ_ZYTGPS\": \"\", \t\"WD_YW\": \"\", \t\"YEAJXLDATE\": \"\", \t\"JIATINGZHUZHI\": \"\", \t\"GTTZ_ZT\": \"\", \t\"SHENGAO\": \"177.60\", \t\"YESHENGAO\": \"\", \t\"DIQU\": \"\", \t\"ZWTQQGPS\": \"39.731,116.568\", \t\"YELDTYGPS\": \"\", \t\"BUMEN\": \"\", \t\"WOLIGPS\": \"39.731,116.569\", \t\"YEZWTQQGPS\": \"\", \t\"ZONGTIAO\": \"35.40\", \t\"BEIZHU\": \"\", \t\"YEWOLIGPS\": \"\", \t\"YESHENGAODATE\": \"\", \t\"YERZAP\": \"\", \t\"YEPHMWCFS\": \"\", \t\"GTTZ_YTGPS\": \"\", \t\"HUIYUANHAO\": \"110101000003\", \t\"YEZUOGAODATE\": \"\", \t\"YETIZHONGGPS\": \"\", \t\"YETIZHONGDATE\": \"\", \t\"FEIHUOLIANG\": \"3949.00\", \t\"GTTZ_YT\": \"\", \t\"YESJLXTGPS\": \"\", \t\"TXF_DATE\": \"2019-08-06 15:27\", \t\"YEPHMDATE\": \"\", \t\"XYJ_SSY\": \"137\", \t\"WD_YWGPS\": \"39.731,116.568\", \t\"ZZSYGPS\": \"\", \t\"CHENGXIANGGONGZUOZHONGLEI\": \"城镇非体力劳动者\", \t\"RENQUNBIANMA\": \"23\", \t\"BYDJZLGPS\": \"39.731,116.568\", \t\"HANGYE\": \"\", \t\"DIANZIYOUXIANG\": \"\", \t\"SHOUJIHAO\": \"\", \t\"YEZWTQQ\": \"\", \t\"ZONGTIAODATE\": \"2019-08-06 14:46\", \t\"YELDTYDATE\": \"\", \t\"ZHICHENG\": \"\", \t\"YEZUOGAO\": \"\", \t\"XZFYSDATE\": \"2019-08-06 14:52\", \t\"YESJLXT\": \"\", \t\"SHENGAODATE\": \"2019-08-06 14:44\", \t\"WOLI\": \"47.90\", \t\"GLC_JUEDUIZHI\": \"0.00\", \t\"GTTZ_ZYTDATE\": \"\", \t\"YEWD_XWGPS\": \"\", \t\"NIANLING\": \"30\", \t\"GLC_XIANGDUIZHI\": \"67.70\", \t\"ZHUCERIQI\": \"\", \t\"YEZWTQQDATE\": \"\", \t\"XINGMING\": \"小田\", \t\"ZZSY\": \"\", \t\"YEZUOGAOGPS\": \"\", \t\"TXF_TIZHILV\": \"26.4\", \t\"XINYANG\": \"\", \t\"YFZTWQZDATE\": \"2019-08-06 14:54\", \t\"YOUBIAN\": \"\", \t\"ZHAOPIAN\":\"\", \t\"ZZSYDATE\": \"\", \t\"YEWD_XW\": \"\", \t\"YFZTWQZGPS\": \"39.731,116.569\", \t\"GLC_MET\": \"0.00\", \t\"XZFYS\": \"0.87\", \t\"GTTZ_ZTDATE\": \"\", \t\"GTTZ_ZYT\": \"\", \t\"BEILIJI\": \"93.20\", \t\"BEILIJIDATE\": \"2019-08-06 15:02\", \t\"WD_TWDATE\": \"\", \t\"CESHINIANLINGZU\": \"25岁~29岁\", \t\"TIZHONGGPS\": \"39.731,116.569\", \t\"WD_TWGPS\": \"39.731,116.568\", \t\"BYDJZL\": \"8.50\", \t\"ZWTQQDATE\": \"2019-08-06 14:49\", \t\"GLC_GPS\": \"39.731,116.569\", \t\"SHENFENZHENGHAO\": \"\", \t\"YERZAPGPS\": \"\", \t\"YEWD_XWDATE\": \"\", \t\"TXF_GPS\": \"39.730,116.567\", \t\"MINZU\": \"\", \t\"YEWOLI\": \"\", \t\"DENGJIXUHAO\": 5, \t\"TIZHONGDATE\": \"2019-08-06 14:44\", \t\"XYJ_SZY\": \"89\", \t\"FUWOCHENGDATE\": \"2019-08-06 14:58\", \t\"YFZTWQZ\": \"14.00\", \t\"FEIHUOLIANGDATE\": \"2019-08-06 14:46\", \t\"GUWOCHENGDATE\": \"\", \t\"BYDJZLDATE\": \"2019-08-06 14:47\", \t\"WENHUACHENGDU\": \"\", \t\"CESHIRIQI\": \"2019-08-06\", \t\"YELDTY\": \"\", \t\"GONGZUODANWEI\": \"鑫东华腾体育器械有限公司\", \t\"XIUGAIRIQI\": \"2019-09-20\", \t\"YERZAPDATE\": \"\", \t\"FEIHUOLIANGGPS\": \"39.731,116.569\", \t\"YEPHM\": \"\", \t\"YESHENGAOGPS\": \"\", \t\"JIGOUDAIMA\": \"\", \t\"GUWOCHENGGPS\": \"\", \t\"YEPHMGPS\": \"\", \t\"YETIZHONG\": \"\", \t\"XYJ_DATE\": \"2019-08-06 14:39\", \t\"GTTZ_ZTGPS\": \"\", \t\"BEILIJIGPS\": \"39.731,116.568\", \t\"WD_TW\": \"\", \t\"WOLIDATE\": \"2019-08-06 14:44\", \t\"GTTZ_YTDATE\": \"\", \t\"FUWOCHENGGPS\": \"39.731,116.569\", \t\"FUWOCHENG\": \"5.00\", \t\"YESJLXTDATE\": \"\", \t\"ZONGTIAOGPS\": \"39.731,116.569\", \t\"YEWOLIDATE\": \"\", \t\"SUOSHUJIGOU\": \"\", \t\"CESHIHAO\": \"000003\", \t\"XZFYSGPS\": \"39.731,116.569\", \t\"XYJ_GPS\": \"39.731,116.568\", \t\"MINZUBIANMA\": \"03\", \t\"HANGYEBIANMA\": \"1\", \t\"ZHIYEBIANMA\": \"2\" } ]")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method() {
        List<TimelinePic> picList = picDao.findTempList();

        int count = 0;

        while (picList.size() > 0) {

            List<TimelinePic> saveList = Lists.newArrayList();

            picList.stream().forEach(item -> {
                System.out.println("==============================");
                String finger = null;
                try {
                    finger = FingerPrintUtils.produceFingerPrint(item.getPath() + item.getFilename());
                } catch (Exception e) {
                    System.out.println("出错的文件名:");
                    System.out.println(item.getPath() + item.getFilename());
                }

                System.out.println(finger);
                if (null != finger) {

                    TimelinePic pic = new TimelinePic();
                    pic.setId(item.getId());
                    pic.setFingerPrint(finger);

                    saveList.add(pic);
                } else {
                    System.out.println(item.getPath() + item.getFilename());
                }
            });
            System.out.println(saveList.size());

            TimelinePic pic = new TimelinePic();
            pic.setPicList(saveList);

            picDao.saveByList(pic);

            System.out.println("第 " + (++count) + " 轮执行完毕，共生成 " + saveList.size() + " 条记录。");

            picList = picDao.findTempList();
        }

    }


    @RequestMapping("pubuList")
    public ResultObject pubuList(
            @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
            HttpServletRequest request) {

        List<Integer> iList = Lists.newArrayList();

        int s = page * size - size + 1;
        int e = page * size;

        for (int i = s; i <= e; i++) {
            iList.add(i);
        }


        return ResultGen.genSuccessResult(iList);
    }
}
