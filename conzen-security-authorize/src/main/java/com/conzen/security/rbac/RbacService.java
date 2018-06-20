package com.conzen.security.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Less
 * @Date: 2018/6/20 下午11:13
 * @Description:
 **/
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
