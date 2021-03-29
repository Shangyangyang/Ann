package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import org.springframework.stereotype.Repository;

@Repository
public interface FilePdfMapper extends BaseDao<FilePdf> {
	void insertBySortId();
}
