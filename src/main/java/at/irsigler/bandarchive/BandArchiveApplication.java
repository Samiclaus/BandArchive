package at.irsigler.bandarchive;

import at.irsigler.bandarchive.musician.Musician;
import at.irsigler.bandarchive.musician.MusicianRepository;
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
    public CommandLineRunner demo(MusicianRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Musician("Jack", "Bauer"));
            repository.save(new Musician("Chloe", "O'Brian"));
            repository.save(new Musician("Kim", "Bauer"));
            repository.save(new Musician("David", "Palmer"));
            repository.save(new Musician("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Musician customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Musician customer = repository.findById(1L).orElseThrow(IllegalAccessException::new);
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
