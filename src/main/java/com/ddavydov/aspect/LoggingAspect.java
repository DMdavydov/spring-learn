package com.ddavydov.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ddavydov.controller.*.*(..))")
    public void forControllerPackage() {
    }

    @Pointcut("execution(* com.ddavydov.service.*.*(..))")
    public void forServicePackage() {
    }

    @Pointcut("execution(* com.ddavydov.repository.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        log.info("===> in @Before: calling method: " + method);

        Object[] argsPointcut = joinPoint.getArgs();

        for (Object arg : argsPointcut) {
            log.info("===> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void after(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().toShortString();
        log.info("===> in @AfterReturning: from method: " + method);

        log.info("===> result: " + result);

    }
}

