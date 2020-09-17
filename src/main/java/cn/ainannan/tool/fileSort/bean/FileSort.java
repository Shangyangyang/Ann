package cn.ainannan.tool.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileSort extends BaseBean {
	private String filePath;
	private String suffixs;

    private String path;
    private String name;
    private String md5;
    private String suffix;
    private Long size;
    // 1音乐2pdf
    private String type;
    private String createBy;

}