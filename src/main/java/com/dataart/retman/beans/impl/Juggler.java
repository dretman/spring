package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Performer;
import com.dataart.retman.exception.PerformanceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Juggler implements Performer {
    private static final Log LOG = LogFactory.getLog(Juggler.class);

    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perform() throws PerformanceException {
        LOG.info("JUGGLING " + beanBags + " BEANBAGS");
    }
}
