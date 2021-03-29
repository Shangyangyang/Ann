package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.mapper.FilePdfMapper;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class FilePdfService extends BaseService<FilePdfMapper, FilePdf> {

    private static final String STATE_UN_GEN = "0";
    private static final String STATE_GENED = "1";

    @Autowired(required = false)
    private FileSortMapper fileSortMapper;

    // 将新增的PDF文件更新到PDF表里
    @PostConstruct
    private void insertBySortId(){
        dao.insertBySortId();
    }


    /**
     * 读出PDF，获取页数，生成三张缩略图
     */
    @PostConstruct
    private void genThum(){
        FilePdf query = new FilePdf();
        query.setState(STATE_UN_GEN);

        List<FilePdf> fpList = dao.findList(query);

        System.out.println("fpList.size() = " + fpList.size());

        for (FilePdf filePdf : fpList) {
            System.out.println("filePdf.getName() = " + filePdf.getName());

            FileSort fs = fileSortMapper.get(filePdf.getId());

            System.out.println("fs.getPath() = " + fs.getPath());


        }

    }
}