package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadlineMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false)
public class FilePdfReadlineService extends BaseService<FilePdfReadlineMapper, FilePdfReadline> {

    @Override
    public void save(FilePdfReadline entity) {
        if (entity.ifNewRecord()){
            // 先做判断
            entity.setNotZero("1");
            List<FilePdfReadline> fprList = dao.findList(entity);
            if(fprList.size() > 0){
                entity.setId(fprList.get(0).getId());
                entity.preUpdate();
                dao.update(entity);
            } else {

                entity.preInsert();
                dao.insert(entity);
            }

        }else{
            entity.preUpdate();
            dao.update(entity);
        }
    }
}