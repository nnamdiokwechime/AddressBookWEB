package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    /*@Bean
    public CommandLineRunner demo(final AddressBookRepository repository) {
        return (args) -> {
            // save a few customers
            AddressBook book = new AddressBook();
            book.addBuddy(new BuddyInfo("nnamdi", "no number"));
            repository.save(book);

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (AddressBook customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");


        };*/
    //}

}