package org.delivery.demo1.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Before("execution(* org.delivery.demo1.service.*.*(..))")
    public void logParams(JoinPoint jp) {
        log.info("-----------------------");
        log.info("logsParams");
        Object[] params = jp.getArgs();
        log.info(Arrays.toString(params));
        Object target = jp.getTarget();
        log.info(target);
        log.info("-----------------------");
    }

    @Around("execution(* org.delivery.demo1.service.*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        log.info("-----------------------");
        log.info("logsTimes");
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("-----------------------");
        log.info("TIME: " + (end - start));
        return result;
    }
}
