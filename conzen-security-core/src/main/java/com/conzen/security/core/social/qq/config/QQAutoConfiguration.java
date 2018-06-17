package com.conzen.security.core.social.qq.config;

import com.conzen.security.core.properties.QQProperties;
import com.conzen.security.core.properties.SecurityProperties;
import com.conzen.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @Author: Less
 * @Date: 2018/6/12 下午11:53
 * @Description:
 **/
@Configuration
@ConditionalOnProperty(prefix = "conzen.security.social.qq", name = "app-id")
public class QQAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {

        QQProperties qqProperties = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }
}
