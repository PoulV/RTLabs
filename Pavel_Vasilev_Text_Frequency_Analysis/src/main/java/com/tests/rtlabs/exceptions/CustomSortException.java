package com.tests.rtlabs.exceptions;

/**
 * Created by 1 on 02.04.2017.
 */
public class CustomSortException extends RuntimeException {

    public CustomSortException(String errorMessage) {
        super(errorMessage);
    }
}
