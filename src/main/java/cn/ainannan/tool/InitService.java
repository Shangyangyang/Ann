package cn.ainannan.tool;

import cn.ainannan.commons.Constant;
import cn.ainannan.sys.utils.ImageUtil;
import cn.ainannan.sys.utils.PdfToImage;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import cn.ainannan.tool.fileSort.bean.FilePdfRepeat;
import cn.ainannan.tool.fileSort.bean.FilePdfThum;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.mapper.FilePdfMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfRepeatMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfThumMapper;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import cn.ainannan.tool.fileSort.service.FileSortService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 统一管理启动函数
 * 1. insertBySortId
 *      将新增的PDF文件更新到PDF表里
 * 2. genThum
 *      读出PDF，获取页数，生成多张缩略图
 * 3. comparePdf
 *      比较判断数据库里已解析过的文件，循环找出可能重复的文件，放到比较表里。
 */
@Service
public class InitService {

    private static final String STATE_UN_GEN = "0";
    private static final String STATE_GENED = "1";

    @Value("${myPanfu}")
    private String BASE_PANFU;

    @Autowired(required = false)
    private FilePdfMapper filePdfMapper;
    @Autowired(required = false)
    private FileSortService fileSortService;
    @Autowired(required = false)
    private FileSortMapper fileSortMapper;
    @Autowired(required = false)
    private FilePdfThumMapper filePdfThumMapper;
    @Autowired(required = false)
    private FilePdfRepeatMapper filePdfRepeatMapper;

    /**
     * 将新增的PDF文件更新到PDF表里
     */
    // @PostConstruct
    private void insertBySortId(){
        filePdfMapper.insertBySortId();
    }

    /**
     * 读出PDF，获取页数，生成多张缩略图
     */
    // @PostConstruct
    private void genThum() throws IOException {

        FileSortService.basePath = BASE_PANFU + Constant.FILE_SORT_PATH + File.separator;

        FilePdf query = new FilePdf();
        query.setState(STATE_UN_GEN);

        List<FilePdf> fpList = filePdfMapper.findList(query);

        if(fpList.size() == 0) {
            System.out.println("本次没有可生成的PDF");
            return;
        }

        List<FilePdf> savePdfList = Lists.newArrayList();
        List<FilePdfThum> savePdfThumList = Lists.newArrayList();

        for (FilePdf filePdf : fpList) {
            List<FilePdfThum> thumTempList = Lists.newArrayList();

            FileSort fs = fileSortMapper.get(filePdf.getId());
            String realPath = fileSortService.changePath(fs.getPath(), Constant.FALSE_TO_TRUE);

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
                thum.setPath(fileSortService.changePath(thum.getPath(), Constant.TRUE_TO_FALSE));
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
        if(savePdfList.size() > 0) filePdfMapper.updateByList(savePdfList);



    }

    /**
     * 把图片生成成缩略图，最大分辨率300
     * @param filePathList
     * @return
     */
    private void genThumImg(List<FilePdfThum> filePathList){

        List<FilePdfThum> thumList = Lists.newArrayList();

        for (FilePdfThum thum : filePathList) {
            String s = thum.getPath();
            int lastDot = s.lastIndexOf(".");
            String filepathPre = s.substring(0, lastDot);
            String suffix = s.substring(lastDot + 1);
            String newPath = filepathPre + "_thum" + "." + suffix;

            // 缩略图片，把假路径换成真的
            ImageUtil.genThumbnail(
                    fileSortService.changePath(s, Constant.FALSE_TO_TRUE),
                    fileSortService.changePath(newPath, Constant.FALSE_TO_TRUE)
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

    /**
     * 比较判断数据库里已解析过的文件，循环找出可能重复的文件，放到比较表里。
     */
    @PostConstruct
    public void comparePdf(){
        System.out.println("comparePdf 开始执行");

        FilePdf queryFilePdf = new FilePdf();
        queryFilePdf.setState("2");     // 已解析

        List<FilePdf> pdfList = filePdfMapper.findSimpleList(queryFilePdf);

        /**
         * 打分制
         * md5 50分
         * 名字 30分
         * 大小 20分
         */

        List<FilePdf> resultMd5List = Lists.newArrayList();
        List<FilePdf> resultNameList = Lists.newArrayList();
        List<FilePdf> resultSizeList = Lists.newArrayList();
        List<FilePdfRepeat> saveList = Lists.newArrayList();

        for (FilePdf pdf1 : pdfList) {
            resultMd5List = pdfList.stream().filter(
                    pdf2 -> (!pdf1.getId().equals(pdf2.getId())) && pdf1.getMd5().equals(pdf2.getMd5())
            ).collect(Collectors.toList());

            resultNameList = pdfList.stream().filter(
                    pdf2 -> (!pdf1.getId().equals(pdf2.getId())) && pdf1.getName().equals(pdf2.getName())
            ).collect(Collectors.toList());

            resultSizeList = pdfList.stream().filter(
                    pdf2 -> (!pdf1.getId().equals(pdf2.getId())) && (pdf1.getSize() == pdf2.getSize())
            ).collect(Collectors.toList());

            addList(resultMd5List, saveList, pdf1.getId(), "1");
            addList(resultNameList, saveList, pdf1.getId(), "2");
            addList(resultSizeList, saveList, pdf1.getId(), "3");

            System.out.println("saveList = " + saveList.size());
        }

        // 新增前先判断repeat是否存在
        if(saveList.size() > 0){
            List<FilePdfRepeat> newSaveList = Lists.newArrayList();
            // 循环查询数据是否已经存在
            for (FilePdfRepeat filePdf : saveList) {
                FilePdfRepeat result = filePdfRepeatMapper.getByFullQuery(filePdf);
                if(result == null) newSaveList.add(filePdf);
            }

            System.out.println("newSaveList.size() = " + newSaveList.size());
            if(newSaveList.size() > 0){
                // 批量保存
                filePdfRepeatMapper.insertByList(newSaveList);
            }
        }

    }

    private void addList(List<FilePdf> sourceList, List<FilePdfRepeat> targetList,String pid1, String type){
        if(sourceList.size() > 0){

            FilePdfRepeat fp = null;

            for (FilePdf filePdf : sourceList) {
                fp = new FilePdfRepeat();
                fp.setPid1(pid1);
                fp.setPid2(filePdf.getId());
                fp.setType(type);
            }

            targetList.add(fp);
        }
    }
}
