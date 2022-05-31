package com.ganadero.controganadero.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(final String message){
        super(message);
    }
}
