package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class ControllerAdvices {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException e) {
        String errorMsg = "";

        try {
            errorMsg = this.messageSource.getMessage(e.getErrorCode(), e.getArgs(), Locale.SIMPLIFIED_CHINESE);
        } catch (NoSuchMessageException var4) {
            errorMsg = e.getArgs() != null && e.getArgs().length > 0 ? e.getArgs()[0] : "System Error";
        }

        return new ResponseEntity<>(ApiResponse.error(e.getErrorCode(), errorMsg), HttpStatus.OK);
    }
}

