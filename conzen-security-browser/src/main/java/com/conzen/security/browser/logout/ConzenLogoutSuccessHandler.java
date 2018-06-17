package com.conzen.security.browser.logout;

import com.conzen.security.browser.suport.SimpleResponse;
import com.conzen.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Less
 * @Date: 2018/6/16 上午12:56
 * @Description:
 **/
public class ConzenLogoutSuccessHandler implements LogoutSuccessHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    private String logoutUrl;

    public ConzenLogoutSuccessHandler(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("退出成功");

        if (StringUtils.isBlank(logoutUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            response.sendRedirect(logoutUrl);
        }

    }
}
