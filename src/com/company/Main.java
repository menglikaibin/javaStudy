package com.company;

import com.company.controller.UserController;
import com.company.service.UserService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();

        Class<? extends UserController> clazz = userController.getClass();

        // 创建对象
        UserService userService = new UserService();
        System.out.println(userService);
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);

        String name = serviceField.getName();
        // 拼接方法名称
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
        // 通过方法注入属性对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        //反射
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }
}
