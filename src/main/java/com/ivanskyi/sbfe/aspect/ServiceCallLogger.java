package com.ivanskyi.sbfe.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceCallLogger {

    @Pointcut("execution(public * com.ivanskyi.sbfe..*(..))")
    public void allServiceMethods() { }

    @Before("allServiceMethods()")
    public void logServiceMethodCall(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.printf("Invoking service method: %s.%s()%n", className, methodName);
    }
}
