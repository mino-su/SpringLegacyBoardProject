package org.delivery.demo1.db;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;


@ExtendWith(SpringExtension.class) // Jupiter 확장용 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 테스트시 로딩해야 하는 파일
@Log4j2
public class DBTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void getConnect() {

        log.info("----------");
        log.info(dataSource);
        log.info("----------");
    }



}
