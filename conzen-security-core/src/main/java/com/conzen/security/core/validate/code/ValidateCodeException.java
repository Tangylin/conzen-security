package com.conzen.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: Less
 * @Date: 2018/6/10 上午2:11
 * @Description: 验证码异常类
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
