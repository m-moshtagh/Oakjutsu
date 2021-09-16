package com.dogigiri.core.immutableobject;

public class ImmutableObjectDemo {
    private final long id;
    private final String name;
    private final String jobTitle;

    public ImmutableObjectDemo(long id, String name, String jobTitle) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public void printInfo() {
        System.out.println(id + " " + name + " " + jobTitle);
    }
}
