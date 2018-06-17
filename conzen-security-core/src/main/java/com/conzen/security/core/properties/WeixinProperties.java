package com.conzen.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Author: Less
 * @Date: 2018/6/14 上午12:03
 * @Description:
 **/
public class WeixinProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";

    /**
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * @param providerId the providerId to set
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

}
