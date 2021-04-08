package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.sys.utils.ImageUtil;
import cn.ainannan.sys.utils.PdfToImage;
import cn.ainannan.tool.fileSort.bean.*;
import cn.ainannan.tool.fileSort.mapper.FilePdfLabelMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfThumMapper;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class FilePdfService extends BaseService<FilePdfMapper, FilePdf> {

    private static final String STATE_UN_GEN = "0";
    private static final String STATE_GENED = "1";

    @Autowired(required = false)
    private FileSortMapper fileSortMapper;
    @Autowired(required = false)
    private FilePdfThumMapper filePdfThumMapper;
    @Autowired(required = false)
    private FilePdfLabelMapper filePdfLabelMapper;

    @Value("${myPanfu}")
    private String BASE_PANFU;

    // 将新增的PDF文件更新到PDF表里
    //@PostConstruct
    private void insertBySortId(){
        dao.insertBySortId();
    }


    @Override
    public void save(FilePdf entity) {
        if (entity.isNewRecord()){
            entity.preInsert();
            dao.insert(entity);
        }else{
            entity.preUpdate();
            dao.update(entity);
            // 这里需要把labels拆解，然后保存
            saveLabels(entity.getLabels(), entity.getId());
        }

    }

    /**
     * 保存新增的标签以及关联表
     * @param attr
     * @param pid
     */
    public void saveLabels(String attr, String pid){
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
        if(relationList.size() > 0) filePdfLabelMapper.insertRelationByList(relationList);
    }

    private FilePdfLabel genNewObject(String label){
        FilePdfLabel labelO = new FilePdfLabel();
        labelO.preInsert();
        labelO.setId(UUIDUtils.generateShortUuid());
        labelO.setLabel(label);
        labelO.setState("0");

        return labelO;
    }

    /**
     * 读出PDF，获取页数，生成三张缩略图
     */
    @PostConstruct
    private void genThum() throws IOException {

        FileSortService.basePath = BASE_PANFU + Constant.FILE_SORT_PATH + File.separator;

        FilePdf query = new FilePdf();
        query.setState(STATE_UN_GEN);

        List<FilePdf> fpList = dao.findList(query);

        if(fpList.size() == 0) {
            System.out.println("本次没有可生成的PDF");
            return;
        }

        List<FilePdf> savePdfList = Lists.newArrayList();
        List<FilePdfThum> savePdfThumList = Lists.newArrayList();

        for (FilePdf filePdf : fpList) {
            List<FilePdfThum> thumTempList = Lists.newArrayList();

            FileSort fs = fileSortMapper.get(filePdf.getId());
            String realPath = FileSortService.changePath(fs.getPath(), Constant.FALSE_TO_TRUE);


            // 缩略图地址
            String thumPath =
                    FileSortService.basePath
                    + File.separator
                    + Constant.FILE_SORT_PATH_PDF
                    + File.separator
                    + Constant.FILE_SORT_PATH_PDF_THUM;

            PdfToImage.pdf2Image(realPath, thumPath, thumTempList);
            genThumImg(thumTempList);

            // ================  改变Pdf数据的状态，填充数据===========
            FilePdf saveFp = new FilePdf();

            saveFp.setId(filePdf.getId());
            saveFp.setState(STATE_GENED);
            saveFp.setPageCount(PdfToImage.getPdfPageNumByPath(realPath));
            saveFp.preUpdate();
            savePdfList.add(saveFp);
            // ================  改变Pdf数据的状态，填充数据===========

            // ================= pdfThum 填充数据
            for (FilePdfThum thum : thumTempList) {
                thum.setPid(filePdf.getId());
                thum.setPath(FileSortService.changePath(thum.getPath(), Constant.TRUE_TO_FALSE));
            }

            // ================= pdfThum 填充数据

            savePdfThumList.addAll(thumTempList);
        }

        int max = 100;
        if(savePdfThumList.size() > 0){
            if (savePdfThumList.size() > max) {
                for (int i = 0; i < savePdfThumList.size(); i += max) {
                    filePdfThumMapper.insertByList(
                            savePdfThumList.subList(
                                    i,
                                    savePdfThumList.size() < i + max ?
                                            savePdfThumList.size() : i + max
                            )
                    );
                }
            } else {
                filePdfThumMapper.insertByList(savePdfThumList);
            }
        }
        if(savePdfList.size() > 0) dao.updateByList(savePdfList);



    }

    /**
     * 把图片生成成缩略图，最大分辨率300
     * @param filePathList
     * @return
     */
    private static void genThumImg(List<FilePdfThum> filePathList){

        List<FilePdfThum> thumList = Lists.newArrayList();

        for (FilePdfThum thum : filePathList) {
            String s = thum.getPath();
            int lastDot = s.lastIndexOf(".");
            String filepathPre = s.substring(0, lastDot);
            String suffix = s.substring(lastDot + 1);
            String newPath = filepathPre + "_thum" + "." + suffix;

            // 缩略图片，把假路径换成真的
            ImageUtil.genThumbnail(
                    FileSortService.changePath(s, Constant.FALSE_TO_TRUE),
                    FileSortService.changePath(newPath, Constant.FALSE_TO_TRUE)
            );

            // 生成数据
            FilePdfThum thumT = new FilePdfThum();
            thumT.preInsert();
            thumT.setPagenum(thum.getPagenum());
            thumT.setPath(newPath);
            thumT.setIsthum(Constant.YES);

            thumList.add(thumT);
        }

        filePathList.addAll(thumList);
    }

//    public static void main(String[] args) {
//        List<String> list = Lists.newArrayList();
//
//        list.add("aaaaaaaaaaaaaaaaaaa.jpg");
//        list.add("bbbbbb.abc.mp3");
//
//        List<String> newList = genThumImg(list);
//
//        System.out.println("========================");
//
//        for (String s : newList) {
//            System.out.println("s = " + s);
//        }
//
//    }
}