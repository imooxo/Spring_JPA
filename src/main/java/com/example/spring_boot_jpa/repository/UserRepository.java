package com.example.spring_boot_jpa.repository;

import com.example.spring_boot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<entity, 테이블의 pk 자료형>
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {  // 상속을 받으니 extends
    //List<UserEntity> findAll();
    List<UserEntity> findByName(String name);
}//interface
