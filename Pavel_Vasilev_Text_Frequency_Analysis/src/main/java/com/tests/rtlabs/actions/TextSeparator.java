package com.tests.rtlabs.actions;

import com.tests.rtlabs.actions.io.TextReader;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tests.rtlabs.Utils.*;

/**
 * Created by 1 on 01.04.2017.
 */
public class TextSeparator {

    private static final Logger logger = Logger.getLogger(TextSeparator.class);

    public static List<String> separateText(String text4Separate, String stopWordsDictionary, String regexWordSeparator) {
        logger.info("Start separated function.");

        List<String> listWords = new LinkedList<>();
        Set<String> stopDictionary = TextReader.getRows(stopWordsDictionary);
        StringBuilder ignoredWordBuilder = new StringBuilder();

        // Save some separator or empty string
        String currentSeparator = EMPTY;
        Pattern regExPatern = Pattern.compile(regexWordSeparator);
        Matcher regExMatcher = regExPatern.matcher(text4Separate);
        if (regExMatcher.find()) {
            currentSeparator = regExMatcher.group();
        }

        // remove stop words from text
        for (String ignoredWord : stopDictionary) {
            // first stop word in text
            ignoredWordBuilder.setLength(0);
            ignoredWordBuilder.append(REGEX_START_TEXT).append(ignoredWord).append(regexWordSeparator).append(REGEX_POSTFIX);
            text4Separate = text4Separate.replaceAll(ignoredWordBuilder.toString(), currentSeparator);

            // last stop word in text
            ignoredWordBuilder.setLength(0);
            ignoredWordBuilder.append(regexWordSeparator)
                    .append(REGEX_POSTFIX)
                    .append(ignoredWord)
                    .append(REGEX_END_TEXT);
            text4Separate = text4Separate.replaceAll(ignoredWordBuilder.toString(), currentSeparator);

            // middle stop word in text
            ignoredWordBuilder.setLength(0);
            ignoredWordBuilder.append(regexWordSeparator)
                    .append(REGEX_POSTFIX)
                    .append(ignoredWord)
                    .append(regexWordSeparator)
                    .append(REGEX_POSTFIX);
            text4Separate = text4Separate.replaceAll(ignoredWordBuilder.toString(), currentSeparator);
        }
        logger.info("Words from stop words dictionary has been removed from text.");

        // separate text
        for (String word : text4Separate.split(regexWordSeparator)) {
            if (word.isEmpty()) continue;
            listWords.add(word);
        }
        logger.info("All text has been separated by regexp " + regexWordSeparator);
        return listWords;
    }

}
