package informatics.logisticcompany.office_branches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeBranchRepository extends JpaRepository<OfficeBranch, Long> {
    // additional custom queries can be added here
}
