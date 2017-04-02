package com.tests.rtlabs.actions;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 01.04.2017.
 */
public class FrequencyAnalyserTest {
    private static final Logger logger = Logger.getLogger(FrequencyAnalyserTest.class);
    private List<String> separatedText;

    @Before
    public void initTestData() {
        separatedText = new LinkedList<>(Arrays.asList("2", "1", "2"));
    }

    @After
    public void afterTest() {
        logger.info("Test complete.");
    }

    @Test
    public void getMapFromSeparatedText() throws Exception {
        logger.info("Start test FrequencyAnalyser.getMapFromSeparated");
        Map<String, Integer> frequencyMap = FrequencyAnalyser.getMapFromSeparatedText(separatedText);
        Assert.assertNotNull(frequencyMap);
        Assert.assertEquals((int) frequencyMap.get("1"), 1);
        Assert.assertEquals((int) frequencyMap.get("2"), 2);
    }

}