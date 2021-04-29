package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FilePdfRepeat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfRepeatMapper extends BaseDao<FilePdfRepeat> {
	FilePdfRepeat getByFullQuery(FilePdfRepeat bean);
	void insertByList(List<FilePdfRepeat> list);
}
