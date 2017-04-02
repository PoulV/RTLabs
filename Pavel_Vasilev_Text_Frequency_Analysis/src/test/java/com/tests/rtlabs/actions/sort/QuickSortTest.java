package com.tests.rtlabs.actions.sort;

import com.tests.rtlabs.exceptions.CustomSortException;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 1 on 01.04.2017.
 */
public class QuickSortTest {
    private static final Logger logger = Logger.getLogger(QuickSortTest.class);
    private Map<String, Integer> map4Test;
    private AbstractSorter4Map testSorter;

    @Before
    public void initTestData() {
        testSorter = new QuickSort();
        map4Test = new LinkedHashMap<>();
        map4Test.put("three", 3);
        map4Test.put("one", 1);
        map4Test.put("four", 4);
        map4Test.put("two", 2);
    }

    @After
    public void afterTest() {
        logger.info("Test complete.");
    }

    @Test
    public void sortMapTest() throws Exception {
        logger.info("Start test QuickSort.sortMap");

        // test not null
        Map<String, Integer> actualSortedMap = testSorter.sortMap(map4Test);
        Assert.assertNotNull(actualSortedMap);

        // test order
        StringBuilder stringOrderBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> currentEntry : actualSortedMap.entrySet()) {
            stringOrderBuilder.append(currentEntry.getValue().toString())
                    .append(" ");
        }
        Assert.assertEquals("1 2 3 4 ", stringOrderBuilder.toString());
    }

    @Test(expected = CustomSortException.class)
    public void sortEmptyMapTest() throws Exception {
        logger.info("Start negative test QuickSort.sortMap");
        Map<String, Integer> actualSortedMap = testSorter.sortMap(null);
        Assert.assertNotNull(actualSortedMap);
    }

}