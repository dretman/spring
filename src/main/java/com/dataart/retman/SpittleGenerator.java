package com.dataart.retman;

import com.dataart.retman.domain.Spittle;
import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;
import org.jfairy.producer.text.TextProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpittleGenerator {

    private static Spittle generateSpittle() {
        Random random = new Random();
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        TextProducer textProducer = fairy.textProducer();

        return new Spittle(textProducer.randomString(10), random.nextDouble(), random.nextDouble());
    }

    public static List<Spittle> generateSpittleList(int listSize) {
        List<Spittle> spittles = new ArrayList<Spittle>();

        for (int i = 0; i < listSize; i++) {
            spittles.add(generateSpittle());
        }

        return spittles;
    }

    private static void showList(List tList) {
        for (Object t : tList)
            System.out.println(t);
    }

    public static void main(String[] args) {
        showList(SpittleGenerator.generateSpittleList(5));
        System.out.println("--------------------------------------");
        showList(SpittleGenerator.generateSpittleList(5));
    }

}
