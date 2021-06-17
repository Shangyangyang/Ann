package com.newheyd.base.pub.bean;

import com.newheyd.base.base.BaseBean;
import com.newheyd.base.util.Collections3;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class Dict extends BaseBean {

	private static final long serialVersionUID = -8952290503013992998L;
	
	private String value;	// 数据值
	private String label;	// 标签名
	
	private String type;	// 类型	
	private String description;// 描述

	private String parentValues;

	private String parentType;

	//用于显示下级字典
	private List<Dict> children;

	//用于处理前端传过来的子字典项value
	private String [] childIds;
	//判断是增加字典项还是增加字典项键值，“0”增加字典项，“1”增加字典项键值
	private String checkButton;
	private String  valueLike;//用于value模糊查询

	public Dict() {
		super();
	}
	
	public Dict(String id){
		super(id);
	}
	
	public Dict(String value, String label){
		this.value = value;
		this.label = label;
	}
	
	@Length(min=1, max=100)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Length(min=1, max=100)
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Length(min=1, max=100)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min=0, max=100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentValues() {
		return parentValues;
	}

	public void setParentValues(String parentValues) {
		this.parentValues = parentValues;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public List<Dict> getChildren() {
		return children;
	}

	public void setChildren(List<Dict> children) {
		this.children = children;
	}

	public String [] getChildIds(){
		if(children==null|| Collections3.extractToString(children, "id", ",")==""){
		return null;
		}
		return  Collections3.extractToString(children, "id", ",").split(",");
	}

	/*子字典项value数组，用","分割*/
	public String[] getChildValues() {
		if(children==null|| Collections3.extractToString(children, "value", ",")==""){
			return null;
		}
		return Collections3.extractToString(children, "value", ",").split(",");
	}

	public String getCheckButton() {
		return checkButton;
	}

	public void setCheckButton(String checkButton) {
		this.checkButton = checkButton;
	}

	public String getValueLike() {
		return valueLike;
	}

	public void setValueLike(String valueLike) {
		this.valueLike = valueLike;
	}
}