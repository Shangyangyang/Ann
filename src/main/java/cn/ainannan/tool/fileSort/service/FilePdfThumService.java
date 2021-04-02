package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.tool.fileSort.bean.FilePdfThum;
import cn.ainannan.tool.fileSort.mapper.FilePdfThumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class FilePdfThumService extends BaseService<FilePdfThumMapper, FilePdfThum> {

    @Autowired
    private FileSortService fileSortService;

    public void getImg(String id, HttpServletResponse resp) {
        FilePdfThum bean = dao.getPathById(id);
        String filePath = fileSortService.changePath(bean.getPath(), Constant.FALSE_TO_TRUE);
        returnImg(filePath, resp);
    }

    public void getImgByThum(FilePdfThum thum, HttpServletResponse resp) {
        thum.setShowPath(1);    // 显示 Path
        List<FilePdfThum> thumList = dao.findList(thum);

        if(thumList.size() < 1) return ;

        String filePath = fileSortService.changePath(thumList.get(0).getPath(), Constant.FALSE_TO_TRUE);
        returnImg(filePath, resp);
    }


    public void returnImg(String filePath, HttpServletResponse resp) {
        File file = new File(filePath);

        try {
            FileUtils.sendFile(file, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}