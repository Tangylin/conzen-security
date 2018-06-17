package com.conzen.security.core.social.weixin.api;

/**
 * @Author: Less
 * @Date: 2018/6/13 下午11:54
 * @Description:
 **/
public interface Weixin {

    /**
     * 获取用户信息
     *
     * @param openId
     * @return
     */
    WeixinUserInfo getUserInfo(String openId);

}
