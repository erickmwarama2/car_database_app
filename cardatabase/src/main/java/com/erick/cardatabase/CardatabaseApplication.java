package com.erick.cardatabase;

import com.erick.cardatabase.domain.Car;
import com.erick.cardatabase.domain.Owner;
import com.erick.cardatabase.domain.User;
import com.erick.cardatabase.repositories.CarRepository;
import com.erick.cardatabase.repositories.OwnerRepository;
import com.erick.cardatabase.repositories.UserRepository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CardatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		//test dev tools
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello spring boot application developed by erick mutwiri");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// ownerRepository.save(new Owner("Erick",""))
			Owner owner1 = new Owner("Erick", "Mutwiri");
			Owner owner2 = new Owner("Jeff", "Bezos");

			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			repository.save(new Car("BMW","X5","metallic blue","KCA 121J",2013,3000000, owner1));
			repository.save(new Car("Toyota","Vanguard","Silver","KCD 348P",2015, 2450000, owner2));

			userRepository.save(new User("erick","$2a$10$WmJIAhoo3z0TXkJwTJfeEuJDqlDERwjUw/mGS1HpK7fO/9UUGT.jG","Developer"));
			userRepository.save(new User("benta", "$2a$10$TAGCnWX/NZNxeEj7K7L4Wuh1TiXcEOxO7jpRC3lfF126Co.tDXztC", "Admin"));

			System.out.println(repository.findByRegisterNumber("KCJ 124V"));
		};
	}

}
