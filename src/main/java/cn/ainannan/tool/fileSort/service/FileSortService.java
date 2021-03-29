package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.bean.TongjiBean;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.Constant;
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

    public static String basePath = null;

    @Value("${myPanfu}")
    private String BASE_PANFU;

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


    /**
     * 根据type转换路径的前半部分
     * @param path
     * @param type
     * @return
     */
    public static String changePath(String path, int type) {
        String newP = null;
        if(type == Constant.FALSE_TO_TRUE){
            newP = path.replace(Constant.FILE_SORT_PATH_STR, basePath);
        } else if(type == Constant.TRUE_TO_FALSE){
            newP = path.replace(basePath, Constant.FILE_SORT_PATH_STR);
        }

        return newP;
    }

    /**
     * 根据后缀名动态的生成路径
     * @param fs
     * @param file
     * @return
     */
    public static String getPath(FileSort fs, File file) {
        String pdfStr = "pdf,";
        String musicStr = "mp3,";
        String path = null;
        String middleChar = "";
        if(pdfStr.indexOf(fs.getSuffix()) > -1){
            middleChar = File.separator + Constant.FILE_SORT_PATH_PDF;
        } else if(musicStr.indexOf(fs.getSuffix()) > -1){
            middleChar = File.separator + Constant.FILE_SORT_PATH_MUSIC;
        } else {
            System.out.println("未知后缀名： " + fs.getSuffix());
        }

        path = Constant.FILE_SORT_PATH_STR + middleChar + File.separator + fs.getName();
        return path;
    }
}