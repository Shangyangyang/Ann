package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FileMultipack;
import cn.ainannan.tool.fileSort.mapper.FileMultipackMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class FileMultipackService extends BaseService<FileMultipackMapper, FileMultipack> {
}