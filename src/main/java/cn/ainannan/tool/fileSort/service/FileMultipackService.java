package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.MyBaseService;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.tool.fileSort.bean.FileMultipack;
import cn.ainannan.tool.fileSort.mapper.FileMultipackMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false)
public class FileMultipackService extends MyBaseService<FileMultipackMapper, FileMultipack> {


    public ResultObject add(FileMultipack entity) {
        if(checkAdd(entity)) return ResultGen.genFailResult("该名称已经存在，请修改名称");

        entity.preInsert();
        entity.setId(UUIDUtils.generateShortUuid());

        baseMapper.insert(entity);

        return ResultGen.genSuccessResult();
    }

    public boolean checkAdd(FileMultipack bean) {

        FileMultipack query = new FileMultipack();
        query.setFiletype(bean.getFiletype());
        query.setName(bean.getName());

        List<FileMultipack> resultList = baseMapper.selectList(new QueryWrapper<FileMultipack>()
                .eq("file_type", bean.getFiletype()).eq("name", bean.getName()));
        return resultList != null && resultList.size() > 0;
    }
}