package com.dataart.retman.beans.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    private static final Log LOG = LogFactory.getLog(Audience.class);

    @Pointcut("execution(* com.dataart.retman.beans.Performer.perform(..))")
    public void performance(){

    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cee phones");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAPP CLAPP CLAPP CLAPP CLAPP");
    }

    @AfterThrowing("performance()")
    public void demandRefaund() {
        System.out.println("The audience is demanding the refaund");
    }

    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            takeSeats();
            turnOffCellPhones();
            long startTime = System.currentTimeMillis();

            proceedingJoinPoint.proceed();

            long endTime = System.currentTimeMillis();

            applaud();
            System.out.println("The performance took " + ((endTime - startTime) / 1000) + " seconds");

        } catch (Throwable throwable) {
            LOG.error("Performance Exception occured", throwable);
        }

    }
}
