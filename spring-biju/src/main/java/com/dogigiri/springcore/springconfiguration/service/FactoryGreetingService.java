package com.dogigiri.springcore.springconfiguration.service;


import com.dogigiri.springcore.springconfiguration.repository.GreetingRepository;

public class FactoryGreetingService {
    private final GreetingRepository greetingRepository;

    public FactoryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService greetingService(String language) {
        return switch (language) {
            case "en":
                yield new EnglishGreetingService(greetingRepository);
            case "es":
                yield new SpanishGreetingService(greetingRepository);
            case "fa":
                yield new PersianGreetingService(greetingRepository);
            default:
                yield null;
        };
    }
}
