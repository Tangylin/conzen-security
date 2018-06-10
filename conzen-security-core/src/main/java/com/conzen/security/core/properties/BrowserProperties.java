package com.conzen.security.core.properties;

/**
 * Created by Less on 2018/6/9.
 **/
public class BrowserProperties {

    /**
     * 登录页
     */
    private String loginPage = "/conzen-login.html";

    /**
     * 登录类型
     */
    private LoginType loginType = LoginType.JSON;

    /**
     * 记住我保持时间，秒
     */
    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
