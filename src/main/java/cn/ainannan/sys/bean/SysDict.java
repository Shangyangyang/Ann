package cn.ainannan.sys.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class SysDict implements Serializable {
	private String label;
	private String value;
	private String name;
	private Integer sort;

	@TableField(exist = false)
	private Boolean checked;	// 选中状态

	protected String id;
	protected String createUser;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;
	protected String updateUser;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateDate;
	protected String delFlag;

	@TableField(exist = false)
	protected final String dbType = "mysql";
	@TableField(exist = false)
	protected String sqlOrderBy = "";

}
