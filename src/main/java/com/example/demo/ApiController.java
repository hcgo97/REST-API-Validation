package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiController {

    //GET방식의 메소드로 /api/test 주소로 호출하면 아래의 함수 실행가능
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    //반응은 200 -> http.OK == 200````````
    @ResponseStatus(value = HttpStatus.OK)
    public String getApiTest(){
        return "{\"result\":\"ok\"}";
    }


    //POST방식의 메소드로 /api/test 주소로 호출하면 아래의 함수 실행가능
    @RequestMapping(value = "/api/test2", method = RequestMethod.POST)
    //반응은 200 -> http.OK == 200
    @ResponseStatus(value = HttpStatus.OK)
    public String getApiTest2(){
        return "{\"result\":\"postOK\"}";
    }

    // localhost:8080/api/test
}
