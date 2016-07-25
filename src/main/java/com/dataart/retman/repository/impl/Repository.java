package com.dataart.retman.repository.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;

public class Repository {
    private static final Log LOG = LogFactory.getLog(Repository.class);
    private static final String DB_FOLDER_NAME = "db";

    protected Repository() {
        createRepoFolder(DB_FOLDER_NAME);
    }

    private boolean createRepoFolder(String folderName) {
        boolean res = false;
        File file = new File(folderName);
        try {
            res = file.mkdir();
        } catch (Exception e) {
            LOG.error("Error while creating DB dir", e);
        }
        return res;
    }

    private void removeFolder(String folderName) {
        File folder = new File(folderName);
        System.out.println(folder.isDirectory());
        if (folder.isDirectory()) {
            String[] fileArr = folder.list();
            for (String fileName : fileArr) {
                System.out.println(fileName);
                File fileToDelete = new File(folderName + "/" + fileName);
                fileToDelete.delete();
            }
        }
        folder.delete();
    }


    protected File createRepoFile(String spittleRepoFileName) {
        File file = new File(DB_FOLDER_NAME + "/" + spittleRepoFileName.concat(".txt"));
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOG.error("Problem creating repo File", e);
        }
        return file;
    }


}
