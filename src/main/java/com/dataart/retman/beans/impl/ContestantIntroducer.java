package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Contestant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents(value = "com.dataart.retman.beans.Performer+",
            defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
