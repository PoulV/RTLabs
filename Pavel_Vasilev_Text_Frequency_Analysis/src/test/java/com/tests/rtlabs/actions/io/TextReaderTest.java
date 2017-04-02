package com.tests.rtlabs.actions.io;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static com.tests.rtlabs.TestUtils.*;

/**
 * Created by 1 on 01.04.2017.
 */
public class TextReaderTest {
    private static final Logger logger = Logger.getLogger(TextReaderTest.class);
    private String testFilePath = "";

    @Before
    public void initTestData() {
        initProperty();
        testFilePath = getProperty(PROPERY_KEY_TEST_FILE);
    }

    @After
    public void afterTest() {
        logger.info("Test complete.");
    }

    @Test
    public void getStringFromFile() throws Exception {
        logger.info("Start test TextReader.getStringFromFile");
        String actualString = TextReader.getStringFromFile(testFilePath);
        Assert.assertEquals("1 2 3 ", actualString);
    }

    @Test
    public void getRows() throws Exception {
        logger.info("Start test TextReader.getRows");
        Set<String> actualSet = TextReader.getRows(testFilePath);
        Assert.assertTrue(actualSet.contains("1"));
        Assert.assertTrue(actualSet.contains("2"));
        Assert.assertTrue(actualSet.contains("3"));
        Assert.assertEquals(actualSet.size(), 3);
    }

}