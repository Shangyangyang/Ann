package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.tool.fileSort.bean.FileMultipack;
import cn.ainannan.tool.fileSort.mapper.FileMultipackMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false)
public class FileMultipackService extends BaseService<FileMultipackMapper, FileMultipack> {


    public ResultObject add(FileMultipack entity) {
        if(checkAdd(entity)) return ResultGen.genFailResult("该名称已经存在，请修改名称");

        entity.preInsert();
        entity.setId(UUIDUtils.generateShortUuid());

        dao.insert(entity);

        return ResultGen.genSuccessResult();
    }

    public boolean checkAdd(FileMultipack bean) {

        FileMultipack query = new FileMultipack();
        query.setFiletype(bean.getFiletype());
        query.setName(bean.getName());

        List<FileMultipack> resultList = dao.findList(query);
        return resultList != null && resultList.size() > 0;
    }
}