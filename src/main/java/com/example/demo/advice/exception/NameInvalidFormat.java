package com.example.demo.advice.exception;

public class NameInvalidFormat extends RuntimeException{

    public NameInvalidFormat(String message, Throwable t){
        super(message, t);
    }

    public NameInvalidFormat(String message){
        super(message);
    }

    public NameInvalidFormat(){
        super();
    }

}
