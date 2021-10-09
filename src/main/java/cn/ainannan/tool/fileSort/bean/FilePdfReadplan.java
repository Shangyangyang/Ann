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
public class FilePdfReadplan extends BaseBean {
    private String pid;
    @TableField(exist = false)
    private FilePdf pdf;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date readStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planTime;
    private Integer planDays;
    private String state;   // 状态 0未开始计划 1开始计划 9完成计划 3已延时一次 4计划失败
    @TableField(exist = false)
    private String [] states;

    // "pdf.id", "pdf.name", "pdf.page_count", "pdf.readpage", "pdf.read_bdate", "pdf.state"


}

