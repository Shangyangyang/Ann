package com.newheyd.pub.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ainannan.base.bean.BaseBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author zrr
 * @version  2018-12-10
 * 工作日历bean 表：sys_fullcalendar
 */
public class FullCalendar extends BaseBean {

    private static final long serialVersionUID = 909608527039198488L;


    private String title;// 日历事件名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;//事件开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;//事件结束时间
    private int counts;//事件持续天数
    private String eventType;//事件类型
    private String color;//事件的背景色和边框
    private String textColor;//事件的文字颜色
    private String weekEndFlag;//是否周末0否1是
    private String relationID;//节假日多日类型关联ID,取start的ID,注意:start也要存自己的ID

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getWeekEndFlag() {
        return weekEndFlag;
    }

    public void setWeekEndFlag(String weekEndFlag) {
        this.weekEndFlag = weekEndFlag;
    }

    public String getRelationID() {
        return relationID;
    }

    public void setRelationID(String relationID) {
        this.relationID = relationID;
    }
}