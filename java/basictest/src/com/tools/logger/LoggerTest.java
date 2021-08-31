package com.tools.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 16:38:58
 * @Description log4j 测试
 */
public class LoggerTest {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(LoggerTest.class);

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        BasicConfigurator.configure();
//        logger.setLevel(Level.DEBUG);
        PropertyConfigurator.configure(path+ "com/tools/logger/log4j.properties");

        logger.debug(1);
        logger.info(2);

    }
}
