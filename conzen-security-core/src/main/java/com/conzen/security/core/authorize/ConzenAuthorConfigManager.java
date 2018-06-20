package com.conzen.security.core.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Less
 * @Date: 2018/6/20 下午10:28
 * @Description:
 **/
@Component
public class ConzenAuthorConfigManager implements AuthorizeConfigManager {
    
    @Autowired
    private List<AuthorizeConfigProvider> authorizeConfigProviders;
    
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
            authorizeConfigProvider.config(config);
        }
//        config.anyRequest().authenticated();
        
    }
}
