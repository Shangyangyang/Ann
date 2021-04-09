package cn.ainannan.tool.fileSort.thread;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.utils.SpringContextUtil;
import cn.ainannan.sys.websocket.WebSocketUtil;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.mapper.FileSortMapper;
import cn.ainannan.tool.fileSort.service.FileSortService;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FileSortThread extends Thread {

    private FileSort bean;
    private List<File> fList;
    private User user;

    public FileSortThread(FileSort bean, List<File> fList, User user) {
        this.bean = bean;
        this.fList = fList;
        this.user = user;
    }

    @Transactional(readOnly = false)
    public void run() {
        FileSortMapper fsMapper = (FileSortMapper) SpringContextUtil.getBean("fileSortMapper");
        String basePanfu = SpringContextUtil.getApplicationContext().getEnvironment().getProperty("myPanfu");
        // websocket前来报道

        // 记录执行记录
        StringBuffer logSb = new StringBuffer();
        int successNum = 0;
        int failNum = 0;
        Long startT = new Date().getTime();

        FileSortService.basePath = basePanfu + Constant.FILE_SORT_PATH + File.separator;


        // 获取数据库中，所有的文件的md5，放到map中
        String md5Strs = fsMapper.getMd5Str();

        List<FileSort> fsList = Lists.newArrayList();

        logSb.append("本次共搜索到").append(fList.size()).append("个文件，");


        for (File file : fList) {
            // file.getAbsolutePath();
            // 首先生成md5，判断数据库里有没有相同md5的
            String md5 = MD5Utils.getFileMD5(file);

            if(StringUtils.isBlank(md5Strs) || md5Strs.indexOf(md5) == -1){

                // 在目标文件夹下查找是否文件是否存在，如果存在，则进行重命操作
                String fileName = checkAndGenPath(FileSortService.basePath, file.getPath(), file.getName());
                System.gc();

                successNum++;

                // 如果没有重复的，则进入下一环节，填充各种数据，insert到数据库
                FileSort fs = new FileSort();

                fs.setId(UUID.randomUUID().toString().replace("-", ""));
                Date d = new Date();
                fs.setCreateDate(d);
                fs.setDelFlag("0");
                fs.setCreateBy(user.getId());
                fs.setMd5(md5);
                fs.setSuffix(FilenameUtils.getExtension(file.getAbsolutePath()));
                fs.setName(fs.getId() + "." + fs.getSuffix());
                fs.setOldName(fileName);
                fs.setOldPath(file.getPath());
                fs.setSize(new File(file.getParent() + File.separator + fileName).length());
                fs.setType(bean.getType());
                fs.setPath(FileSortService.getPath(fs, file));
                
                fsList.add(fs);

            } else {
                failNum++;
                file.delete();
            }
            
            // 临时增加耗时，看效果
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            // 推送进度
            WebSocketUtil.sendObj(
                    user.getUserName(),
                    ResultGen.genSuccessResult(
                            (int)((double)(successNum + failNum) / fList.size() * 100)
                    ).setName("jindutiao2"));
        }

        Long endT = new Date().getTime();

        WebSocketUtil.sendObj(user.getUserName(), ResultGen.genSuccessResult(0).setName("jindutiao2"));
        logSb.append("成功导入").append(successNum).append("个文件，因重复删除")
                .append(failNum).append("个文件，共耗时").append((endT - startT) / 1000L).append("秒");

        WebSocketUtil.sendObj(user.getUserName(), ResultGen.genSuccessResult(logSb.toString()).setName("fileSortSyncMsg"));

        // 填充完毕后，进行文件移动工作
        for (FileSort fileSort : fsList) {
            try {
                FileUtils.moveFile(
                        new File(fileSort.getOldPath()),
                        new File(FileSortService.changePath(fileSort.getPath(), Constant.FALSE_TO_TRUE))
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // 批量保存
        if(fsList.size() > 0) fsMapper.insertByList(fsList);


        // 去掉隐私信息，返回列表

        for (FileSort fileSort : fsList) {
            setFieldValueByFieldName("path", fileSort, null);
            setFieldValueByFieldName("md5", fileSort, null);
            setFieldValueByFieldName("type", fileSort, null);
            setFieldValueByFieldName("oldName", fileSort, null);
        }
    }

    public static void main(String[] args) {
        File file = new File("F:\\123\\test\\第一期：销售信赚钱圣经1.0（营销内功）.pdf");

        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        
        File newFile = new File("F:\\123\\test\\123.pdf");

        // file.renameTo(newFile);
    }

    private static String checkAndGenPath(String basePath, String path, String name) {
        if(new File(basePath + name).exists()) {
            return checkAndGenPath(basePath, path, genFileName(name));
        } else {
            File oleF = new File(path);
            File newF = new File(oleF.getParent() + File.separator + name);
            if(!newF.exists()) oleF.renameTo(newF);
            return name;
        }
    }

    private static String genFileName(String name){
        String qianzhui = name.substring(0, name.lastIndexOf("."));
        String nowTime = String.valueOf(new Date().getTime());
        String newFilename = qianzhui +
                "_" + nowTime.substring(nowTime.length() - 4, nowTime.length()) +
                "." + FilenameUtils.getExtension(name);
        return newFilename;
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

}