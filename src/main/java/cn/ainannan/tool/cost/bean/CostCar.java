package cn.ainannan.tool.cost.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CostCar implements Serializable {
	@Excel(name = "金额", orderNum="1")
	private Double money;
	@Excel(name = "类型", orderNum="2", replace= {"油费_1", "过路费_2", "罚款_3", "保险_4", "其它_5"})
	private String carType;
	private String type;
	// private String typeName;
	@Excel(name = "里程数", orderNum="3")
	private Integer licheng;
	@Excel(name = "油价", orderNum="4")
	private Double youjia;
	@Excel(name = "说明", orderNum="6")
	private String reason;
	@Excel(name = "日期", orderNum="5")
	private String inputDate;
	@TableField(exist = false)
	private String niandu;

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
