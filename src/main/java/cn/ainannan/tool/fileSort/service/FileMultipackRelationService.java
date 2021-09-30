package cn.ainannan.tool.fileSort.service;

import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.mapper.FileMultipackRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = false)
public class FileMultipackRelationService extends ServiceImpl<FileMultipackRelationMapper, FileMultipackRelation> {
    public void saveByList(FileMultipackRelation bean) {

        if(bean.getFmrList().size() > 0){

            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getFmrList().get(0).getRid());

            baseMapper.deleteById(query.getId());
            for (FileMultipackRelation fmr : bean.getFmrList()) {
                baseMapper.insert(fmr);
            }
        } else if(StringUtils.isNotBlank(bean.getDeleteAllId())){
            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getDeleteAllId());

            baseMapper.deleteById(query.getId());
        }
    }
}