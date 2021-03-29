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
public class FilePdf extends BaseBean {
    private String name;
    private String typef;
    private String type;
    private String author;
    private Integer pageCount;
    private String years;
    private Integer grade;
    private String state; // 0未生成thum;1已生成
}