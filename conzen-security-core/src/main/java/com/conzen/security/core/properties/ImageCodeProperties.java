package com.conzen.security.core.properties;

/**
 * @Author: Less
 * @Date: 2018/6/10 上午10:05
 * @Description: 图形验证码配置项
 **/
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;

    private int height = 23;

    ImageCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
