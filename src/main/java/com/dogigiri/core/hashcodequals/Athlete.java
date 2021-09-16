package com.dogigiri.core.hashcodequals;

import org.apache.commons.lang3.builder.EqualsBuilder;


public class Athlete {
    private long athleteId;
    private String name;
    private String field;

    public long getAthleteId() {
        return athleteId;
    }

    public Athlete setAthleteId(long athleteId) {
        this.athleteId = athleteId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Athlete setName(String name) {
        this.name = name;
        return this;
    }

    public String getField() {
        return field;
    }

    public Athlete setField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;
        return new EqualsBuilder().append(getAthleteId(), athlete.getAthleteId()).append(getName(), athlete.getName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).append(getAthleteId()).append(getName()).toHashCode();
    }
}
