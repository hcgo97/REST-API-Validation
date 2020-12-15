package com.example.demo.advice;

import com.example.demo.advice.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class MethodError {

    private String code;
    private String message;



    private MethodError(final ErrorCode code, String message){
        this.code = code.getCode();
        this.message= message;
    }


    public static MethodError methodError(final ErrorCode code, String message){
        return new MethodError(code, message);
    }

}