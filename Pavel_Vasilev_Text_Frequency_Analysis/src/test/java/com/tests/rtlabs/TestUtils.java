package com.tests.rtlabs;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 1 on 01.04.2017.
 */
public class TestUtils {
    public final static String PROPERY_KEY_TEST_FILE = "file4JUnit";
    public final static String PROPERY_KEY_STOP_WORD_DICTIONARY = "stopWordDictionary";
    public static final String PROPERTY_KEY_REGEX_WORD_SEPARATOR = "regexWordSeparator";
    public static final String TEST_PROPERTY_FILE = "test.properties";

    private static Properties property;

    private static final Logger logger = Logger.getLogger(TestUtils.class);

    public static void initProperty() {
        logger.info("Start test property initiation.");
        property = new Properties();
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(TEST_PROPERTY_FILE)) {
            property.load(input);
        } catch (Exception someException) {
            String exceptionMessage = someException.getClass().toString()
                    + " has been execute when try load "
                    + TEST_PROPERTY_FILE;
            throwExceptionAndLog(exceptionMessage, someException);
        }

        logger.info("Property has been loaded from " + TEST_PROPERTY_FILE);
    }

    public static String getProperty(String propertyKey) {
        return property.getProperty(propertyKey);
    }

    private static void throwExceptionAndLog(String message, Throwable currentException) {
        logger.error(message, currentException);
        throw new RuntimeException(message, currentException);
    }
}
