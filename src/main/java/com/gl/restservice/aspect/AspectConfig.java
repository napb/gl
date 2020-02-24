package com.gl.restservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Around("execution(* com.gl.restservice.*.*.*(..))")
    public Object interceptAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("metodo: " + proceedingJoinPoint.getSignature().getName());

        return proceedingJoinPoint.proceed();
    }
}
