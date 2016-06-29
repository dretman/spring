package com.dataart.retman.beans.impl;

public class Stage {
    private String stageName;

    private Stage() {
        stageName = "This is the Stage";
    }

    private static class StageSingletonHolder {
        static Stage stage = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.stage;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "stageName='" + stageName + '\'' +
                '}';
    }
}
