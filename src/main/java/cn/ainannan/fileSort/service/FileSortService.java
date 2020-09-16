package cn.ainannan.fileSort.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.fileSort.bean.FileSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;


@Service
@Transactional(readOnly = true)
public class FileSortService{

    public ResultObject findFileList(FileSort bean) {
        /**
         * 查询出指定文件夹下的所有文件
         * 遍历筛选出指定后缀名的文件
         * 按路径排序
         * 返回List
         *
         */

        String regularExpression = "([a-zA-Z]:)+(\\\\[a-zA-Z0-9_.-]+)+\\\\?";


        if(StringUtils.isBlank(bean.getFilePath())
                || "".equals(bean.getFilePath().trim())
                || !bean.getFilePath().matches(regularExpression)){
            return ResultGen.genFailResult("[filePath]格式不正确");
        }
        
        File file = new File(bean.getFilePath());
        
        if(!file.exists() || !file.isDirectory()){
            return ResultGen.genFailResult("[filePath]不正确");
        }

        String[] files = file.list();

        

        for (String s : files) {
            System.out.println("s = " + s);


        }
        


        return ResultGen.genFailResult("未知错误");
    }
}