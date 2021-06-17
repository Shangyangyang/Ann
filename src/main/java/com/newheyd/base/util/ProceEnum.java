package com.newheyd.base.util;

public enum ProceEnum {
	AREALEVEL_SHI("2"), 
	AREALEVEL_QU("3"), ;

	private String value;

	private ProceEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
