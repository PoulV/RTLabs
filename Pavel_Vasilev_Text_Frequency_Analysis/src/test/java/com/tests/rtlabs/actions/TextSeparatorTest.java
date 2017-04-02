package com.tests.rtlabs.actions;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.tests.rtlabs.TestUtils.*;

/**
 * Created by 1 on 01.04.2017.
 */
public class TextSeparatorTest {
    private static final Logger logger = Logger.getLogger(TextSeparatorTest.class);
    private static final String STRING_4_SEPARATE = "a one to be, two, a";

    private List<String> separatedText;
    private String stopWordsDictionary;
    private String regexWordSeparator;

    @Before
    public void initTestData() {
        initProperty();
        stopWordsDictionary = getProperty(PROPERY_KEY_STOP_WORD_DICTIONARY);
        regexWordSeparator = getProperty(PROPERTY_KEY_REGEX_WORD_SEPARATOR);
    }

    @After
    public void afterTest() {
        logger.info("Test complete.");
    }

    @Test
    public void separateText() throws Exception {
        logger.info("Start test TextSeparator.separateText");
        separatedText = TextSeparator.separateText(STRING_4_SEPARATE, stopWordsDictionary, regexWordSeparator);
        Assert.assertNotNull(separatedText);
        Assert.assertEquals(2, separatedText.size());
        Assert.assertTrue(separatedText.contains("one"));
        Assert.assertTrue(separatedText.contains("two"));
    }

}