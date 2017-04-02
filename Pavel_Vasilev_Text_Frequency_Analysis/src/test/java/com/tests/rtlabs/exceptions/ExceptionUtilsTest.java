package com.tests.rtlabs.exceptions;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 1 on 01.04.2017.
 */
public class ExceptionUtilsTest {
    private static final Logger logger = Logger.getLogger(ExceptionUtilsTest.class);

    @After
    public void afterTest() {
        logger.info("Test complete.");
    }

    @Test(expected = CustomIOException.class)
    public void throwCustomIOException() throws Exception {
        logger.info("Start test ExceptionUtils.throwCustomIOException");
        ExceptionUtils.throwCustomIOException(new IOException("test io exception"), "test custom io exception");
    }

}