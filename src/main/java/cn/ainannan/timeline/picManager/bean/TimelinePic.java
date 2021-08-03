package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TimelinePic extends BaseBean {

	private static final Integer SIMILAR_PASS_LINE = 99;

	private String shortId;
	private String filename;
	private String path;
	private String src;
	private String srcThumbnail;
	private String suffix;
	private Long size;
	private String MD5;
	private String fingerPrint;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date shotDate;
	private String similarId;
	private Integer similarStatus;
	private String state;
	private String belong; // 归属1雪碧2乐乐

	private String geox;
	private String geoy;

	private Double similarity; // 相似度最高100

	// 三个统计字段
	private String lastTotal; // 最新总数
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastShotDate; // 最新拍摄日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastImportDate; // 最近导入日期

	private String preSrc; // 查询参数，以src进行模糊查询
	private String timelineFlag; // 不为空则进行与timeline表的exists查询

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date beginShotDate; // 起始拍摄日期

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endShotDate; // 结束拍摄日期

	// 查询参数
	private String shotDateL; // Like查询拍摄日期
	private Integer limitNum; // 查询页数
	private Integer limitCount; // 查询条数
	private String thumbnailFlag; // 0：srcThumbnail为空
	private Integer similarType;	// 1指纹2直方图
	private String similarIsNotEmpty;	// 1是
	private String geoIsNull; // geo是否为空1是0否
	private String showPath;	// 是否查询path src
	private Integer bSize;
	private Integer eSize;


	private Integer picCount; // 去重模块用到的统计字段，重复图片数

	private List<TimelinePic> picList;


	public Integer getbSize() {
		return bSize;
	}

	public void setbSize(Integer bSize) {
		this.bSize = bSize;
	}

	public Integer geteSize() {
		return eSize;
	}

	public void seteSize(Integer eSize) {
		this.eSize = eSize;
	}

	public Double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String mD5) {
		MD5 = mD5;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getSimilarId() {
		return similarId;
	}

	public void setSimilarId(String similarId) {
		this.similarId = similarId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getShotDate() {
		return shotDate;
	}

	public void setShotDate(Date shotDate) {
		this.shotDate = shotDate;
	}

	public String getLastTotal() {
		return lastTotal;
	}

	public void setLastTotal(String lastTotal) {
		this.lastTotal = lastTotal;
	}

	public Date getLastShotDate() {
		return lastShotDate;
	}

	public void setLastShotDate(Date lastShotDate) {
		this.lastShotDate = lastShotDate;
	}

	public Date getLastImportDate() {
		return lastImportDate;
	}

	public void setLastImportDate(Date lastImportDate) {
		this.lastImportDate = lastImportDate;
	}

	public String getPreSrc() {
		return preSrc;
	}

	public void setPreSrc(String preSrc) {
		this.preSrc = preSrc;
	}

	public String getTimelineFlag() {
		return timelineFlag;
	}

	public void setTimelineFlag(String timelineFlag) {
		this.timelineFlag = timelineFlag;
	}

	public Date getBeginShotDate() {
		return beginShotDate;
	}

	public void setBeginShotDate(Date beginShotDate) {
		this.beginShotDate = beginShotDate;
	}

	public Date getEndShotDate() {
		return endShotDate;
	}

	public void setEndShotDate(Date endShotDate) {
		this.endShotDate = endShotDate;
	}

	public String getShotDateL() {
		return shotDateL;
	}

	public void setShotDateL(String shotDateL) {
		this.shotDateL = shotDateL;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getSrcThumbnail() {
		return srcThumbnail;
	}

	public void setSrcThumbnail(String srcThumbnail) {
		this.srcThumbnail = srcThumbnail;
	}

	public String getThumbnailFlag() {
		return thumbnailFlag;
	}

	public void setThumbnailFlag(String thumbnailFlag) {
		this.thumbnailFlag = thumbnailFlag;
	}

	public List<TimelinePic> getPicList() {
		return picList;
	}

	public void setPicList(List<TimelinePic> picList) {
		this.picList = picList;
	}

	@Override
	public String toString() {
		return "TimelinePic [shortId=" + shortId + ", filename=" + filename + ", path=" + path + ", src=" + src
				+ ", srcThumbnail=" + srcThumbnail + ", suffix=" + suffix + ", size=" + size + ", MD5=" + MD5
				+ ", fingerPrint=" + fingerPrint + ", shotDate=" + shotDate + ", similarId=" + similarId + ", state="
				+ state + ", lastTotal=" + lastTotal + ", lastShotDate=" + lastShotDate + ", lastImportDate="
				+ lastImportDate + ", preSrc=" + preSrc + ", timelineFlag=" + timelineFlag + ", beginShotDate="
				+ beginShotDate + ", endShotDate=" + endShotDate + ", shotDateL=" + shotDateL + ", limitNum=" + limitNum
				+ ", thumbnailFlag=" + thumbnailFlag + ", picList=" + picList + "]";
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public Integer getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public Integer getSimilarStatus() {
		return similarStatus;
	}

	public void setSimilarStatus(Integer similarStatus) {
		this.similarStatus = similarStatus;
	}

	public String getGeox() {
		return geox;
	}

	public void setGeox(String geox) {
		this.geox = geox;
	}

	public String getGeoy() {
		return geoy;
	}

	public void setGeoy(String geoy) {
		this.geoy = geoy;
	}

	public String getGeoIsNull() {
		return geoIsNull;
	}

	public void setGeoIsNull(String geoIsNull) {
		this.geoIsNull = geoIsNull;
	}

	public Integer getSimilarType() {
		return similarType;
	}

	public void setSimilarType(Integer similarType) {
		this.similarType = similarType;
	}

	public String getSimilarIsNotEmpty() {
		return similarIsNotEmpty;
	}

	public void setSimilarIsNotEmpty(String similarIsNotEmpty) {
		this.similarIsNotEmpty = similarIsNotEmpty;
	}

	public Integer getPicCount() {
		return picCount;
	}

	public void setPicCount(Integer picCount) {
		this.picCount = picCount;
	}

	public String getShowPath() {
		return showPath;
	}

	public void setShowPath(String showPath) {
		this.showPath = showPath;
	}
}
