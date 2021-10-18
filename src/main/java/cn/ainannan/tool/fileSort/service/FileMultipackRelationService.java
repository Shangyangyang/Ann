package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.MyBaseService;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.mapper.FileMultipackRelationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;


@Service
@Transactional(readOnly = false)
public class FileMultipackRelationService extends MyBaseService<FileMultipackRelationMapper, FileMultipackRelation> {
    public void saveByList(FileMultipackRelation bean, HttpServletRequest request) {

        QueryWrapper<FileMultipackRelation> queryWrapper = QueryGenerator.initQueryWrapper(bean, request.getParameterMap());

        if(bean.getFmrList().size() > 0){

            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getFmrList().get(0).getRid());

            baseMapper.delete(queryWrapper);
            for (FileMultipackRelation fmr : bean.getFmrList()) {
                baseMapper.insert(fmr);
            }
        } else if(StringUtils.isNotBlank(bean.getDeleteAllId())){
            FileMultipackRelation query = new FileMultipackRelation();
            query.setRid(bean.getDeleteAllId());

            baseMapper.delete(queryWrapper);
        }
    }
}