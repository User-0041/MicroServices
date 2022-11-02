package org.id.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryserviceApplication {
	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	}

	@Bean
CommandLineRunner start(ProductRepository productRepository){
return args -> {
productRepository.save(new Product(null,"Computer Desk Top HP",900));
productRepository.save(new Product(null,"Printer Epson",80));
productRepository.save(new Product(null,"MacBook Pro LapTop",1800));
productRepository.findAll().forEach(System.out::println);
};
}
}
