package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;
import org.hibernate.validator.constraints.Length;

/**
 * 公共附件生成Entity
 * @author newheyd
 * @version 2015-08-20
 */
public class Attachment extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	private String filePath;		// 附件路径
	private String fileName;		// 源文件名称
	private String fileExt;		// 扩展名
	private String newFileName;		// 新文件名称
	private Long fileSize;		// 附件大小
	private String style;		// 分类
	private String relationId;		// 关联的ID号
	private String fileRealPath;		// 附件在服务器的绝对路径
	private String officeCode;			//机构编码

	private boolean limit;

	public Attachment() {
		super();
	}

	public Attachment(String id){
		super(id);
	}


  public Attachment(String relationId, String style){
    super();
    this.relationId = relationId;
    this.style = style;
  }

	@Length(min=0, max=256, message="附件路径长度必须介于 0 和 256 之间")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Length(min=0, max=256, message="源文件名称长度必须介于 0 和 256 之间")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Length(min=0, max=32, message="扩展名长度必须介于 0 和 32 之间")
	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	
	@Length(min=0, max=64, message="新文件名称长度必须介于 0 和 64 之间")
	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	
	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Length(min=0, max=32, message="分类长度必须介于 0 和 32 之间")
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	@Length(min=0, max=64, message="关联的ID号长度必须介于 0 和 64 之间")
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	
	public String getFileRealPath() {
		return fileRealPath;
	}

	public void setFileRealPath(String fileRealPath) {
		this.fileRealPath = fileRealPath;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getName() {
		return this.fileName;
	}

	public boolean getLimit() {
		return limit;
	}

	public void setLimit(boolean limit) {
		this.limit = limit;
	}
}