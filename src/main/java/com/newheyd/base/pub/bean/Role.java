package com.newheyd.base.pub.bean;

import com.google.common.collect.Lists;
import com.newheyd.base.base.BaseBean;
import com.newheyd.base.util.Collections3;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class Role extends BaseBean {

	private static final long serialVersionUID = 4068915936666290413L;

	private String name; 	// 角色名称
	private String roleCode;//角色代码
	private String roleType;// 权限类型
	private String roleTypeName;//显示名称
	private String dataScope;// 数据范围
	private String dataScopeName;// 数据范围名称
	private String useable; 		//是否可用
	private String useableName; 		//是否可用名称
    private String oldRoleCode;//旧角色代码
	private String officeCode;//部门编码
	private String officeName;//部门名称

	//private String appCode;		// 应用ID

	private String roleLevel;	// 角色等级
	private String minRoleLevel;	// 最小角色等级

	private Boolean disabled;

	private String userCode;	// 查询参数

	private List<Menu> menuList = Lists.newArrayList(); // 拥有菜单列表
	private List<Menu> menuListHalf = Lists.newArrayList(); // 拥有菜单列表

	private List<User> userList = Lists.newArrayList();//拥有用户列表
	private List<Role> roleList = Lists.newArrayList();//拥有用户列表

	// 数据范围（1：所有数据；2：所在机构及以下数据；3：所在机构数据；4：仅本人数据；5：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "2";
	public static final String DATA_SCOPE_OFFICE = "3";
	public static final String DATA_SCOPE_SELF = "4";
//	public static final String DATA_SCOPE_CUSTOM = "5";
	
	public Role() {
		super();
		//this.dataScope = DATA_SCOPE_SELF;
		//this.useable=Global.YES;
	}
	
	/*public Role(String id){
		super(id);
	}*/
	public Role(String roleCode){
		this.roleCode = roleCode;
	}

	public Role(String id, String roleCode) {
		super(id);
		this.roleCode = roleCode;
	}


	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/*
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	*/


	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getMinRoleLevel() {
		return minRoleLevel;
	}

	public void setMinRoleLevel(String minRoleLevel) {
		this.minRoleLevel = minRoleLevel;
	}

	public Role(User user) {
		this();
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}


	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

    public String getOldRoleCode() {
        return oldRoleCode;
    }

    public void setOldRoleCode(String oldRoleCode) {
        this.oldRoleCode = oldRoleCode;
    }

    @Length(min=1, max=100)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getRoleTypeName() {
		return roleTypeName;
	}

	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	public String getDataScopeName() {
		return dataScopeName;
	}

	public void setDataScopeName(String dataScopeName) {
		this.dataScopeName = dataScopeName;
	}

	public String getUseableName() {
		return useableName;
	}

	public void setUseableName(String useableName) {
		this.useableName = useableName;
	}

	public String[] getMenuCodes() {
		if( Collections3.extractToString(menuList, "code", ",")==""){
			return null;
		}
		return Collections3.extractToString(menuList, "code", ",").split(",");
	}
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	//
//	public List<String> getUserIdList() {
//		List<String> nameIdList = Lists.newArrayList();
//		for (User user : userList) {
//			nameIdList.add(user.getId());
//		}
//		return nameIdList;
//	}
//
//	public String getUserIds() {
//		return StringUtils.join(getUserIdList(), ",");
//	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getMenuListHalf() {
		return menuListHalf;
	}

	public void setMenuListHalf(List<Menu> menuListHalf) {
		this.menuListHalf = menuListHalf;
	}

	/*public List<String> getMenuIdList() {
		List<String> menuIdList = Lists.newArrayList();
		for (Menu menu : menuList) {
			menuIdList.add(menu.getId());
		}
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		menuList = Lists.newArrayList();
		for (String menuId : menuIdList) {
			Menu menu = new Menu();
			menu.setId(menuId);
			menuList.add(menu);
		}
	}


	public String getMenuIds() {
		return StringUtils.join(getMenuIdList(), ",");
	}
	
	public void setMenuIds(String menuIds) {
		menuList = Lists.newArrayList();
		if (menuIds != null){
			String[] ids = StringUtils.split(menuIds, ",");
			setMenuIdList(Lists.newArrayList(ids));
		}
	}*/
	
/*	public List<Office> getOfficeList() {
		return officeList;
	}

	public void setOfficeList(List<Office> officeList) {
		this.officeList = officeList;
	}

	public List<String> getOfficeIdList() {
		List<String> officeIdList = Lists.newArrayList();
		for (Office office : officeList) {
			officeIdList.add(office.getId());
		}
		return officeIdList;
	}

	public void setOfficeIdList(List<String> officeIdList) {
		officeList = Lists.newArrayList();
		for (String officeId : officeIdList) {
			Office office = new Office();
			office.setId(officeId);
			officeList.add(office);
		}
	}

	public String getOfficeIds() {
		return StringUtils.join(getOfficeIdList(), ",");
	}
	
	public void setOfficeIds(String officeIds) {
		officeList = Lists.newArrayList();
		if (officeIds != null){
			String[] ids = StringUtils.split(officeIds, ",");
			setOfficeIdList(Lists.newArrayList(ids));
		}
	}
	*/
	/**
	 * 获取权限字符串列表
	 */
	public List<String> getPermissions() {
		List<String> permissions = Lists.newArrayList();
		for (Menu menu : menuList) {
			if (menu.getPermission()!=null && !"".equals(menu.getPermission())){
				permissions.add(menu.getPermission());
			}
		}
		return permissions;
	}
	
	public List<String> getResources(){
		List<String> resourceList = Lists.newArrayList();
		for (Menu menu : menuList) {
			String resourceName = menu.getResourceName();
			if (resourceName != null && !"".equals(resourceName)){
				resourceList.add(resourceName);
			}
		}
		return resourceList;		
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	//	public boolean isAdmin(){
//		return isAdmin(this.id);
//	}
//	
//	public static boolean isAdmin(String id){
//		return id != null && "1".equals(id);
//	}
	
//	@Transient
//	public String getMenuNames() {
//		List<String> menuNameList = Lists.newArrayList();
//		for (Menu menu : menuList) {
//			menuNameList.add(menu.getName());
//		}
//		return StringUtils.join(menuNameList, ",");
//	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
}
