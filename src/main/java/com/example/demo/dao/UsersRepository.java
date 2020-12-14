package com.example.demo.dao;

import com.example.demo.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    List<UsersEntity> findByTelContaining(String tel);

    long countByTelContaining(String tel);

    int countByTel(String tel);

    int countByEmail(String email);

}
