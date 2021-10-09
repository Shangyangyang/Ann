package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfReadplanMapper extends BaseMapper<FilePdfReadplan> {
    List<FilePdfReadplan> findList(IPage<FilePdfReadplan> page,@Param("bean") FilePdfReadplan bean);
}
