package com.dataart.retman.repository.impl;

import com.dataart.retman.SpittleGenerator;
import com.dataart.retman.domain.Spittle;
import com.dataart.retman.exception.DublicateSpittleMessageException;
import com.dataart.retman.repository.SpittleRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

public class SpittleRepositoryImpl extends Repository implements SpittleRepository {
    private static final Log LOG = LogFactory.getLog(SpitterRepositoryImpl.class);
    private File dbFile;

    public SpittleRepositoryImpl() {
        dbFile = createRepoFile("spittleRepoFile");
//        dbFile = new File("db/spittleRepoFile.txt");
    }

    public List<Spittle> findSpittles(long max, int count) {
        return SpittleGenerator.generateSpittleList(count);
    }

    public Spittle findOne(long spittleId) {
        if (spittleId == 13)
            return null;
        return SpittleGenerator.generateSpittleList(1).get(0);
    }

    public Spittle save(Spittle spittle) throws DublicateSpittleMessageException {
        try {
            List<String> list = FileUtils.readLines(dbFile, Charset.defaultCharset());
            for (String s : list) {
                if (spittle.getMessage().equals(s.split("\\|")[1])) {
                    DublicateSpittleMessageException ex = new DublicateSpittleMessageException();

                    throw ex;
                }
            }
            FileUtils.writeStringToFile(dbFile, spittle.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            LOG.error("Error while saving spittle", e);
        }
        return spittle;
    }

    public static void main(String[] args) throws DublicateSpittleMessageException {
        SpittleRepository spittleRepository = new SpittleRepositoryImpl();
        Spittle spittle = new Spittle("rjramomyhj13", new Date());
        spittleRepository.save(spittle);
    }

}
