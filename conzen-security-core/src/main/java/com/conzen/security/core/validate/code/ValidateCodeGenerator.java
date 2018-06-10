package com.conzen.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: Less
 * @Date: 2018/6/10 下午6:08
 * @Description: 验证码生成
 **/
public interface ValidateCodeGenerator {

    /**
     * 生成验证码
     *
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);

}
