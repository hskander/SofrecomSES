package com.sofrecom.sofrecomSES.Exeption;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message)  {
        super(message);
    }
}