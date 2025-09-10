package org.delivery.demo1.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Before("execution(* org.delivery.demo1.service.*.*(..))")
    public void logParams() {
        log.info("-----------------------");
        log.info("logsParams");
        log.info("-----------------------");
    }
}
