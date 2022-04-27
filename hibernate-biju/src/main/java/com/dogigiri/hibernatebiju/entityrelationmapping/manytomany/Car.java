package com.dogigiri.hibernatebiju.entityrelationmapping.manytomany;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "model")
    private String model;
    @ManyToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    private Set<Person> people = new HashSet<>();

    public Car() {
    }

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public Car setPeople(Set<Person> people) {
        this.people = people;
        return this;
    }
}
