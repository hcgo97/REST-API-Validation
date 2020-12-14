package com.example.demo.advice.exception;

public class EmailInvalidFormat extends RuntimeException{

    public EmailInvalidFormat(String message, Throwable t){
        super(message, t);
    }

    public EmailInvalidFormat(String message){
        super(message);
    }

    public EmailInvalidFormat(){
        super();
    }

}
