package com.conzen.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Less on 2018/6/9.
 **/
@ConfigurationProperties("browser")
public class BrowserProperties {

    private String loginPage = "conzen-login.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
