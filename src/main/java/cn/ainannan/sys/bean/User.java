package cn.ainannan.sys.bean;

import cn.ainannan.base.bean.BaseBean;

public class User extends BaseBean {

	private String userName;
	private String password;
	private String name;
	private String state;
	private String stateName;
	private Boolean isAdmin;
	
	// 验证码
	private String reg;
	
	// ip
	private String ip;
	

	
	public User() {
		super();
	}

	public User(String id) {
		super(id);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isAdmin() {
        this.isAdmin = isAdmin(this.id);
        return this.isAdmin;
    }

    public static boolean isAdmin(String id) {
        return id != null && "10000000000000000000000000000000".equals(id);
    }

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
