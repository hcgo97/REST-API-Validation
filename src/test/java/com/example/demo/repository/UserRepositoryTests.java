package com.example.demo.repository;


import com.example.demo.DemoApplicationTests;
import com.example.demo.dao.UsersRepository;
import com.example.demo.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class UserRepositoryTests extends DemoApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

//    @Test
//    public void joinTest(){
//        Users users = new Users();
//
//        users.setEmail("zz2342zz@naver.com");
//        users.setTel("0109999999");
//        users.setName("김dd");
//
//        Users newUser = usersRepository.save(users);
//    }


//    @Test
//    public void ddddTest(){
//        List<Users> result = usersRepository.findByTel("01035842747");
//
//        result.forEach(userList ->{
//            System.out.println(userList.getId());
//            System.out.println(userList.getEmail());
//            System.out.println(userList.getTel());
//            System.out.println(userList.getName());
//        });
//        }

    @Test
    public void likeTest(){
        List<UsersEntity> result = usersRepository.findByTelContaining("666");

        result.forEach(userList ->{
            System.out.println(userList.getId());
            System.out.println(userList.getEmail());
            System.out.println(userList.getTel());
            System.out.println(userList.getName());
        });
    }
    }
