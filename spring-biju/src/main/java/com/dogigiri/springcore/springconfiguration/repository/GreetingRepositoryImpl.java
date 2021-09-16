package com.dogigiri.springcore.springconfiguration.repository;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {
    @Override
    public String englishGreetingService() {
        return "Hello";
    }

    @Override
    public String persianGreetingService() {
        return "سلام";
    }

    @Override
    public String spanishGreetingService() {
        return "Hola";
    }
}
