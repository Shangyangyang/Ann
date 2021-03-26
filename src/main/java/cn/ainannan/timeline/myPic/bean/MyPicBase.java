package cn.ainannan.timeline.myPic.bean;

import cn.ainannan.base.bean.BaseBean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MyPicBase extends BaseBean {
    private String shotId;
    private String filename;
    private String path;
    private String srcThumbnail;
    private String src;
    private String suffix;
    private Long size;

}
