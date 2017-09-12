package com.flhscl.springbootscrafhold.service;

import com.flhscl.springbootscrafhold.entity.datasource1.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/9/11
 * @since 1.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {
        userService.deleteUser(3);
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void selectUser() throws Exception {
        User user = userService.selectUser(2);
    }

}