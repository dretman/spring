package com.dataart.retman.beans.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Minstrel {
    private static final Log LOG = LogFactory.getLog(Minstrel.class);

    public void singBeforeQuest() {
        LOG.info("Fa la la; The knight is so brave!");
    }

    public void singAfterQuest() {
        LOG.info("Tee hee he; The brave knight did embark on a quest!");
    }
}
