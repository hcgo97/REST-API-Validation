package com.example.demo.advice.exception;

public class TelInvalidFormat extends RuntimeException{

    public TelInvalidFormat(String message, Throwable t){
        super(message, t);
    }

    public TelInvalidFormat(String message){
        super(message);
    }

    public TelInvalidFormat(){
        super();
    }

}
