package com.yfh.springbootshiro;

import com.yfh.springbootshiro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

        System.out.println(userService.queryUserById(1));
        System.out.println(userService.queryUserByName("xiaoming"));
    }

}
