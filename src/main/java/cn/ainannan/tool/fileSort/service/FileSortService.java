package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class FileSortService extends BaseService<FileSortMapper, FileSort> {

    @Value("${myPanfu}")
    private String BASE_PANFU;
    private static final String FILE_SORT_PATH = "\\尚羊羊\\fileSort";

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

        String regularExpression = "([a-zA-Z]:)+(\\\\[a-zA-Z0-9\\u4E00-\\u9FA5_.-]+)+\\\\?";


        if (StringUtils.isBlank(bean.getFilePath())
                || "".equals(bean.getFilePath().trim())
                || !bean.getFilePath().matches(regularExpression)) {
            return ResultGen.genFailResult("[filePath]格式不正确");
        }

        File fileList = new File(bean.getFilePath());

        if (!fileList.exists() || !fileList.isDirectory()) {
            return ResultGen.genFailResult("[filePath]不正确");
        }


        List<File> fList = Lists.newArrayList();
        getFileListByPath(new File(bean.getFilePath()), bean.getSuffixs(), fList);

        String basePath = BASE_PANFU + FILE_SORT_PATH + File.separator;

        // 获取数据库中，所有的文件的md5，放到map中
        String md5Strs = dao.getMd5Str();

        System.out.println("md5Strs = " + md5Strs);

        List<FileSort> fsList = Lists.newArrayList();

        for (File file : fList) {
            // file.getAbsolutePath();
            // 首先生成md5，判断数据库里有没有相同md5的
            String md5 = MD5Utils.getFileMD5(file);

            if(StringUtils.isBlank(md5Strs) || md5Strs.indexOf(md5) == -1){

                System.out.println("file = " + file.getPath());

                // 如果没有重复的，则进入下一环节，填充各种数据，insert到数据库
                FileSort fs = new FileSort();
                fs.preInsert();
                fs.setCreateBy(fs.getCreateUser().getId());
                fs.setMd5(md5);
                fs.setPath(file.getPath());
                fs.setName(file.getName());
                fs.setSuffix(FilenameUtils.getExtension(file.getAbsolutePath()));
                fs.setSize(file.length());
                fs.setType(bean.getType());

                fsList.add(fs);

            }
        }

        // 填充完毕后，进行文件移动工作
        for (FileSort fileSort : fsList) {
            try {
                FileUtils.moveFile(new File(fileSort.getPath()),
                        new File(basePath + fileSort.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 移动文件后，将新的path替换掉老的path
            fileSort.setPath(basePath + fileSort.getName());
        }

        // 批量保存
        if(fsList.size() > 0) dao.insertByList(fsList);


        // 去掉隐私信息，返回列表

        for (FileSort fileSort : fsList) {
            setFieldValueByFieldName("path", fileSort, null);
            setFieldValueByFieldName("md5", fileSort, null);
            setFieldValueByFieldName("type", fileSort, null);
        }

        return ResultGen.genSuccessResult(fsList);
    }

    /**
     * 根据属性名设置属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    private void setFieldValueByFieldName(String fieldName, Object object, String value) {
        try {
            // 获取object的字节文件对象
            Class<?> c = object.getClass();
            // 获取指定的属性名称
            Field f = c.getDeclaredField(fieldName);
            // 设置访问私有成员变量的权限为true
            f.setAccessible(true);
            // 向指定成员变量添加指定值
            f.set(object, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                if(suffixs.indexOf(FilenameUtils.getExtension(file.getAbsolutePath())) > -1){
                    fList.add(file);
                }
            }
        }

    }

    public static void main(String[] args) {
        File f = new File("F:\\360Downloads\\");
        FileSortService fss = new FileSortService();

        List<File> fList = Lists.newArrayList();
        fss.getFileListByPath(f, "mp3", fList);

        for (File file : fList) {
            System.out.println("file = " + file);
        }
    }

    private String getServicePath(FileSort bean) {

        switch (bean.getType()) {
            case "1":

                break;
        }

        return null;
    }
}