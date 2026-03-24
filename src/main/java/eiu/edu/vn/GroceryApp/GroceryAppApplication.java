package eiu.edu.vn.GroceryApp;

import eiu.edu.vn.GroceryApp.model.User;
import eiu.edu.vn.GroceryApp.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GroceryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroceryAppApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository repo, BCryptPasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                repo.save(
                        new User(
                                null,
                                "admin",
                                encoder.encode("123456"),
                                "ROLE_ADMIN"
                        )
                );
            }
        };
    }
}
