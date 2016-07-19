package com.dataart.retman.repository.impl;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.repository.SpitterRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class SpitterRepositoryImpl implements SpitterRepository {
    private static final Log LOG = LogFactory.getLog(SpitterRepositoryImpl.class);
    private File dbFile;

    public SpitterRepositoryImpl() {
        File file = new File("db");
        file.mkdir();
        dbFile = new File("db/repo.txt");
        try {
            dbFile.createNewFile();
        } catch (IOException e) {
            LOG.error("Error while creation  repo.txt", e);
        }
    }

    public Spitter save(Spitter spitter) {
        try {
            FileUtils.writeStringToFile(dbFile, spitter.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            LOG.error("Error while creation saving", e);
        }
        return spitter;
    }

    public Spitter findByUsername(String username) {
        Spitter spitter = null;
        try {
            String res = FileUtils.readFileToString(dbFile, Charset.defaultCharset());
            String[] stringArr = res.split("\\|");
            spitter = new Spitter(Long.parseLong(stringArr[0]), stringArr[1], stringArr[2], stringArr[3], stringArr[4]);
        } catch (IOException e) {
            LOG.error("Error while reading dbFile", e);
        }
        return spitter;
    }

    public static void main(String[] args) throws IOException {
        Spitter spitter = new Spitter(13, "Denis", "Retman", "disa", "12345");
        SpitterRepository spitterRepository = new SpitterRepositoryImpl();
//        System.out.println(spitterRepository.save(spitter));
        System.out.println(spitterRepository.findByUsername("dd").getFirstName());
    }
}
