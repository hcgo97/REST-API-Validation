package com.example.demo.service;

import com.example.demo.dao.UsersRepository;
import com.example.demo.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ResponseService responseService;


    //유저추가
    @Override
    public Object join(UsersEntity usersEntity) {

        int telCount = usersRepository.countByTel(usersEntity.getTel());
        int emailCount = usersRepository.countByEmail(usersEntity.getEmail());

        //중복데이터검사
        if (telCount > 0) {
            return responseService.getTelFailResult();

        } else if (emailCount > 0) {
            return responseService.getEmailFailResult();

        } else{
            usersRepository.save(usersEntity);
            return new ResponseEntity<>(responseService.createSuccessResult(), (HttpStatus.CREATED));
        }
    }



    //Like 검색
    @Override
    public Object findUser(String tel){

        int count = (int) usersRepository.countByTelContaining(tel);

        if(count < 1){
            return responseService.getSearchFailResult();
        }else if (count == 1) {
            return responseService.getSingleResult(usersRepository.findByTelContaining(tel).get(0));
        }else{
            return responseService.getListResult(usersRepository.findByTelContaining(tel));
        }
    }
}
