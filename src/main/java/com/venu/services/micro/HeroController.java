package com.venu.services.micro;

import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@RequestMapping("/list")
public class HeroController {
	
	Logger logger = LoggerFactory.getLogger(HeroController.class);
	
	@Autowired
	private HeroRepository heroRepository;
	
	@GetMapping
	public List<Hero> getHeros(){
		logger.info("Getting List of Heros");
		return heroRepository.findAll();
	}
	
	@PostMapping
	public Hero create(@RequestBody Hero hero,HttpServletRequest request) {
		return heroRepository.save(hero);
	}
	
	@PutMapping("list/{id}")
	public Hero udpate(@RequestBody Hero hero, @PathVariable Long id,HttpServletRequest request) {
		return heroRepository.findById(id).map(existingHero -> {
			existingHero.setName(hero.getName());
			return heroRepository.save(existingHero);
		}).orElseGet( () -> {
			hero.setId(id);
			return heroRepository.save(hero);
		});
	}
	
	@GetMapping("/{id}")
	Optional<Hero> getHero(@PathVariable Long id) {
		return heroRepository.findById(id);
	}

	@GetMapping("/?name={name}")
	Optional<Hero> searchHero(@PathVariable String name) {
		return heroRepository.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		heroRepository.deleteById(id);;
	}
	
}
