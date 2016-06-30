package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Poem;
import com.dataart.retman.exception.PerformanceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PoeticJaggler extends Juggler {
    private static final Log LOG = LogFactory.getLog(PoeticJaggler.class);
    private Poem poem;

    public PoeticJaggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJaggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
