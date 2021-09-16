package com.dogigiri.springcore.springconfiguration.service;

import com.dogigiri.springcore.springconfiguration.repository.GreetingRepository;

public class PersianGreetingService implements GreetingService{
    private final GreetingRepository greetingRepository;

    public PersianGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String greet() {
        return greetingRepository.persianGreetingService();
    }
}
