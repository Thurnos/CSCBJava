package informatics.logisticcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticCompanyApplication.class, args);
    }

//    @Autowired
//    OfficeBranchRepository officeBranchRepository;
//
//    @Bean
//   public CommandLineRunner commandLineRunner() {
//
//        return args -> {
//
//            officeBranchRepository.deleteById(
//                    1l);
//        };
//    }

}