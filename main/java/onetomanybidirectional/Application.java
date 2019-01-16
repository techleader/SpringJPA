package onetomanybidirectional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		//System.setProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans","true");
	/*	System.setProperty("spring.jpa.show-sql","true");
		System.setProperty("spring.jpa.properties.hibernate.format_sql","true");
		System.setProperty("spring.jpa.show-sql","true");
		System.setProperty("spring.jpa.show-sql","true");*/
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository, CardRepository cardRepository) {
		return (args) -> {
			// save a couple of customers
			Customer jack = new Customer("Jack", "Bauer");
			Customer kim = new Customer("Kim", "Bauer");
			repository.save(jack);
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(kim);
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString() );// + "...... > Cards : "+ customer.getCards());
			}
			log.info("");
			Card c = new Card("Citi");
			//c.(jack);
			Card c1 = new Card("Hdfc");
		//	c1.setCustomer(jack);

			Set<Card> cards = new HashSet<>();
			cards.add(c);
			cards.add(c1);
			jack.setCards(cards);
			log.info("-------Saving Cards-------------");
			repository.save(jack);
			log.info("-------------------------------");

			c = new Card("American");
			//c.(jack);
			c1 = new Card("SBI");
			//	c1.setCustomer(jack);

			cards = new HashSet<>();
			cards.add(c);
			cards.add(c1);
			kim.setCards(cards);
			log.info("-------Saving Cards-------------");
			repository.save(kim);
			log.info("-------------------------------");

			printCards(cardRepository);

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastNameWithCards("Bauer").forEach(bauer -> {
				log.info("Bauer " + bauer.toString());
				log.info(bauer.getCards().toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

	private void printCards(CardRepository cardRepository) {
		log.info("Cards");
		log.info("-------------------------------");
		for (Card card : cardRepository.findAll()) {
			log.info(card.toString());
			//	log.info(card.getCustomer().getFirstName());
		}
		log.info("-------------------------------");
	}

}
