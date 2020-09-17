package cn.ainannan.base.bean;

import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.utils.UserUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Component
public abstract class BaseBean implements Serializable {
	protected String id;
	protected User createUser;
	// protected String createBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;
	protected User updateUser;
	// protected String updateBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateDate;
	protected String delFlag;
	
	protected final String dbType = "mysql";
	
	protected String sqlOrderBy = "";
	
	public BaseBean() {

	}

	public BaseBean(String id) {
		this();
		this.id = id;
	}

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";

	/**
	 * 新增数据前生成ID，创建时间，创建人。
	 */
	public void preInsert() {
		this.setId(UUID.randomUUID().toString().replace("-", ""));
		Date d = new Date();
		this.setCreateDate(d);
		this.setCreateUser(UserUtil.getUser());
		//this.setCreateBy(UserUtil.getUser().getId());
		this.setUpdateDate(d);
		this.setUpdateUser(UserUtil.getUser());
		//this.setUpdateBy(UserUtil.getUser().getId());
		this.setDelFlag(DEL_FLAG_NORMAL);
	}

	public void preUpdate() {
		this.setUpdateDate(new Date());
		this.setUpdateUser(UserUtil.getUser());
	}
	
	public boolean isNewRecord() {
		 return StringUtils.isEmpty(this.getId());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

//	public String getCreateBy() {
//		return createBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
//
//	public String getUpdateBy() {
//		return updateBy;
//	}
//
//	public void setUpdateBy(String updateBy) {
//		this.updateBy = updateBy;
//	}
}
