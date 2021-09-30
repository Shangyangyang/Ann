package cn.ainannan.tool.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilePdf extends BaseBean {
    private String name;
    private String bookname;

    private String typef;
    private String type;
    private String author;
    private Integer pageCount;
    private String years;
    private Integer grade;
    private String state; // 0未生成thum1未解析2已解析
    @TableField(exist = false)
    private Long size;

    @TableField(exist = false)
    private String oldName;
    private String country;
    private String translator;
    private String press;
    @TableField(exist = false)
    private String labels;  // 标签

    @TableField(exist = false)
    private String md5;
    @TableField(exist = false)
    private String showMd5;
    private Integer readpage;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    private Date readBdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    private Date readEdate;

    @TableField(exist = false)
    private Integer isRead; // 权限控制，1 是阅读相关
    @TableField(exist = false)
    private FilePdfReadline readline;
    @TableField(exist = false)
    private String excludeExisting; // 1过滤已经在阅读计划的数据

    // 扩展字段
    @TableField(exist = false)
    private String multipacks; // 已加入的合集们



}