package com.conzen.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @Author: Less
 * @Date: 2018/6/13 下午10:02
 * @Description:
 **/
public class ConzenSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public ConzenSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
