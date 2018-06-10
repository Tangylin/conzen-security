package com.conzen.security.core.validate.code;

import com.conzen.security.core.properties.SecurityProperties;
import com.conzen.security.core.validate.code.image.ImageCodeGenerator;
import com.conzen.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.conzen.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Less
 * @Date: 2018/6/10 下午6:30
 * @Description: 验证码配置
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(ImageCodeGenerator.class)
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator generator = new ImageCodeGenerator();
        generator.setSecurityProperties(securityProperties);
        return generator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
