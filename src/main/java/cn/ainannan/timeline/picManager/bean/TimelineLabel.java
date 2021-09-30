package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 时光轴Entity
 * 
 * @author syy
 * @version 2018-09-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TimelineLabel extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String name;
	private String type;
	@TableField(exist = false)
	private String typeName;
	private String belong;
	@TableField(exist = false)
	private String belongName;
	private String status;
	private String reason;
	private Integer selectNum;

	@TableField(exist = false)
	private String fontcolor;
	@TableField(exist = false)
	private String bgcolor;

	@TableField(exist = false)
	private String [] ids;
	@TableField(exist = false)
	private String idstr;

}