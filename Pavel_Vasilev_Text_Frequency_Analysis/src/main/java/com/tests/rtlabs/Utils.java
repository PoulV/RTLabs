package com.tests.rtlabs;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

import static com.tests.rtlabs.exceptions.ExceptionUtils.throwCustomIOException;

/**
 * Created by 1 on 01.04.2017.
 */
public class Utils {
    public static final String PROPERTY_KEY_INPUT = "inputFilePath";
    public static final String PROPERTY_KEY_OUTPUT = "outputFilePath";
    public static final String PROPERTY_KEY_STOP_WORD_DICTIONARY = "stopWordDictionary";
    public static final String PROPERTY_KEY_REGEX_WORD_SEPARATOR = "regexWordSeparator";
    public static final String PROPERTY_FILE = "solution.properties";

    public static final String REGEX_START_TEXT = "^";
    public static final String REGEX_END_TEXT = "$";
    public static final String REGEX_POSTFIX = "+";

    public static final String LINE_SEPARATOR = " ";
    public static final String EMPTY = "";
    public static final String TABULATION = "\t";

    private static final Logger logger = Logger.getLogger(Utils.class);

    private static Properties property;

    public static void initProperty() {
        logger.info("Start property initiation.");
        property = new Properties();
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE)) {
            property.load(input);
        } catch (Exception someException) {
            throwCustomIOException(someException, PROPERTY_FILE);
        }

        logger.info("Property has been loaded from " + PROPERTY_FILE);
    }

    public static String getProperty(String propertyKey) {
        return property.getProperty(propertyKey);
    }

}
