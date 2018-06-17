package com.conzen.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Author: Less
 * @Date: 2018/6/12 下午11:49
 * @Description:
 **/
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
