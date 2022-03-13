package com.company.controller;

import com.company.Autowired;
import com.company.service.UserService;

public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
