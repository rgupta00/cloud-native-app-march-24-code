package com.busycoder.bankapp.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect //Aspect =advice +pointcut
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution( * com.busycoder.bankapp.service.*Impl.*(..))")
    public Object applyLogging(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        String methodName=proceedingJoinPoint.getSignature().getName();
        long startTime=System.currentTimeMillis();

        Object retValue=proceedingJoinPoint.proceed();

        long endTime=System.currentTimeMillis();
        logger.info("time taken to execute "+ methodName+" is "+(endTime-startTime)+" ms");
        return retValue;
    }
    //we have to handle BankAccNo... AfterThrowing
    @AfterThrowing(pointcut = "execution( * com.busycoder.bankapp.service.*Impl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        logger.error("Exception -------------- "+ ex.getMessage());
    }
}
