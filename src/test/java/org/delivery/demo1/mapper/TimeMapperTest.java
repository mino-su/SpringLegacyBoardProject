package org.delivery.demo1.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
class TimeMapperTest {
    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testTime1() {
        log.info("-----------");
        log.info(timeMapper.getTime());
    }

    @Test
    public void testTime2() {
        log.info("=========================");
        log.info(timeMapper.getTime2());
    }

}