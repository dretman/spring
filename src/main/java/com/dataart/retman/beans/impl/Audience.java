package com.dataart.retman.beans.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    private static final Log LOG = LogFactory.getLog(Audience.class);

    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cee phones");
    }

    public void applaud() {
        System.out.println("CLAPP CLAPP CLAPP CLAPP CLAPP");
    }

    public void demandRefaund() {
        System.out.println("The audience is demanding the refaund");
    }

    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            takeSeats();
            turnOffCellPhones();
            long startTime = System.currentTimeMillis();

//            proceedingJoinPoint.proceed();

            long endTime = System.currentTimeMillis();

            System.out.println("The performance took " + ((endTime - startTime) / 1000) + " seconds");

        } catch (Throwable throwable) {
            LOG.error("Performance Exception occured", throwable);
        }

    }
}
