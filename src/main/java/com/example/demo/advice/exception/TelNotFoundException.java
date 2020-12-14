package com.example.demo.advice.exception;

public class TelNotFoundException extends RuntimeException{

    public TelNotFoundException(String message, Throwable t){
        super(message, t);
    }

    public TelNotFoundException(String message){
        super(message);
    }

    public TelNotFoundException(){
        super();
    }

}
