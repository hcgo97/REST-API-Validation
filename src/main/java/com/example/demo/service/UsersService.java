package com.example.demo.service;

import com.example.demo.entity.UsersEntity;

public interface UsersService {

    public Object join(UsersEntity usersEntity);

    public Object findUser(String tel);
}
