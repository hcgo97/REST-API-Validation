package com.example.demo.advice.exception;

public class TelDuplicateException extends RuntimeException{

    public TelDuplicateException(String message, Throwable t){
        super(message, t);
    }

    public TelDuplicateException(String message){
        super(message);
    }

    public TelDuplicateException(){
        super();
    }

}
