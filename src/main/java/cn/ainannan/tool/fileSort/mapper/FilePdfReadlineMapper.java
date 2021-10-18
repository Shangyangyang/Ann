package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfReadlineMapper extends BaseMapper<FilePdfReadline> {
    List<FilePdfReadline> findList(FilePdfReadline bean);
}
