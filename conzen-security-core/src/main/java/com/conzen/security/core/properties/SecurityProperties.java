package com.conzen.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Less on 2018/6/9.
 **/
@ConfigurationProperties(prefix = "conzen.security")
public class SecurityProperties {

    private BrowserProperties browser;

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
