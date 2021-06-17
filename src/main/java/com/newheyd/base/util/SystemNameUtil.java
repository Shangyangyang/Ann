package com.newheyd.base.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SystemNameUtil {

    public static String getSubSystemName(){
        String sysName  = "370100";
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String serverName = "," + request.getServerName()+ ",";
            if (",lixia.jinandpf.org,124.128.155.196,124.128.155.197,".indexOf(serverName)>=0){
                sysName = "370102";
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            return sysName;
        }

    }
}
