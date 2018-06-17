package com.conzen.security.core.social.weixin.config;

import com.conzen.security.core.properties.SecurityProperties;
import com.conzen.security.core.properties.WeixinProperties;
import com.conzen.security.core.social.weixin.connet.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @Author: Less
 * @Date: 2018/6/13 下午11:59
 * @Description:
 **/
@Configuration
@ConditionalOnProperty(prefix = "conzen.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter
     * #createConnectionFactory()
     */
    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
                weixinConfig.getAppSecret());
    }

//    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
//    @ConditionalOnMissingBean(name = "weixinConnectedView")
//    public View weixinConnectedView() {
//        return new ConzenConnectView();
//    }
}
