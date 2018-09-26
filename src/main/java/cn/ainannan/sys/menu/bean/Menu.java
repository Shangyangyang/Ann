package cn.ainannan.sys.menu.bean;


import org.springframework.stereotype.Component;

import cn.ainannan.base.bean.BaseBean;

@Component
public class Menu extends BaseBean {
	private String parentId;
	private String url;
	private String name;
	private Integer count;
	private Integer sort;
	private String fatherMenu; // 是不是父菜单

	public Menu() {
		super();
	}

	public Menu(String id) {
		super(id);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFatherMenu() {
		return fatherMenu;
	}

	public void setFatherMenu(String fatherMenu) {
		this.fatherMenu = fatherMenu;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
