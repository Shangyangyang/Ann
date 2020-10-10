package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.bean.TongjiBean;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.utils.UserUtil;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import cn.ainannan.tool.fileSort.thread.FileSortThread;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class FileSortService extends BaseService<FileSortMapper, FileSort> {

    @Value("${myPanfu}")
    private String BASE_PANFU;
    private static final String FILE_SORT_PATH = "\\尚羊羊\\fileSort";


    public TongjiBean getFileInfo(){
        return dao.getFileInfo();
    }

    public ResultObject findFileList(FileSort bean) {
        /**
         * 查询出指定文件夹下的所有文件
         * 遍历筛选出指定后缀名的文件
         * 按路径排序
         * ==============
         * 填充必要字段，insert到数据库
         * ==============
         * 返回List[id, name, new_name, suffix, size]
         *
         */


        String regularExpression = "([a-zA-Z]:)+(\\\\[a-zA-Z0-9\\u4E00-\\u9FA5_.-\\\\(\\\\)]+)+\\\\?";


//        if (StringUtils.isBlank(bean.getFilePath())
//                || "".equals(bean.getFilePath().trim())
//                || !bean.getFilePath().matches(regularExpression)) {
//            return ResultGen.genFailResult("[filePath]格式不正确");
//        }

        File fileList = new File(bean.getFilePath());

        if (!fileList.exists() || !fileList.isDirectory()) {
            return ResultGen.genFailResult("[filePath]不正确");
        }


        // 获取符合条件的文件集合
        List<File> fList = Lists.newArrayList();
        getFileListByPath(new File(bean.getFilePath()), bean.getSuffixs(), fList);

        new FileSortThread(bean, fList, UserUtil.getUser()).start();

        return ResultGen.genSuccessResult("本次共有" + fList.size() + "个文件需要处理，请稍候");
    }

    /**
     * 递归获取指定文件夹下的指定后缀名的文件
     * @param file
     * @param suffixs
     * @param fList
     */
    private static void getFileListByPath(File file, String suffixs, List<File> fList) {
        if(file.exists()){
            if(file.isDirectory()){
                File [] files = file.listFiles();

                for (File f : files) {
                    getFileListByPath(f, suffixs, fList);
                }

            } else {
                if(suffixs.indexOf(FilenameUtils.getExtension(file.getAbsolutePath()).toLowerCase()) > -1){
                    fList.add(file);
                }
            }
        }

    }
}