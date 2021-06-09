package com.github.ivanovvlad9626.exceptions;

public class ArgumentNotProvidedException extends RuntimeException {
    public ArgumentNotProvidedException(String argument) {
        super(String.format("Argument %s is not provided.", argument));
    }
}
