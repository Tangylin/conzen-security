package com.conzen.security.core.authorize;

import com.conzen.security.core.properties.SecurityConstants;
import com.conzen.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Author: Less
 * @Date: 2018/6/20 下午10:22
 * @Description:
 **/
@Component
@Order(Integer.MIN_VALUE)
public class ConzenAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        // TODO "/user/register" "/social/signUp"
        config.antMatchers(
                SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                securityProperties.getBrowser().getLoginPage(),
                securityProperties.getBrowser().getLogoutPage(),
                securityProperties.getBrowser().getSignUpUrl(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".json",
                securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html")
                .permitAll();

    }
}
