package com.busycoder.bankapp.service.aspect;

import com.busycoder.bankapp.service.AccountServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect //advice +pointcut
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);
    //around advice :Sec, Tx cahcing
   // @Around("execution( * *.*Impl.*(..))")
    @Around("execution( * com.busycoder.bankapp.service..*Impl.*(..))")
    public Object aroundLoggingAdice(ProceedingJoinPoint pjp) throws Throwable {
        //I need to get the info of the method for which it is called
        String methodName= pjp.getSignature().getName();
        long startTime=System.currentTimeMillis();

        Object value=pjp.proceed();

        long endTime=System.currentTimeMillis();
        logger.info("time taken: to call "+methodName+" is "+(endTime-startTime)+" ms");

        return value;
    }
}
