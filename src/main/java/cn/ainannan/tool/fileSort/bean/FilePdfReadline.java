package cn.ainannan.tool.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilePdfReadline extends BaseBean {
    private String pid;
    private Date readtime;
    private Integer pagenum;
    private Double p;

    @TableField(exist = false)
    private String notZero;
}