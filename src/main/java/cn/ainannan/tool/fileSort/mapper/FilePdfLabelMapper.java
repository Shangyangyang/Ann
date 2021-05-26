package cn.ainannan.tool.fileSort.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.fileSort.bean.FilePdfLabel;
import cn.ainannan.tool.fileSort.bean.FilePdfLabelRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePdfLabelMapper extends BaseDao<FilePdfLabel> {
    FilePdfLabel getLabels();
    int insertByList(List<FilePdfLabel> labelList);
    int insertRelationByList(List<FilePdfLabelRelation> relationList);
    int deleteRelationByPid(FilePdfLabelRelation bean);
    List<FilePdfLabelRelation> findByRelation(FilePdfLabelRelation bean);
}
