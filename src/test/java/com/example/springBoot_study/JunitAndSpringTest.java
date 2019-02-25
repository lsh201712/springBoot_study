package com.example.springBoot_study;

import com.SpringBootStudyApplication;
import com.sky.pojo.Users;
import com.sky.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootStudyApplication.class})
public class JunitAndSpringTest {
    @Autowired
    private UserService userService;

    @Test
    public  void  testAddUser(){
        Users users = new Users();
        users.setAge(1000);
        users.setName("junit测试用户");
        userService.addUser(users);
    }

}
