package com.conzen.security.core.validate.code.sms;


/**
 * @Author: Less
 * @Date: 2018/6/10 下午9:52
 * @Description:
 **/
public class DefaultSmsCodeSender implements SmsCodeSender {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param code 验证码
     */
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送验证码：" + code);
    }
}
