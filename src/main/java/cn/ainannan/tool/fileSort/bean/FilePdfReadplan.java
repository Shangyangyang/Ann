package cn.ainannan.tool.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
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
public class FilePdfReadplan extends BaseBean {
    private String pid;
    private FilePdf pdf;
    private Date readStartTime;
    private Date planTime;
    private Integer planDays;
    private String state;   // 状态 0未开始计划 1开始计划 9完成计划 3已延时一次 4计划失败


}

