package com.example.demo.advice.exception;

public class CreateException extends RuntimeException{

    public CreateException(String message, Throwable t){
        super(message, t);
    }

    public CreateException(String message){
        super(message);
    }

    public CreateException(){
        super();
    }

}
