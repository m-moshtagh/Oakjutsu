package com.dogigiri.core.compareobjects;

public class Athlete implements Comparable<Athlete>{
    private long athleteId;
    private String athleteName;
    private String field;
    private int age;

    public long getAthleteId() {
        return athleteId;
    }

    public Athlete setAthleteId(long athleteId) {
        this.athleteId = athleteId;
        return this;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public Athlete setAthleteName(String athleteName) {
        this.athleteName = athleteName;
        return this;
    }

    public String getField() {
        return field;
    }

    public Athlete setField(String field) {
        this.field = field;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Athlete setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public int compareTo(Athlete o) {
        return (int) (getAthleteId() - o.getAthleteId());
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteId=" + athleteId +
                ", athleteName='" + athleteName + '\'' +
                ", field='" + field + '\'' +
                ", age=" + age +
                '}';
    }
}
