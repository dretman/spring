package com.dataart.retman.aspect;

import com.dataart.retman.beans.CriticismEngine;

public aspect JudgeAspect {
    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    pointcut performance(): execution(* perform(..));

    after()returning():performance(){
        System.out.println(criticismEngine.getCriticism());
    }

}
