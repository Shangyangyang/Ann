package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 通知公告Entity
 * @author zhangqb
 * @version 2020-08-03
 */
public class SysNotice extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String keyword;		// 关键字
	private String type;		// 类型
	private String content;		// 内容
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;		// 日期
	private String state;		// 状态
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	
	public SysNotice() {
	}

	public SysNotice(String id){
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}