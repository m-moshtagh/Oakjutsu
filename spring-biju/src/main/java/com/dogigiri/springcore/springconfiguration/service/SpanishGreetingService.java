package com.dogigiri.springcore.springconfiguration.service;

import com.dogigiri.springcore.springconfiguration.repository.GreetingRepository;

public class SpanishGreetingService implements GreetingService{
    private final GreetingRepository greetingRepository;

    public SpanishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String greet() {
        return greetingRepository.spanishGreetingService();
    }
}
