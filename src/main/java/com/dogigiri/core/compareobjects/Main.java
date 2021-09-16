package com.dogigiri.core.compareobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Athlete athlete1 = new Athlete().setAthleteId(1).setAthleteName("bolt").setField("running").setAge(37);
        Athlete athlete2 = new Athlete().setAthleteId(2).setAthleteName("johnson").setField("running").setAge(22);

        System.out.println("by ID");
        List<Athlete> athletesById = Arrays.asList(athlete2, athlete1);
        athletesById.forEach(System.out::println);
        System.out.println("*******");
        Collections.sort(athletesById);
        athletesById.forEach(System.out::println);

        System.out.println("by Age");
        List<Athlete> athletesByAge = Arrays.asList(athlete2, athlete1);
        athletesById.forEach(System.out::println);
        System.out.println("*******");
        athletesByAge.sort(new AthleteAgeComparator());
        athletesByAge.forEach(System.out::println);
    }
}
