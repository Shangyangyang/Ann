package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.mapper.FileMultipackRelationMapper;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class FileMultipackRelationService extends BaseService<FileMultipackRelationMapper, FileMultipackRelation> {
    public void saveByList(FileMultipackRelation bean) {

        if(bean.getFmrList().size() > 0){

            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getFmrList().get(0).getRid());

            dao.delete(query);
            for (FileMultipackRelation fmr : bean.getFmrList()) {
                dao.insert(fmr);
            }
        } else if(StringUtils.isNotBlank(bean.getDeleteAllId())){
            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getDeleteAllId());

            dao.delete(query);
        }
    }
}