package com.mowcoder.Luntan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = App.class)
public class LoggerTests {
    private static final Logger logger= LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        //trace（）;//追踪级别，一般不用
        logger.debug("debuglog");//调试级别日志
        logger.info("infolog");//普通级别
        logger.warn("warnlog");//警告级别
        logger.error("error");//错误级别
    }
}
