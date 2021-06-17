package com.newheyd.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExcelExport {
    public static void fileNameDispose (HttpServletRequest request, HttpServletResponse response,String extfilename){
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            //根据浏览器类型处理文件名称
            if (agent.indexOf("firefox") > -1) {
                //firefox不转码
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(extfilename.getBytes("UTF-8"), "ISO8859-1") + ".xls");
            } else {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(extfilename, "UTF-8") + ".xls");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //编码
        response.setCharacterEncoding("UTF-8");
    }
}
