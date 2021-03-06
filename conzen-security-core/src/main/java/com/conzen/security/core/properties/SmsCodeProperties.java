package com.conzen.security.core.properties;

/**
 * @Author: Less
 * @Date: 2018/6/10 上午10:05
 * @Description: 图形验证码配置项
 **/
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 120;

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
