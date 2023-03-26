package at.irsigler.bandarchive;

import at.irsigler.bandarchive.composer.Composer;
import at.irsigler.bandarchive.composer.ComposerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BandArchiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BandArchiveApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ComposerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Composer("Jack", "Bauer"));
            repository.save(new Composer("Chloe", "O'Brian"));
            repository.save(new Composer("Kim", "Bauer"));
            repository.save(new Composer("David", "Palmer"));
            repository.save(new Composer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Composer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Composer customer = repository.findById(1L).orElseThrow(IllegalAccessException::new);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }

}
