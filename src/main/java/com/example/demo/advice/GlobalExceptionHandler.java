package com.example.demo.advice;

import com.example.demo.advice.exception.*;
import com.example.demo.response.CommonResult;
import com.example.demo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;


@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final ResponseService responseService;

    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("handleBindException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getCode()));
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getCode()));
    }


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<ErrorResponse> noHandlerFoundException(NoHandlerFoundException e){
        log.error("noHandlerFoundException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    //번호중복
    @ExceptionHandler(TelDuplicateException.class) //(괄호안에 적용할 클래스)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult telNotFoundException(HttpServletRequest Request, TelDuplicateException e){

        return responseService.getTelFailResult(); //미리정의된것중에 괄호안에있는거 젤먼저찾아서바꿈
    }

    //이메일중복
    @ExceptionHandler(EmailDuplicateException.class) //(괄호안에 적용할 클래스)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult emailNotFoundException(HttpServletRequest Request, TelDuplicateException e){

        return responseService.getEmailFailResult(); //미리정의된것중에 괄호안에있는거 젤먼저찾아서바꿈
    }

    //검색실패
    @ExceptionHandler(TelNotFoundException.class) //(괄호안에 적용할 클래스)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult telNotFoundException(HttpServletRequest Request, TelNotFoundException e){

        return responseService.getSearchFailResult(); //미리정의된것중에 괄호안에있는거 젤먼저찾아서바꿈
    }

    //유효성검사
    @ExceptionHandler(TelInvalidFormat.class)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult telInvalidFormat(HttpServletRequest Request, TelInvalidFormat e){

        return responseService.getTelFormatResult();
    }

    @ExceptionHandler(EmailInvalidFormat.class)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult emailInvalidFormat(HttpServletRequest Request, EmailInvalidFormat e){

        return responseService.getEmailFormatResult();
    }

    @ExceptionHandler(NameInvalidFormat.class)
    @ResponseStatus(HttpStatus.OK)
    protected CommonResult nameInvalidFormat(HttpServletRequest Request, NameInvalidFormat e){

        return responseService.getNameFormatResult();
    }


}