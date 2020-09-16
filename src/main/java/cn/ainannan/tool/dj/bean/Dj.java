package cn.ainannan.tool.dj.bean;

import java.util.List;

import cn.ainannan.base.bean.BaseBean;

public class Dj extends BaseBean {
	private String name;
	private List<Song> songList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
}
