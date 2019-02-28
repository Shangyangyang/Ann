package cn.ainannan.sys.utils;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
public class CaptchaController {

    private static final String VALIDATE_CODE = "validate.code";

    @Autowired
    public DefaultKaptcha defaultKaptcha;

    //生成验证码
    @RequestMapping("/captcha")
    public void captcha(HttpSession session, HttpServletResponse response) throws Exception {

        try {

            //System.out.println("产生验证码的SessionID "+session.getId());

            //生产验证码字符串并保存到session中
            String validateCode = defaultKaptcha.createText();

            session.setAttribute(VALIDATE_CODE, validateCode);

            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage bufferedImage = defaultKaptcha.createImage(validateCode);

            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "jpg", jpegOutputStream);

            //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            ServletOutputStream responseOutputStream = response.getOutputStream();

            responseOutputStream.write(jpegOutputStream.toByteArray());

            responseOutputStream.flush();
            responseOutputStream.close();

        } catch (IllegalArgumentException e) {
            //response.sendError(HttpServletResponse.SC_NOT_FOUND);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }

    //验证码校验
    public static Boolean check(HttpSession session, String validateCode) {

        //System.out.println("比较验证码的SessionID "+session.getId());

        String sessionCode = (String) session.getAttribute(VALIDATE_CODE);

        if (sessionCode == null || sessionCode.equals("") || validateCode == null || validateCode.equals("")) {
            return false;
        }
        if (sessionCode.equals(validateCode)) {
            return true;
        }
        return false;
    }

}
