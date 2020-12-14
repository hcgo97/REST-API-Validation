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

        String telRegExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
        String emailRegExp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String nameRegExp = "^[가-힣]{2,10}$";

        int telCount = usersRepository.countByTel(usersEntity.getTel());
        int emailCount = usersRepository.countByEmail(usersEntity.getEmail());

        //유효성검사
        if (usersEntity.getTel().matches(telRegExp) == false) {
            return responseService.getTelFormatResult();
        } else if (usersEntity.getEmail().matches(emailRegExp) == false) {
            return responseService.getEmailFormatResult();
        } else if (usersEntity.getName().matches(nameRegExp) == false){
            return responseService.getNameFormatResult();
        }


        //중복데이터검사
        if (telCount > 0) {
            return responseService.getTelFailResult();

        } else if (emailCount > 0) {
            return responseService.getEmailFailResult();

        } else if (usersEntity.getTel().matches(telRegExp) == true &
                    usersEntity.getEmail().matches(emailRegExp) == true &
                        usersEntity.getName().matches(nameRegExp) == true) {
            usersRepository.save(usersEntity);
            return new ResponseEntity<>(responseService.createSuccessResult(), (HttpStatus.CREATED));
        }
        return null;
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
