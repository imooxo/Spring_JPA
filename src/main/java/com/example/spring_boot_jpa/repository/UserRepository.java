package com.example.spring_boot_jpa.repository;

import com.example.spring_boot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// JpaRepository<entity, 테이블의 pk 자료형>
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {  // 상속을 받으니 extends
    //List<UserEntity> findAll();
    List<UserEntity> findByName(String name);

    Optional<UserEntity> findById(int id);

    // raw query 사용
    // jpa 자체적인 sql => JPQL
    // JPQL : Java Persistence Query Language
    @Query(nativeQuery = true, value = "SELECT u FROM UserEntity u WHERE u.name = :name")
    List<UserEntity> findByNameCustom(String name);
    //@Query(nativeQuery = true)
}//interface
