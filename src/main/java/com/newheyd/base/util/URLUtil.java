package com.newheyd.base.util;

import javax.servlet.http.HttpServletRequest;

public class URLUtil {

    private static final String TEST_MODE = "test";

    public static String adjustUrl(String url) {
        url = url.replace("/cc/index.html#/", "http://localhost:8102/index.html#/");
        url = url.replace("/lc/index.html#/", "http://localhost:8111/index.html#/");
        url = url.replace("/zzgl/index.html#/", "http://localhost:8121/index.html#/");
        url = url.replace("/rkk/index.html#/", "http://localhost:8131/index.html#/");
        url = url.replace("/edu/index.html#/", "http://localhost:8141/index.html#/");
        url = url.replace("/shbz/index.html#/", "http://localhost:8151/index.html#/");
        url = url.replace("/tygl/index.html#/", "http://localhost:8152/index.html#/");
        url = url.replace("/jygl/index.html#/", "http://localhost:8171/index.html#/");
        url = url.replace("/pxgl/index.html#/", "http://localhost:8181/index.html#/");
        url = url.replace("/jzkf/index.html#/", "http://localhost:8191/index.html#/");
        url = url.replace("/cjrz/index.html#/", "http://localhost:8192/index.html#/");
        url = url.replace("/jzfw/index.html#/", "http://localhost:8201/index.html#/");
        url = url.replace("/zcgl/index.html#/", "http://localhost:8211/index.html#/");
        url = url.replace("/wqgl/index.html#/", "http://localhost:8221/index.html#/");
        url = url.replace("/smzq/index.html#/", "http://localhost:8231/index.html#/");
        url = url.replace("/jcfx/index.html#/", "http://localhost:8241/index.html#/");
        url = url.replace("/oa/index.html#/", "http://localhost:8261/index.html#/");
        url = url.replace("/lfzx/index.html#/", "http://localhost:8271/index.html#/");
        url = url.replace("/sjjg/index.html#/", "http://localhost:8311/index.html#/");
        url = url.replace("/org/index.html#/", "http://localhost:8121/index.html#/");
        url = url.replace("/fuju/index.html#/", "http://localhost:8241/index.html#/");
        url = url.replace("/api/", "http://localhost:7070/index.html#/");
        url = url.replace("/dsj/", "http://223.99.3.4:7891/");
        return url;
    }

    public static String getFullUrl(HttpServletRequest request, String appUrl, String runMode) {
        if (appUrl.indexOf("http://") < 0) {
            String hostName = request.getParameter("hostName");
            String hostPort = request.getParameter("hostPort");

            if (hostName == null || hostName.equals("")) {
                hostName = request.getServerName();
            }

            if (hostPort == null || hostPort.equals("")) {
                if (runMode.equals(TEST_MODE)) {
                    hostPort = "9090";
                } else {
                    hostPort = "80";
                }
            }

            if (hostName != null && !hostName.equals("") && hostPort != null && !hostPort.equals("")) {
                appUrl = "http://" + hostName + ":" + hostPort + appUrl;
            }
        }
        return appUrl;
    }

}
