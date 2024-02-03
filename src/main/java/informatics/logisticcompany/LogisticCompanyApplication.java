package informatics.logisticcompany;

import informatics.logisticcompany.office_branches.OfficeBranchRepository;
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

    @Autowired
    OfficeBranchRepository officeBranchRepository;

    @Bean
   public CommandLineRunner commandLineRunner() {

        return args -> {

            officeBranchRepository.deleteById(
                    1l);
        };
    }

}