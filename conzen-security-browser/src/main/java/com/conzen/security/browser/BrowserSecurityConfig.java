package com.conzen.security.browser;

import com.conzen.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.conzen.security.core.authorize.AuthorizeConfigManager;
import com.conzen.security.core.properties.SecurityConstants;
import com.conzen.security.core.properties.SecurityProperties;
import com.conzen.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * Created by Less on 2018/6/8.
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler simpleAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler simpleAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer conzenSocialSecurityConfig;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Bean
    PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        applyPasswordAuthenticationConfig(http);

        // 表单登录验证
        http.apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(validateCodeSecurityConfig)
                .and()
            .apply(conzenSocialSecurityConfig)
                .and()
            .formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(simpleAuthenticationSuccessHandler)
                .failureHandler(simpleAuthenticationFailureHandler)
                .and()
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
            .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
//                .and()
//            .authorizeRequests()
//                .antMatchers(
//                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
//                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
//                        securityProperties.getBrowser().getLoginPage(),
//                        securityProperties.getBrowser().getLogoutPage(),
//                        securityProperties.getBrowser().getSignUpUrl(),
//                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
//                        securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".json",
//                        securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".html",
//                        "/user/register")
//                .permitAll()
//            .anyRequest()
//            .authenticated()
            .and().csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());

    }
}
