package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.MyBaseService;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false)
public class FilePdfReadlineService extends MyBaseService<FilePdfReadlineMapper, FilePdfReadline> {

    @Autowired
    FilePdfReadlineMapper readlineMapper;

    @Override
    public boolean save(FilePdfReadline entity) {
        if (entity.ifNewRecord()){
            // 先做判断
            entity.setNotZero("1");
            List<FilePdfReadline> fprList = readlineMapper.findList(entity);
            if(fprList.size() > 0){
                entity.setId(fprList.get(0).getId());
                entity.preUpdate();
                baseMapper.updateById(entity);
            } else {

                entity.preInsert();
                baseMapper.insert(entity);
            }

        }else{
            entity.preUpdate();
            baseMapper.updateById(entity);
        }

        return true;
    }
}