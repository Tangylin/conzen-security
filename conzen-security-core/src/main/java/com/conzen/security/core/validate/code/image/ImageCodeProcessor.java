package com.conzen.security.core.validate.code.image;

import com.conzen.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @Author: Less
 * @Date: 2018/6/10 下午10:39
 * @Description: 图片验证码处理器
 **/
@Component
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
