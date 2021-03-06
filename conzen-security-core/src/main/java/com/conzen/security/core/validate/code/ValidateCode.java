package com.conzen.security.core.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: Less
 * @Date: 2018/6/10 上午1:35
 * @Description: 图形验证码
 **/
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -4299321105211812592L;
    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
