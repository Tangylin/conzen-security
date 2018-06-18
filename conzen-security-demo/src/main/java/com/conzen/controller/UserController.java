package com.conzen.controller;

import com.conzen.dto.User;
import com.conzen.dto.UserQueryCondition;
//import com.conzen.security.app.social.AppSignUpUtils;
import com.conzen.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.java.Log;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Less on 2018/6/6.
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

//    @Autowired
//    private AppSignUpUtils appSignUpUtils;

    @Autowired
    private SecurityProperties securityProperties;

    @PostMapping("/register")
    public void register(User user, HttpServletRequest request) {

        log.info("【注册用户】user={}", user);

        // 不管是注册用户还是绑定用户都会拿到一个用户唯一标识
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));

//        appSignUpUtils.doPostSignUp(userId, new ServletWebRequest(request));

    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> getUser(UserQueryCondition queryCondition) {
        System.out.println(queryCondition);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        users.add(user);
        return users;
    }

    @GetMapping("/{id}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        return user;
    }

    @GetMapping("/me")
    public Object getMe(Authentication user, HttpServletRequest request) throws UnsupportedEncodingException {

        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "Bearer ");

        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();

        String company = (String) claims.get("company");

        log.info("company：{}", company);

        return user;
    }

}
