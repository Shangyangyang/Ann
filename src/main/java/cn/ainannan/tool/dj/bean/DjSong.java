package cn.ainannan.tool.dj.bean;

import cn.ainannan.base.bean.BaseBean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DjSong extends BaseBean {
	private String djId;
	private Integer location;
	private String name;
	private String singer;
	private String singerPy;
	private String fanchang;
	private String yuanchangSinger;
	private String label;	// 标签，多选
	private Integer sort;
}
