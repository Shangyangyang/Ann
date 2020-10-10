package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.bean.TongjiBean;
import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FileSort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileSortMapper extends BaseDao<FileSort> {
	String getMd5Str();
	int insertByList(List<FileSort> fsList);
	TongjiBean getFileInfo();
}
