package org.id.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerserviceApplication {
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){return args -> {
		customerRepository.save(new Customer(null,"Enset","contact@enset-media.ma")); customerRepository.save(new
		Customer(null,"FSTM","contact@fstm.ma")); customerRepository.save(new
		Customer(null,"ENSAM","contact@ensam.ma"));
		customerRepository.findAll().forEach(System.out::println);};

}
}
