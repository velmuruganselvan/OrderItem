package com.oms.orderitem.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.oms.orderitem.controller.OrderItemController.*(..))")
    private void controllerMethods() {
    }

    @Pointcut("execution(* com.oms.orderitem.service.impl.OrderItemServiceImpl.*(..))")
    private void serviceClassMethods() {
    }

    @Around("controllerMethods() || serviceClassMethods()")
    private Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Before Method: {}.{}, Args: {}", proceedingJoinPoint.getTarget().getClass().getSimpleName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
        MDC.put("Exception", proceedingJoinPoint.getSignature().toString());
        Object result = proceedingJoinPoint.proceed();
        logger.info("After Method: {}.{}, Args: {}", proceedingJoinPoint.getTarget().getClass().getSimpleName(), proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
        return result;
    }

}
