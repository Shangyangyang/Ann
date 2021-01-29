package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 环节实例
 * @author Administrator
 *
 */
public class ProceLink extends BaseBean {

	private static final long serialVersionUID = 1L;

	private ProceConfig config;
	private String name;
	private String nameL;
	private String code;
	private String codeL;
	private String status;
	private String statusName;
	private String proceStatus;
	private String proceStatusName;
	private String proceStatusNameL;
	private String beforeLink;
	private String afterLink;
	private String type;
	private String onlineCode;
	private String onlineStatus;
	private String onlineStatusName;

	public ProceLink(ProceConfig pc) {
		this.config = pc;
	}

	public ProceLink() {
		super();
	}

	public ProceLink(String id) {
		super(id);
	}

	public ProceConfig getConfig() {
		return config;
	}

	public void setConfig(ProceConfig config) {
		this.config = config;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getBeforeLink() {
		return beforeLink;
	}

	public void setBeforeLink(String beforeLink) {
		this.beforeLink = beforeLink;
	}

	public String getAfterLink() {
		return afterLink;
	}

	public void setAfterLink(String afterLink) {
		this.afterLink = afterLink;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProceStatus() {
		return proceStatus;
	}

	public void setProceStatus(String proceStatus) {
		this.proceStatus = proceStatus;
	}

	public String getProceStatusName() {
		return proceStatusName;
	}

	public void setProceStatusName(String proceStatusName) {
		this.proceStatusName = proceStatusName;
	}

	public String getOnlineCode() {
		return onlineCode;
	}

	public void setOnlineCode(String onlineCode) {
		this.onlineCode = onlineCode;
	}

	public String getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getOnlineStatusName() {
		return onlineStatusName;
	}

	public void setOnlineStatusName(String onlineStatusName) {
		this.onlineStatusName = onlineStatusName;
	}

	public String getNameL() {
		return nameL;
	}

	public void setNameL(String nameL) {
		this.nameL = nameL;
	}

	public String getCodeL() {
		return codeL;
	}

	public void setCodeL(String codeL) {
		this.codeL = codeL;
	}

	public String getProceStatusNameL() {
		return proceStatusNameL;
	}

	public void setProceStatusNameL(String proceStatusNameL) {
		this.proceStatusNameL = proceStatusNameL;
	}

}