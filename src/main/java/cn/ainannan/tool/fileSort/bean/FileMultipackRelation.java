package cn.ainannan.tool.fileSort.bean;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileMultipackRelation extends BaseBean {
    private String mid;
    private String rid;
    private Integer sort;

    // 查询参数
    @TableField(exist = false)
    private String deleteAllId; // 根据rid删除所有合集关联
    @TableField(exist = false)
    private String list;        // 前端传递过来的json集合
    @TableField(exist = false)
    private List<FileMultipackRelation> fmrList;
}