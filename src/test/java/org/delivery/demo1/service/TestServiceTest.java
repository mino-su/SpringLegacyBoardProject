package org.delivery.demo1.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
class TestServiceTest {
    @Autowired
    TestService testService;

    @Test
    public void testAll() {
//        String str = "Alice was beginning to get very tired of sirring by her sister on the bank, and of having nothing";
//        testService.insertAll(str);

        log.info("is Proxy? " + AopUtils.isAopProxy(testService));
        String str = "Alice was beginning";
        testService.insertAll(str);
    }

}