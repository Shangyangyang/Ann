package cn.ainannan.tool.dj.bean;

import cn.ainannan.base.bean.BaseBean;

public class Song extends BaseBean {
	private String name;
	private String singer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
}
