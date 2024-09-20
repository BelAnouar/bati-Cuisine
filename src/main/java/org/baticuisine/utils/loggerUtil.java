package org.baticuisine.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggerUtil {
    private static final Logger log = LoggerFactory.getLogger(loggerUtil.class);

    public static void info(String msg) {
        log.info(msg);
    }
    public static void error(String msg) {
        log.error(msg);
    }
}
