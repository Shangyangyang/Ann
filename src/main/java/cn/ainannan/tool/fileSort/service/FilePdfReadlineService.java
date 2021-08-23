package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadlineMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class FilePdfReadlineService extends BaseService<FilePdfReadlineMapper, FilePdfReadline> {
}