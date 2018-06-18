package com.conzen.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * Created by Less on 2018/6/6.
 **/
@Data
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;

}
