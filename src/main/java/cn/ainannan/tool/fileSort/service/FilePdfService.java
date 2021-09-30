package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.tool.fileSort.bean.*;
import cn.ainannan.tool.fileSort.mapper.FilePdfLabelMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfThumMapper;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Service
@Transactional(readOnly = false)
public class FilePdfService extends ServiceImpl<FilePdfMapper, FilePdf> {

    @Autowired(required = false)
    private FileSortMapper fileSortMapper;
    @Autowired(required = false)
    private FilePdfThumMapper filePdfThumMapper;
    @Autowired(required = false)
    private FilePdfLabelMapper filePdfLabelMapper;
    @Autowired(required = false)
    private FileSortService fsService;

    @Value("${myPanfu}")
    private String BASE_PANFU;


    public boolean save(FilePdf entity) {
        if (entity.ifNewRecord()){
            entity.preInsert();
            baseMapper.insert(entity);
        }else{
            entity.preUpdate();
            baseMapper.updateById(entity);
            // 这里需要把labels拆解，然后保存
            if(StringUtils.isNotBlank(entity.getLabels())) saveLabels(entity.getLabels(), entity.getId());
        }
        return false;
    }

    /**
     * 保存新增的标签以及关联表
     * @param attr
     * @param pid
     */
    public void saveLabels(String attr, String pid){
        if(StringUtils.isBlank(attr)) return;
        String [] labels = attr.split(",");

        if(labels.length == 0) return;
        List<FilePdfLabel> labelList = Lists.newArrayList();
        List<FilePdfLabel> insertList = Lists.newArrayList();
        FilePdfLabel filePdfLabel = filePdfLabelMapper.getLabels();
        String labelStr = null;
        if(filePdfLabel != null) labelStr = filePdfLabel.getLabels();

        StringBuffer labelQuery = new StringBuffer();

        for (String label : labels) {
            if(StringUtils.isBlank(labelStr)){
                insertList.add(genNewObject(label));
            } else if(labelStr.indexOf(","+label+",") == -1){
                insertList.add(genNewObject(label));
            } else {
                labelQuery.append(label).append(",");
            }
        }

        // 获取已存在标签的id
        FilePdfLabel query = new FilePdfLabel();
        query.setLabels2(labelQuery.toString().split(","));

        labelList = filePdfLabelMapper.findList(query);

        // 保存新增的标签
        if(insertList.size() > 0) filePdfLabelMapper.insertByList(insertList);

        // 合并已存在与新增的List
        labelList.addAll(insertList);

        // 循环生成relationList
        List<FilePdfLabelRelation> relationList = Lists.newArrayList();

        labelList.stream().forEach(label -> {
            FilePdfLabelRelation r = new FilePdfLabelRelation();
            r.setPid(pid);
            r.setLabelid(label.getId());
            r.setDelFlag("0");

            relationList.add(r);
        });

        // 保存relationList
        if(relationList.size() > 0) insertLabelRelation(relationList);
    }

    private void insertLabelRelation(List<FilePdfLabelRelation> relationList){
        List<FilePdfLabelRelation> rList = Lists.newArrayList();

        for (FilePdfLabelRelation r : relationList) {
            // 先查询有没有，如果没有的话，加入到新增list里
            List<FilePdfLabelRelation> qList = filePdfLabelMapper.findByRelation(r);
            if(qList.size() == 0) rList.add(r);
        }

        if(rList.size() > 0) filePdfLabelMapper.insertRelationByList(rList);
    }

    private FilePdfLabel genNewObject(String label){
        FilePdfLabel labelO = new FilePdfLabel();
        labelO.preInsert();
        labelO.setId(UUIDUtils.generateShortUuid());
        labelO.setLabel(label);
        labelO.setState("0");

        return labelO;
    }

    public List<FilePdf> findAuthorList(){
        return baseMapper.findAuthorList();
    }



    public ResultObject delete(FilePdf entity) {
        // 先删除数据，再删除物理文件
        // 先删除关联，再删除pdf表数据，再删除fIle_sort表数据

        FilePdfLabelRelation query = new FilePdfLabelRelation();
        query.setPid(entity.getId());
        int i1 = filePdfLabelMapper.deleteRelationByPid(query);

        // if(i1 == 0) return ResultGen.genFailResult("删除relation数据失败！");

        int i2 = baseMapper.deleteById(entity.getId());

        if(i2 == 0) return ResultGen.genFailResult("删除pdf表数据失败！");

        FileSort queryFS = new FileSort();
        queryFS.setId(entity.getId());
        int i3 = fileSortMapper.delete(queryFS);

        if(i3 == 0) return ResultGen.genFailResult("删除file_sort_list表数据失败！");

        // 删除物理文件之前，先删除缩略图，再删除缩略图物理文件

        FilePdfThum queryFpt = new FilePdfThum();
        queryFpt.setPid(entity.getId());
        queryFpt.setShowPath(1);

        List<FilePdfThum> thumList = filePdfThumMapper.findList(queryFpt);

        filePdfThumMapper.deleteByEntity(queryFpt);

        // 删除thum物理文件
        deleteThumOfPhysical(thumList);

        // 删除物理文件
        fsService.deleteOfPhysical(entity.getId());

        return ResultGen.genSuccessResult();
    }

    public void deleteThumOfPhysical(List<FilePdfThum> thumList){

        AtomicReference<File> parentFile = new AtomicReference();
        thumList.stream().forEach(item -> {
            System.out.println("item.getPath() = " + item.getPath());

            String path = fsService.changePath(item.getPath(), Constant.FALSE_TO_TRUE);

            File file = new File(path);

            parentFile.set(file.getParentFile());

            FileUtils.deleteFile(file);
        });

        File pf = parentFile.get();

        // 删除文件夹
        FileUtils.deleteFile(pf);
    }

    public static void main(String[] args) {
        String path = "H:\\尚羊羊\\fileSort\\pdf\\thum\\eac596542a494c1d8ea1f66819d13aee\\eac596542a494c1d8ea1f66819d13aee_1.png";
        File file = new File(path);

        File parentFile = file.getParentFile();

        System.out.println("parentFile.delete() = " + parentFile.delete());
    }
}