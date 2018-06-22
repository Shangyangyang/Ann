package cn.ainannan.commons.gen.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.commons.gen.bean.GenTable;
import cn.ainannan.commons.gen.mapper.GenTableMapper;

@Service
public class GenTableService extends CrudService<GenTableMapper, GenTable>{
}
