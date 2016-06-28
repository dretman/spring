package com.dataart.retman.beans.impl;

import com.dataart.retman.beans.Knight;
import com.dataart.retman.beans.Quest;

public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        this.quest.doTheQuest();
    }
}
