package com.watch.switme.controller;

import com.watch.switme.exception.NoResultFromDBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler({NoResultFromDBException.class})
    public ResponseEntity<Object> handleNoResultFromDBException(final NoResultFromDBException e) {

        log.info("No result found on DB [" + e.getMessage() + "]");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);


    }


}
