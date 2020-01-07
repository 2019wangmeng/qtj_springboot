package com.example.springboot.service;

import com.example.springboot.entity.Admin;
import com.example.springboot.entity.User;
import com.example.springboot.repository.AdminRepository;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: WangM
 * @Description:
 * @Date: 14:39 2020/1/7
 */
@Service
public class XATestService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public void store(User user, Admin admin) {
        userRepository.save(user);
        adminRepository.save(admin);
    }
}
