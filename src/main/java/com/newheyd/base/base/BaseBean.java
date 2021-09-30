package com.newheyd.base.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newheyd.base.pub.bean.User;
import com.newheyd.base.util.UUIDUtils;
import com.newheyd.base.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = -2248964114798996677L;

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";	
	
	protected final String dbType = "mssql";
	
	protected String sqlOrderBy = "";
	
	/**
	 * 实体编号（唯一标识）
	 */	
	protected String id;

	// 删除标记（0：正常；1：删除；2：审核）
	protected String delFlag;
	
	// 备注
	protected String remarks;
	
	// 排序
	protected Integer sort;
	
	protected String createBy;
	
	protected String updateBy;
	
	// 创建日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;

	// 更新日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateDate;

	// 是否新记录
	protected boolean isNewRecord = false;
	
	//短信通知
	protected String smsState;

	public BaseBean(){	
		this.delFlag = DEL_FLAG_NORMAL;
		this.sort = 30;
	}
	public BaseBean(String id) {
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Length(min = 1, max = 1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
		
	public boolean getifNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	public void preInsert(){
		if(this.getifNewRecord()) {
			this.id = UUIDUtils.getUUID().toUpperCase();
		}

		if(this.createBy == null){
			User user = UserUtil.getUser();
			this.createBy = user.getUserCode();
		}
		this.updateBy = this.createBy;
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	public void preUpdate(){
		User user = UserUtil.getUser();
		if (user!=null){
			this.updateBy = user.getUserCode();
		}

		this.updateDate = new Date();
	}
	
	/**
	 * 获取数据库类型
	 */
	@JsonIgnore
	public String getDbType(){		
		return this.dbType;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseBean that = (BaseBean) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }
    
	public String getSqlOrderBy() {
		return sqlOrderBy;
	}
	
	public void setSqlOrderBy(String sqlOrderBy) {
		this.sqlOrderBy = sqlOrderBy;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getSmsState() {
		return smsState;
	}
	public void setSmsState(String smsState) {
		this.smsState = smsState;
	}

}
