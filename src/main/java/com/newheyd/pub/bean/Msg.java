package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Msg extends BaseBean {

    public static final String MSG_SRC_HOME = "平台中心";
    public static final String MSG_SRC_CC = "控制中心";
    public static final String MSG_SRC_LC = "日志中心";
    public static final String MSG_SRC_OA = "OA协同办公";
    public static final String MSG_SRC_EDU = "教育管理系统";
    public static final String MSG_SRC_WQGL= "维权管理系统";
    public static final String MSG_SRC_PXGL= "培训管理系统";
    public static final String MSG_SRC_SHBZ= "社会保障系统";
    public static final String MSG_SRC_JYGL= "就业管理系统";
    public static final String MSG_SRC_LFZX= "劳服中心系统";
    public static final String MSG_SRC_CJRZ= "残疾人证系统";
	public static final String MSG_SRC_ORG = "组织管理系统";
    public static final String MSG_SRC_FUJU = "泉城辅具服务平台";
    public static final String MSG_SRC_SJJG = "数据监管系统";
    //其他人根据需要自行添加

    public static final String MSG_TYPE_PREFIX_HOME = "HOME";
    public static final String MSG_TYPE_PREFIX_CC = "CC";
    public static final String MSG_TYPE_PREFIX_LC = "LC";
    public static final String MSG_TYPE_PREFIX_OA = "OA";
    public static final String MSG_TYPE_PREFIX_EDU = "EDU";
    public static final String MSG_TYPE_PREFIX_CJRZ = "CJRZ";
    public static final String MSG_TYPE_PREFIX_WQGL_WZAGZ_SHENQING = "WQGL_WZAGZ_SHENQING";//街道代申请
    public static final String MSG_TYPE_PREFIX_WQGL_WZAGZ_JDSHENHE = "WQGL_WZAGZ_JDSHENHE";//街道审核
    public static final String MSG_TYPE_PREFIX_WQGL_WZAGZ_QUSHENHE = "WQGL_WZAGZ_QUSHENHE";//区级审核
    public static final String MSG_TYPE_PREFIX_WQGL_WZAGZ_ZHCX = "WQGL_WZAGZ_ZHCX";//跳转综合查询
    public static final String MSG_TYPE_PREFIX_WQGL_FUEL_SHENQING = "WQGL_FUEL_SHENQING";//街道代申请
    public static final String MSG_TYPE_PREFIX_WQGL_FUEL_JDSHENHE = "WQGL_FUEL_JDSHENHE";//街道审核
    public static final String MSG_TYPE_PREFIX_WQGL_FUEL_QUSHENHE = "WQGL_FUEL_QUSHENHE";//区级审核
    public static final String MSG_TYPE_PREFIX_WQGL_FUEL_ZHCX = "WQGL_FUEL_ZHCX";//跳转综合查询

    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_SHENQING = "SHBZ_YHDC_SHENQING";//社区代申请
        public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_SQSHENHE = "SHBZ_YHDC_SQSHENHE";//社区审核
    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_GONGSHI = "SHBZ_YHDC_GONGSHI";//社区公示
    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_JDSHENHE = "SHBZ_YHDC_JDSHENHE";//街道审核
    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_QUSHENHE = "SHBZ_YHDC_QUSHENHE";//区级审核
    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_SHISHENHE = "SHBZ_YHDC_SHISHENHE";//市级审核
    public static final String MSG_TYPE_PREFIX_SHBZ_YHDC_ZHCX = "SHBZ_YHDC_ZHCX";//跳转综合查询

    public static final String MSG_TYPE_PREFIX_PXGL = "PXGL";
    public static final String MSG_TYPE_PREFIX_LFZX = "LFZX";
    public static final String MSG_TYPE_PREFIX_SHBZ = "SHBZ";
    public static final String MSG_TYPE_PREFIX_JYGL = "JYGL";
    public static final String MSG_TYPE_PREFIX_ORG = "ORG";
    public static final String MSG_TYPE_PREFIX_FUJU = "FUJU";
    public static final String MSG_TYPE_PREFIX_TYGL = "TYGL";

    public static final String MSG_TYPE_PREFIX_APP = "APP_LOGIN";

    //其他人根据需要自行添加

    //消息的已读未读状态
    public static final String MSG_STATE_NOT_READ = "0";
    public static final String MSG_STATE_HAD_READ = "1";

    public static final String MSG_STATE_NOT_HANDLE = "0";
    public static final String MSG_STATE_HAD_HANDLE = "1";

    private String msgTitle;            // 消息标题

    private String msgType;             // 消息类型

    private String msgSrc;              // 消息来源

    private String msgContent;          // 消息内容

    private String msgUrl;              // 消息目标url

    private String msgDate;             // 消息时间

    private String senderCode;          // 消息发起人编码
    private String senderName;          // 消息发起者姓名

    private String receiverCode;        // 消息接收者编码
    private String receiverName;        // 消息接收者姓名

    private String msgState;            // 消息状态
    private String handleState;         // 消息处理状态

    private String clientId;//app消息推送用

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;        // 开始日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;        // 结束日期


    public Msg() {
        super();
    }

    public Msg(String id) {
        super(id);
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgState() {
        return msgState;
    }

    public void setMsgState(String msgState) {
        this.msgState = msgState;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getHandleState() {
        return handleState;
    }

    public void setHandleState(String handleState) {
        this.handleState = handleState;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}