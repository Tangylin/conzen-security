package com.conzen.code;

import com.conzen.security.core.validate.code.image.ImageCode;
import com.conzen.security.core.validate.code.image.ImageCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: Less
 * @Date: 2018/6/10 下午6:35
 * @Description: 重写图形验证码生成器
 **/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator extends ImageCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成器");
        return null;
    }
}
