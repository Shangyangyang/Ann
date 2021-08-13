package cn.ainannan.timeline.picManager.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.DateUtil;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.TimelinePicService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 时光轴Controller
 *
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "timeline/pic")
public class TimelinePicController {

    @Autowired
    private TimelinePicService tpService;

    @RequestMapping("getImg")
    public void getImg(String id, String type, HttpServletRequest request, HttpServletResponse resp) {
        if (StringUtils.isBlank(id)) return;
        tpService.getImg(id, type, resp);
    }

    @RequestMapping("getRandomImg")
    public ResultObject getRandomImg() {


        return ResultGen.genSuccessResult(tpService.getRandomImg());
    }


    @RequestMapping("getTabsList")
    public ResultObject getTabsList(String id) {
        if (StringUtils.isBlank(id)) return ResultGen.genFailResult("关键参数不能为空");


        TimelinePic pic = tpService.get(id);

        // data1
        TimelinePic tp1 = new TimelinePic();
        tp1.setBeginShotDate(DateUtil.beforeOneHourToNowDate(pic.getShotDate(), 1, "begin"));
        tp1.setEndShotDate(DateUtil.beforeOneHourToNowDate(pic.getShotDate(), 1, "end"));
        tp1.setNotId(id);
        tp1.setSqlOrderBy("shot_date asc");

        List<TimelinePic> tab1List = tpService.findList(tp1);

        // data2
        tp1 = new TimelinePic();
        tp1.setNotId(id);
        tp1.setShotDateL(new SimpleDateFormat("yyyy-MM-dd").format(pic.getShotDate()));
        tp1.setSqlOrderBy("shot_date asc");

        List<TimelinePic> tab2List = tpService.findList(tp1);

        // data3
        List<TimelinePic> tab3List = Lists.newArrayList();

        if(StringUtils.isNotBlank(pic.getGeox()) && !"0".equals(pic.getGeox())){

            tp1 = new TimelinePic();
            tp1.setNotId(id);
            tp1.setGeox(pic.getGeox());
            tp1.setGeoy(pic.getGeoy());

            tab3List = tpService.findGeoAdjoinList(tp1);
        }

        return ResultGen.genSuccessResult(tab1List).setData2(tab2List).setData3(tab3List);
    }

}