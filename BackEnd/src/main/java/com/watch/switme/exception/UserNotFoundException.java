package com.watch.switme.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userEmail){
        super(userEmail);
    }

}
