package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 信息发布管理Entity
 * @author zhangqb
 * @version 2020-11-24
 */
public class SysInfoPublish extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	private String areaCode;
	private String classify;		// 分类
	private String type;		// 类型
	private String title;		// 标题
	private String keyword;		// 关键字
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;		// 发布日期
	private String content;		// 内容
	private String state;		// 状态
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginPublishDate;		// 开始 发布日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endPublishDate;		// 结束 发布日期

	private String linkUrl;

	public SysInfoPublish() {
	}

	public SysInfoPublish(String id){
		super(id);
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Length(min=0, max=8, message="分类长度必须介于 0 和 8 之间")
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	@Length(min=0, max=8, message="类型长度必须介于 0 和 8 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="标题长度必须介于 0 和 64 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=64, message="关键字长度必须介于 0 和 64 之间")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBeginPublishDate() {
		return beginPublishDate;
	}

	public void setBeginPublishDate(Date beginPublishDate) {
		this.beginPublishDate = beginPublishDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndPublishDate() {
		return endPublishDate;
	}

	public void setEndPublishDate(Date endPublishDate) {
		this.endPublishDate = endPublishDate;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
}