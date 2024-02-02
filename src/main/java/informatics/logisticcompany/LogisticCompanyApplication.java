package informatics.logisticcompany;

import informatics.logisticcompany.users.User;
import informatics.logisticcompany.users.UserRepository;
import informatics.logisticcompany.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogisticCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticCompanyApplication.class, args);
    }
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Bean
//    public CommandLineRunner commandLineRunner() {
//
//        return args -> {
//
//            userRepository.save(
//                    new User("alo", "alo@example.com", "alo", false)
//            );
//        };
//    }

}