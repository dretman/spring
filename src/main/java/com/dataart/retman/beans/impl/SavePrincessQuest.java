package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Quest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SavePrincessQuest implements Quest {
    private static final Log LOG = LogFactory.getLog(SavePrincessQuest.class);

    public void doTheQuest() {
        LOG.info("Save Princess!");
    }
}
