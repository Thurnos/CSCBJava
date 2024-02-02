package informatics.logisticcompany;

import informatics.logisticcompany.logistic_companies.LogisticCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticCompanyApplication.class, args);
    }
//
    @Autowired
    LogisticCompanyService logisticCompanyService;

    /*
    @Bean
    public CommandLineRunner commandLineRunner() {

        return args -> {

          logisticCompanyService.deleteCompany(1l);


        };
    }
   */
}