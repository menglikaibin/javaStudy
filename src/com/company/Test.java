package com.company;

import com.company.controller.UserController;
import com.company.service.UserService;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        UserService userService = new UserService();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();

                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());
        System.out.println(userService);
    }
}
