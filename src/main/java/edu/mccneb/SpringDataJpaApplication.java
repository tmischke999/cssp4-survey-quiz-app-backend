package edu.mccneb;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.mccneb.model.Order;
import edu.mccneb.model.Product;
import edu.mccneb.repository.OrderRepository;
import edu.mccneb.repository.ProductRepository;


public class SpringDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, OrderRepository orderRepository) {
		return (args) -> {
			
			//create some orders
			//"Order for soccer items"
			
			Product p = new Product("cricket-bat", "cricket", "9 grain kashmir willow", new BigDecimal(10.00));
			
			orderRepository.save(new Order("Order for Cricket Equipment", new Product("Bat Face", "cricket", "Bat face protection", new BigDecimal(10.00)), 
					new Product("Bat Face", "cricket", "Bat face protection", new BigDecimal(10.00)),
					p
					
					));
			
			
			orderRepository.save(new Order("Order for Soccer Equipment", new Product("soccer-ball", "soccer", "adidas glider 2", new BigDecimal(2.99)), 
					new Product("soccer-ball-pump", "soccer", "12 inch. air pump", new BigDecimal(12.65)),
					new Product("soccer-socks", "soccer", "adidas copa zone cushion 4", new BigDecimal(7.49)), 
					p));
			
			
				
			log.info("Fetching all products...");
			for (Product product : productRepository.findAll()) {
				log.info(product.toString());
			}

			log.info("Finding products by name ...");
			for (Product product : productRepository.findByName("soccer-ball-pump")) {
				log.info(product.toString());
			}
			log.info("Finding products by category ...");
			for (Product product : productRepository.findByCategory("soccer")) {
				log.info(product.toString());
			}
			log.info("Finding products by price ...");
			for (Product product : productRepository.findByPrice(new BigDecimal(2.99))) {
				log.info(product.toString());
			}
			log.info("Finding products by description ...");
			for (Product product : productRepository.findByDescription("adidas copa zone cushion 4")) {
				log.info(product.toString());
			}
			log.info("Finding products in a certain price range ... ");
			for (Product product : productRepository.findByPriceRange(new BigDecimal(5), new BigDecimal(11))) {
				log.info(product.toString());
			}
			log.info("Finding products in a certain price range using native query ... ");
			for (Product product : productRepository.findByPriceRangeUsingNativeQuery(new BigDecimal(5), new BigDecimal(11))) {
				log.info(product.toString());
			}

		};
	}
}
/*
 * // fetch all Products log.info("Products found with findAll():");
 * log.info("-------------------------------"); for (Product product :
 * productRepository.findAll()) { log.info(product.toString()); }
 * 
 * log.info("Products found with findByPriceRange($5,$11"); for (Product product
 * : productRepository.findByPriceRange(new BigDecimal("5.00"), new
 * BigDecimal("11.00"))) { log.info(product.toString()); }
 * 
 * log.info("fetch an individual product by name soccer-ball"); // a line break
 * for readability
 * 
 * // fetch an individual product by name
 * productRepository.findByName("soccer-ball").forEach(product -> {
 * log.info(product.toString()); }); log.info("");
 * 
 * 
 * log.
 * info("fetch an individual product by name using native query.. searcing for soccer-ball"
 * ); // a line break for readability
 * 
 * // fetch an individual product by name
 * productRepository.findByNameNativeQuery("soccer-ball").forEach(product -> {
 * log.info(product.toString()); }); log.info("");
 * 
 * }; }
 * 
 * }
 */
