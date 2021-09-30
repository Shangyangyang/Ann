package cn.ainannan.timeline.picManager.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TimelinePic extends BaseBean implements Serializable {

	private static final Integer SIMILAR_PASS_LINE = 99;

	private String shortId;
	private String filename;
	private String path;
	private String src;
	private String srcThumbnail;
	private String suffix;
	private Long fileSize;
	private String md5;
	private String fingerPrint;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date shotDate;
	private String similarId;
	private Integer similarStatus;
	private String state;
	private String belong; // 归属1雪碧2乐乐

	private String geox;
	private String geoy;

	@TableField(exist = false)
	private int distance; // 相距距离（米）

	@TableField(exist = false)
	private Double similarity; // 相似度最高100

	// 三个统计字段
	@TableField(exist = false)
	private String lastTotal; // 最新总数
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date lastShotDate; // 最新拍摄日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date lastImportDate; // 最近导入日期

	@TableField(exist = false)
	private String preSrc; // 查询参数，以src进行模糊查询
	@TableField(exist = false)
	private String timelineFlag; // 不为空则进行与timeline表的exists查询

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date beginShotDate; // 起始拍摄日期

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date endShotDate; // 结束拍摄日期

	// 查询参数
	@TableField(exist = false)
	private String shotDateL; // Like查询拍摄日期
	@TableField(exist = false)
	private Integer limitNum; // 查询页数
	@TableField(exist = false)
	private Integer limitCount; // 查询条数
	@TableField(exist = false)
	private String thumbnailFlag; // 0：srcThumbnail为空
	@TableField(exist = false)
	private Integer similarType;	// 1指纹2直方图
	@TableField(exist = false)
	private String similarIsNotEmpty;	// 1是
	@TableField(exist = false)
	private String geoIsNull; // geo是否为空1是0否
	@TableField(exist = false)
	private String showPath;	// 是否查询path src
	@TableField(exist = false)
	private Integer bSize;
	@TableField(exist = false)
	private Integer eSize;
	@TableField(exist = false)
	private String notId;   // 不包含的ID


	@TableField(exist = false)
	private Integer picCount; // 去重模块用到的统计字段，重复图片数

	@TableField(exist = false)
	private List<TimelinePic> picList;
}
