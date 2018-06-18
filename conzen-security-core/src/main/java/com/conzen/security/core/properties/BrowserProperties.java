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
     * 退出页
     */
    private String logoutPage;

    /**
     * 注册页
     */
    private String signUpUrl = "/comzen-signUp.html";

    /**
     * 记住我保持时间，秒
     */
    private int rememberMeSeconds = 3600;

    private SessionProperties session = new SessionProperties();

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

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public String getLogoutPage() {
        return logoutPage;
    }

    public void setLogoutPage(String logoutPage) {
        this.logoutPage = logoutPage;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
