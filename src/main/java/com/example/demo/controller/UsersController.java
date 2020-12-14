package com.example.demo.controller;

import com.example.demo.entity.UsersEntity;
import com.example.demo.response.CommonResult;
import com.example.demo.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1") //기본경로 /v1/users
public class UsersController {

    @Autowired
    private UsersServiceImpl usersServiceImpl;


    //유저추가
    @PostMapping(value="/users")
    public Object join(@RequestBody UsersEntity usersEntity){

        return usersServiceImpl.join(usersEntity);
    }


    //Like검색
    @GetMapping(value="/users")
    public Object findUser(@RequestParam String tel){

        return usersServiceImpl.findUser(tel);

    }

}


