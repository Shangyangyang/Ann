package com.newheyd.base.util;

public class UrlFilter {

    public static boolean checkUrl(String url) {
        if (url.startsWith("/dict/listForPlug")) return true;
        if (url.startsWith("/cjrpt")) return true;
        if (url.startsWith("/ywbl")) return true;
        if (url.startsWith("/css")) return true;
        if (url.startsWith("/error")) return true;
        if (url.startsWith("/fonts")) return true;
        if (url.startsWith("/iconfont")) return true;
        if (url.startsWith("/img")) return true;
        if (url.startsWith("/js")) return true;
        if (url.startsWith("/static")) return true;
        if (url.startsWith("/captcha")) return true;

        if (url.startsWith("/front")) return true;

        if (url.startsWith("/webjars")) return true;
        if (url.startsWith("/v2")) return true;
        if (url.startsWith("/swagger")) return true;

        if (url.startsWith("/check")) return true;
        if (url.startsWith("/appskip")) return true;

        if (url.startsWith("/wqglWuzangaigz/")) return true;
        if (url.startsWith("/itemDetails")) return true;
        //验证码
        if ("/captcha".equals(url)) return true;
        //平台登录
        if ("/login".equals(url)) return true;
        //短信登录
        if ("/smsLogin".equals(url)) return true;

        //扫码登录
        if ("/checkUid".equals(url) || "/saveUid".equals(url)) return true;
        if ("/genQRCode".equals(url) || "/authQRCode".equals(url) || "/qrLogin".equals(url)) return true;

        //微信，QQ登录
        if ("/loginUrl".equals(url) || "/qqLogin".equals(url) || "/wxLogin".equals(url) || "/ddLogin".equals(url) || "/wmpLogin".equals(url)) return true;
        //手机微信，qq登录
        if ("/appTencentLogin".equals(url)) return true;

        //忘记密码
        if ("/checkUserCode".equals(url) || "/sendsmsForgot".equals(url) || "/checkSmsCode".equals(url) || "/changepassForgot".equals(url)) return true;

        if (url.startsWith("/api/")) return true;

        //移动端接口
        //必须是/m/ 不能是/m
        if (url.startsWith("/m/")) return true;

        if (url.startsWith("/JWTLogin/") || url.startsWith("/refreshToken/")) return true;
        //if(url.startsWith("/sysUser"))return true;

        if (url.startsWith("/cfg/pub/")) return true;
        
        // 人口库对外提供接口
        if (url.startsWith("/citizenInfoAPI/getByIdcard")) return true;
        if (url.startsWith("/citizenInfoAPI/getByIdcards")) return true;    // 2020-08-18
        if (url.startsWith("/citizenInfoAPI/getList")) return true;    // 2020-08-18
        if (url.startsWith("/citizenInfoAPI/checkCitizen")) return true;
        if (url.startsWith("/citizenInfoAPI/getByAreaCode")) return true;
        
        // 残联应用监管项目的接口
        if (url.startsWith("/citizenInfoAPI/getCitizenCount")) return true;
        if (url.startsWith("/citizenInfoAPI/getLogData")) return true;
        if (url.startsWith("/tongji/getLogData")) return true;
        // 附件下载
        if (url.startsWith("/attachment/download")) return true;
        if (url.startsWith("/attachment/addlist")) return true;
        
        // 政务网-就业管理
        // 就业基地
        if (url.startsWith("/jyglJidi/saveF")) return true;

        //居家托养
        if (url.startsWith("/tyHomeCare")) return true;
        if (url.startsWith("/serviceConfig/getRecurs")) return true;
        if (url.startsWith("/tyglJigou/jigouList")) return true;
        if (url.startsWith("/tyglServiceRoster/getRosterList")) return true;
        //爱山东app
        if (url.startsWith("/eduAssistance")) return true;

        //政策法规
        if (url.startsWith("/policy/list")) return true;

        return false;
    }

}
