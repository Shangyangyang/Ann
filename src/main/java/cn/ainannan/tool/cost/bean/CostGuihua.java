package cn.ainannan.tool.cost.bean;

import cn.ainannan.base.bean.BaseBean;
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
public class CostGuihua extends BaseBean implements Serializable {
	private String name;
	private Double money;
	private String type;    // 1支出2收入
	private String fangshi; // 1循环2一次性
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date yicixingtime;
	private String cycle;   // 1年2月3周4日
	private String state;   // 1正常 2已停用
}
  