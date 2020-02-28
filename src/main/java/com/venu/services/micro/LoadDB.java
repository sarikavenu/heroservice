package com.venu.services.micro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDB {

	@Bean
	CommandLineRunner initDB(HeroRepository repository) {
		return args -> {
			repository.save(new Hero("Dr Nice"));
			repository.save(new Hero("Narco"));
			repository.save(new Hero("Bombasto"));
			repository.save(new Hero("Celeritas"));
			repository.save(new Hero("Magneta"));
			repository.save(new Hero("RubberMan"));
			repository.save(new Hero("Dynama"));
			repository.save(new Hero("Dr IQ"));
			repository.save(new Hero("Magma"));
			repository.save(new Hero("Tornado"));
		};
	}
}
