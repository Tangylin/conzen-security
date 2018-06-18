package com.conzen.security.browser.validate.code.impl;

import com.conzen.security.core.validate.code.ValidateCode;
import com.conzen.security.core.validate.code.ValidateCodeRepository;
import com.conzen.security.core.validate.code.ValidateCodeType;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import static com.conzen.security.core.validate.code.ValidateCodeProcessor.SESSION_KEY_PREFIX;

/**
 * @Author: Less
 * @Date: 2018/6/17 下午9:58
 * @Description:
 **/
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        sessionStrategy.setAttribute(request, getSessionKey(validateCodeType), code);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(validateCodeType));
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        sessionStrategy.removeAttribute(request, getSessionKey(validateCodeType));
    }

    /**
     * 构建验证码放入session时的key
     *
     * @param validateCodeType
     * @return
     */
    private String getSessionKey(ValidateCodeType validateCodeType) {
        return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
    }
}
