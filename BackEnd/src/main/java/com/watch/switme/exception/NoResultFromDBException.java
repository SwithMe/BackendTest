package com.watch.switme.exception;

public class NoResultFromDBException extends RuntimeException{

    public NoResultFromDBException(String message) {
        super(message+" No result found on DB");
    }
}
