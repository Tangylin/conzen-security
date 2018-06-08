package com.conzen.controller;

import com.conzen.dto.User;
import com.conzen.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Less on 2018/6/6.
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> getUser(UserQueryCondition queryCondition) {
        System.out.println(queryCondition);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("Tom");
        user.setPassword("123456");
        users.add(user);
        return users;
    }

    @GetMapping("/{id}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setName("Tom");
        user.setPassword("123456");
        return user;
    }

}
