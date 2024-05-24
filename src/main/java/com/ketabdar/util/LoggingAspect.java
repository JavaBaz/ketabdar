package com.ketabdar.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.ketabdar.repository.*.*(..)) || execution(* com.ketabdar.service.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("beforeMethodExecution");
        logger.info(" ---> Entering method " + className + "." + methodName);
    }


    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void afterMethodExecution(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        String className = methodSignature.getDeclaringTypeName();

        if (methodSignature.getReturnType().equals(Void.TYPE)) {
            logger.info(" <--- Exiting method " + className + "." + methodName + " (void)");
        } else {
            if (result == null) {
                logger.info(" <--- Exiting method " + className + "." + methodName + ", returned result: null");
            } else {
                logger.info(" <--- Exiting method " + className + "." + methodName + ", returned result: " + result);
            }
        }
    }
}