package com.dogigiri.springcore.springconfiguration.config;

import com.dogigiri.springcore.springconfiguration.repository.GreetingRepository;
import com.dogigiri.springcore.springconfiguration.service.FactoryGreetingService;
import com.dogigiri.springcore.springconfiguration.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfiguration {
    @Bean
    public FactoryGreetingService factoryGreetingService(GreetingRepository repository) {
        return new FactoryGreetingService(repository);
    }

    @Bean
    @Primary
    @Profile("en")
    public GreetingService englishGreetingService(FactoryGreetingService factoryGreetingService) {
        return factoryGreetingService.greetingService("en");
    }

    @Bean
    @Primary
    @Profile({"default", "fa"})
    public GreetingService persianGreetingService(FactoryGreetingService factoryGreetingService) {
        return factoryGreetingService.greetingService("fa");
    }

    @Bean
    @Primary
    @Profile("es")
    public GreetingService spanishGreetingService(FactoryGreetingService factoryGreetingService) {
        return factoryGreetingService.greetingService("es");
    }
}
