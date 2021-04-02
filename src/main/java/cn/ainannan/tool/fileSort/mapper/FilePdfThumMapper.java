package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FilePdfThum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfThumMapper extends BaseDao<FilePdfThum> {
    int insertByList(List<FilePdfThum> fptList);
    FilePdfThum getPathById(String id);
}
