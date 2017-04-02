package com.tests.rtlabs;

import com.tests.rtlabs.actions.FrequencyAnalyser;
import com.tests.rtlabs.actions.TextSeparator;
import com.tests.rtlabs.actions.io.TextReader;
import com.tests.rtlabs.actions.io.TextWriter;
import com.tests.rtlabs.actions.sort.AbstractSorter4Map;
import com.tests.rtlabs.actions.sort.QuickSort;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

import static com.tests.rtlabs.Utils.*;

/**
 * Created by 1 on 01.04.2017.
 */
public class Runner {

    private static final Logger logger = Logger.getLogger(Runner.class);

    public Runner() {
    }

    public static void run() {
        logger.info("Execute run function.");
        initProperty();
        String inputFilePath = getProperty(PROPERTY_KEY_INPUT);
        String outputFilePath = getProperty(PROPERTY_KEY_OUTPUT);
        String stopWordsDictionary = getProperty(PROPERTY_KEY_STOP_WORD_DICTIONARY);
        String regexWordSeparator = getProperty(PROPERTY_KEY_REGEX_WORD_SEPARATOR);

        AbstractSorter4Map sorter = new QuickSort();
        String text4Analyse;
        List<String> separatedText;
        Map<String, Integer> frequencyMap;
        Map<String, Integer> sortedMap;

        text4Analyse = TextReader.getStringFromFile(inputFilePath);
        separatedText = TextSeparator.separateText(text4Analyse, stopWordsDictionary, regexWordSeparator);
        frequencyMap = FrequencyAnalyser.getMapFromSeparatedText(separatedText);
        sortedMap = sorter.sortMap(frequencyMap);
        TextWriter.writeMap2File(sortedMap, outputFilePath);
    }
}
