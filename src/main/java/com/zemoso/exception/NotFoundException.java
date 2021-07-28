package com.zemoso.exception;

import ch.qos.logback.core.LogbackException;

import java.util.logging.Logger;

public class NotFoundException extends Exception{

    public NotFoundException(String message){
        super();
        LogbackException lg=new LogbackException(message);
    }
}
