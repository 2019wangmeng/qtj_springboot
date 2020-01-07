package com.example.springboot.repository;

import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangM
 * @Description:
 * @Date: 14:10 2020/1/7
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
