package com.example.springboot.repository;

import com.example.springboot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: WangM
 * @Description:
 * @Date: 14:11 2020/1/7
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
