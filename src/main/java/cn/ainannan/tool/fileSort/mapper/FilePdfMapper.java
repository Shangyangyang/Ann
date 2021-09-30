package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.tool.fileSort.bean.FilePdf;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfMapper extends BaseMapper<FilePdf> {
	void insertBySortId();
	void insertRepeat(FilePdf bean);
    void updateByList(List<FilePdf> savePdfList);
    List<FilePdf> findAuthorList();
    List<FilePdf> findSimpleList(FilePdf bean);
}
