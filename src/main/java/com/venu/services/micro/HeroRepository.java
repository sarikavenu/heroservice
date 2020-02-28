package com.venu.services.micro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeroRepository extends JpaRepository<Hero, Long> {

	@Query("SELECT t.name FROM Hero t where t.name = :name") 
    Optional<Hero> findByName(@Param("name") String name);
}
