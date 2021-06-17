package com.newheyd.base.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class ExcelImport {


    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证EXCEL文件
     * @param filePath 格式
     * @return
     */
    public static boolean validateExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
            return false;
        }
        return true;
    }

    /**
     * 检验EXCEL文件
     * @param file
     * @return
     */
    public  static  String validateExcelReturnMessage(MultipartFile file){

        //判断文件是否为空
        if(file==null){
            return "文件不能为空！";
        }

        String fileName = file.getOriginalFilename();

        //验证文件名是否合格
        if(!validateExcel(fileName)){
            return "文件必须是excel格式！";
        }

        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(StringUtils.isEmpty(fileName) || size==0){
            return "文件不能为空！";
        }
        return "";
    }

    public static File multipartFileTOFile(MultipartFile file){
        try {
        File uploadDir = new  File(System.getProperty("user.dir")+"\\userfiles\\excelfiles");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) uploadDir.mkdirs();
        //新建一个文件
        File tempFile = new File(System.getProperty("user.dir")+"\\userfiles\\excelfiles\\" + new Date().getTime() + ".xlsx");
        //将上传的文件写入新建的文件中
        file.transferTo(tempFile);
        return  tempFile;
        } catch (Exception e) {
            return null;
        }
    }

    public static void deleteTempFile (File tempFile){
        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }
    }
}