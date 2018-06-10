package com.conzen.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Less on 2018/6/9.
 **/
@ConfigurationProperties(prefix = "conzen.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
