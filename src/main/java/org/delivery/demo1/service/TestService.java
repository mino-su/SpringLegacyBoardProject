package org.delivery.demo1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.delivery.demo1.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class TestService {
    private final TestMapper testMapper;

    public void insertAll(String string) {
        int resultA = testMapper.insertA(string);
        log.info("insertA " + resultA);
        int resultB = testMapper.insertB(string);
        log.info("insertB "+ resultB);
    }
}
