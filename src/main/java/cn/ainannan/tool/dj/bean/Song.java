package cn.ainannan.tool.dj.bean;

import cn.ainannan.base.bean.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song extends BaseBean {
	private String djId;
	private Integer location;
	private String name;
	private String singer;
	private String fanchang;
	private String yuanchangSinger;
	private String label;	// 标签，多选
	private Integer sort;
}
