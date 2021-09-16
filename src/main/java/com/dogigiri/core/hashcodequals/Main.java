package com.dogigiri.core.hashcodequals;

public class Main {
    public static void main(String[] args) {
        Athlete athlete = new Athlete();
        Athlete athlete2 = new Athlete();
        Athlete athlete3 = new Athlete();
        athlete.setAthleteId(1).setName("mohammad").setField("kendo");
        athlete2.setAthleteId(1).setName("mohammad").setField("wushu");
        athlete3.setAthleteId(2).setName("aida").setField("taekwondo");

        System.out.println(athlete2.equals(athlete));
    }
}
