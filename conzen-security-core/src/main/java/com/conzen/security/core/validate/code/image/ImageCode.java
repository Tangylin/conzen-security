package com.conzen.security.core.validate.code.image;

import com.conzen.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: Less
 * @Date: 2018/6/10 上午1:35
 * @Description: 图形验证码
 **/
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
