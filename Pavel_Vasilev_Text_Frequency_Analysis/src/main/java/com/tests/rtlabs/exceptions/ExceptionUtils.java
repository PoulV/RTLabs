package com.tests.rtlabs.exceptions;

import org.apache.log4j.Logger;

/**
 * Created by 1 on 01.04.2017.
 */
public class ExceptionUtils {

    private static final Logger logger = Logger.getLogger(ExceptionUtils.class);
    private static final String FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException";


    public static void throwCustomIOException(Exception ioException, String filePath) {
        String exceptionSimpleName = ioException.getClass().getSimpleName();
        String exceptionFullName = ioException.getClass().getName();

        StringBuilder messageBuilder = new StringBuilder();
        switch (exceptionSimpleName) {
            case FILE_NOT_FOUND_EXCEPTION:
                messageBuilder.append("File \"")
                        .append(filePath)
                        .append("\" is not found!");
                logger.error(messageBuilder.toString(), ioException);
                throw new CustomIOException(messageBuilder.toString(), ioException);
            default:
                messageBuilder.append("Raise ")
                        .append(exceptionFullName)
                        .append(" when try work with \"")
                        .append(filePath)
                        .append("\"!");
                logger.error(messageBuilder.toString(), ioException);
                throw new CustomIOException(messageBuilder.toString(), ioException);
        }
    }
}
