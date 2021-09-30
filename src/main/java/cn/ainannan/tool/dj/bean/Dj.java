package cn.ainannan.tool.dj.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Dj extends BaseBean {
	private String name;
	private String path;
	private Long fileSize;
	private Integer length;
	private String type;	// 1：唯美女声2：动感串烧3：欧美金曲4：激情电音5：其它
	private String state;	// 状态
	private String xingji;	// 评分 12345星
	private String fileId;

	@TableField(exist = false)
	private List<DjSong> songList;
	@TableField(exist = false)
	private Integer songCount; // 所包含的歌曲数

}
