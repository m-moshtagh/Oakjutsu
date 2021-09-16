package com.dogigiri.springcore.springconfiguration.service;

import com.dogigiri.springcore.springconfiguration.repository.GreetingRepository;

public class EnglishGreetingService implements GreetingService{
    private final GreetingRepository greetingRepository;

    public EnglishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String greet() {
        return greetingRepository.englishGreetingService();
    }
}
