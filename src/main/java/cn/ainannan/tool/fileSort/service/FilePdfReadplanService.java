package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadplanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class FilePdfReadplanService extends BaseService<FilePdfReadplanMapper, FilePdfReadplan> {

}