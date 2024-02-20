package org.efernandez.kafkaspring.advicer;

import org.efernandez.kafkaspring.bean.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalAdvicer {

    @ExceptionHandler(Throwable.class)
    public BaseResponse handleException(Exception e) {
        return new BaseResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
