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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SpittleRepositoryImpl extends Repository implements SpittleRepository {
    private static final Log LOG = LogFactory.getLog(SpitterRepositoryImpl.class);
    private File dbFile;

    public SpittleRepositoryImpl() {
        dbFile = createRepoFile("spittleRepoFile");
//        dbFile = new File("db/spittleRepoFile.txt");
    }

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<Spittle>();
        List<String> list = null;
        try {
            list = FileUtils.readLines(dbFile, Charset.defaultCharset());

            for (String spittleStr : list) {
                String[] strArr = spittleStr.split("\\|");
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                Spittle spittle = new Spittle(strArr[1]);
                spittle.setId(Long.valueOf(strArr[0]));

                spittleList.add(spittle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return SpittleGenerator.generateSpittleList(count);
        return spittleList;
    }

    public Spittle findOne(long spittleId) {
        if (spittleId == 13)
            return null;
        return SpittleGenerator.generateSpittleList(1).get(0);
    }

    public Spittle save(Spittle spittle) throws DublicateSpittleMessageException {
        try {
            Random random = new Random();
            spittle.setId((long) (random.nextInt(15)));

            List<String> list = FileUtils.readLines(dbFile, Charset.defaultCharset());
            for (String s : list) {
                if (spittle.getMessage().equals(s.split("\\|")[1])) {
                    DublicateSpittleMessageException ex = new DublicateSpittleMessageException();

                    throw ex;
                }
            }
            FileUtils.writeStringToFile(dbFile, spittle.toString().concat("\n"), Charset.defaultCharset(), true);
        } catch (IOException e) {
            LOG.error("Error while saving spittle", e);
        }
        return spittle;
    }

    public static void main(String[] args) throws DublicateSpittleMessageException, ParseException {
//        System.out.println(new Date("Thu Jan 29 16:02:53 EET 2009"));
        Date date = new Date();

        System.out.println(date.getTime());

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = dateFormat.format(today);
        System.out.println(todayDate);

        Date date1 = dateFormat.parse(todayDate);
        System.out.println(date1);
    }

}
