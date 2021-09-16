package com.dogigiri.core.jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService service = PersonService.getInstance();
//        service.save(new Person().setFirstName("Elon").setLastName("Tusk").setAge(49));
//        service.update(new Person().setPersonId(1).setFirstName("elon").setLastName("musk").setAge(49));
        service.saveAll(List.of(new Person().setFirstName("Elon").setLastName("Tusk").setAge(49),
                new Person().setPersonId(1).setFirstName("elon").setLastName("musk").setAge(49)));
        service.findAll().stream().forEach(System.out::println);
    }
}