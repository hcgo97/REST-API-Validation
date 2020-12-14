package com.example.demo.advice.exception;

public class EmailDuplicateException extends RuntimeException{

    public EmailDuplicateException(String message, Throwable t){
        super(message, t);
    }

    public EmailDuplicateException(String message){
        super(message);
    }

    public EmailDuplicateException(){
        super();
    }

}
