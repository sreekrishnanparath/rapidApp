package com.jst.rapidapp.utils.aop;


import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.beans.configuration.AuthenticationResponse;
import com.jst.rapidapp.beans.configuration.GenericResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class AOPUtility {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    DateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

//    @Before("execution(* com.jst..*(..)))")
//    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
//
//        LOGGER.info("======TECHGEEKNEXT - Spring Boot AOP Before Advice Example ");
//        LOGGER.info("=====Started with method "
//                + joinPoint.getSignature().getName()); // Method Name
//    }

//    @Before(value = "execution(* com.jst.rapidapp.controllers.*.*.*(..))")
//    public void beforeLogging(JoinPoint joinPoint)
//    {
//        LOGGER.info("#ReqProcessStart =>" + joinPoint.getSignature() + "#Params => "+Arrays.asList(joinPoint.getArgs()));
//    }


    @Around(value = "execution(* com.jst.rapidapp.controllers.*.*.*(..))")
    public Object responseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        LOGGER.info("#ReqProcessStart =>" + proceedingJoinPoint.getSignature() + "#Params => "+Arrays.asList(proceedingJoinPoint.getArgs()));

        GenericResponse genericResponse = null;
        try{
            Object returnValue = proceedingJoinPoint.proceed();
            if(returnValue instanceof  GenericResponse) {
                genericResponse = (GenericResponse) returnValue;
            }else {
                return  returnValue;
            }
        }finally {

        }
        long endTime = System.currentTimeMillis() - startTime;
        LOGGER.info("#ReqProcessTime =>" + endTime );
        genericResponse.setResponseTime(String.valueOf(endTime));
        return genericResponse;
    }
}
