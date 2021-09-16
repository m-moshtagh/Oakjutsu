package com.dogigiri.core.compareobjects;

import java.util.Comparator;

public class AthleteAgeComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete athlete1, Athlete athlete2) {
        return Integer.compare(athlete1.getAge(), athlete2.getAge());
    }
}
