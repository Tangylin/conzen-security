package com.conzen.security.core.validate.code.sms;

/**
 * @Author: Less
 * @Date: 2018/6/10 下午9:52
 * @Description:
 **/
public interface SmsCodeSender {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param code 验证码
     */
    void send(String mobile, String code);

}
