package com.example.springboot.controller;

import com.example.springboot.entity.Admin;
import com.example.springboot.entity.User;
import com.example.springboot.service.XATestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author: WangM
 * @Description:
 * @Date: 14:41 2020/1/7
 */
@RestController
@RequestMapping("/api")
public class XATestController {
    @Autowired
    private XATestService xaTestService;

    @RequestMapping("/store")
    public String store() {
        Admin admin = new Admin();
        admin.setName("老王");
        admin.setAge(new Random().nextInt(100));

        User user = new User();
        user.setName("小王");
        user.setAge(new Random().nextInt(100));
        xaTestService.store(user, admin);

        return "success";
    }
}
