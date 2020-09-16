package cn.ainannan.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileSort extends BaseBean {
	private String filePath;
	private String suffixs;

	private String fileName;
	private String fileSrc;
}