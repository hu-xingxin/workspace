package com.tools.hutool.file;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import com.tools.hutool.utils.print.Comment;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 15:08:05
 * @Description 图形验证码工具
 */
public class TestCaptcha {
    @Test
    @Comment("图形验证码工具")
    public void lineCaptcha(){
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        String code = lineCaptcha.getCode();
        lineCaptcha.write("E:\\tmp\\image\\captcha\\lineCaptcha.png");
        System.out.println("当前的验证码是: " + code);
    }

    @Test
    @Comment("图形验证码工具")
    public void circleCaptcha(){
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200, 100);
        String code = circleCaptcha.getCode();
        circleCaptcha.write("E:\\tmp\\image\\captcha\\circleCaptcha.png");
        System.out.println("当前的验证码是: " + code);
    }

    @Test
    @Comment("图形验证码工具")
    public void shearCaptcha(){
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 100);
        String code = shearCaptcha.getCode();
        shearCaptcha.write("E:\\tmp\\image\\captcha\\shearCaptcha.png");
        System.out.println("当前的验证码是: " + code);
    }
}
