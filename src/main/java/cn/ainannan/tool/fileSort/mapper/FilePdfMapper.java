package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfMapper extends BaseDao<FilePdf> {
	void insertBySortId();
	void insertRepeat(FilePdf bean);
    void updateByList(List<FilePdf> savePdfList);
    List<FilePdf> findAuthorList();
    List<FilePdf> findSimpleList(FilePdf bean);
}
