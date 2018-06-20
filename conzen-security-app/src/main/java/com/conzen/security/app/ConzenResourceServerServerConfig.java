package com.conzen.security.app;

import com.conzen.security.core.authentication.openid.OpenIdAuthenticationSecurityConfig;
import com.conzen.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.conzen.security.core.authorize.AuthorizeConfigManager;
import com.conzen.security.core.properties.SecurityConstants;
import com.conzen.security.core.properties.SecurityProperties;
import com.conzen.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.naming.ldap.PagedResultsControl;

/**
 * @Author: Less
 * @Date: 2018/6/17 下午9:10
 * @Description:
 **/
@Configuration
@EnableResourceServer
public class ConzenResourceServerServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler simpleAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler simpleAuthenticationFailureHandler;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer conzenSocialSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 表单登录验证
        http
                .apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .apply(conzenSocialSecurityConfig)
                .and()
                .formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(simpleAuthenticationSuccessHandler)
                .failureHandler(simpleAuthenticationFailureHandler)
//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
//                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
//                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
//                        securityProperties.getBrowser().getLoginPage(),
//                        securityProperties.getBrowser().getLogoutPage(),
//                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
//                        securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".json",
//                        securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html",
//                        "/user/register", "/social/signUp")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
                .and().csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }

}
