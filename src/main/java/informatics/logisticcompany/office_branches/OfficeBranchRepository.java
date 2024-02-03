package informatics.logisticcompany.office_branches;

import informatics.logisticcompany.dto.office_branch.OfficeBranchDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeBranchRepository extends JpaRepository<OfficeBranch, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.office_branch.OfficeBranchDTO(ob.id, ob.name, ob.address) FROM OfficeBranch ob")
    List<OfficeBranchDTO> findAllWithOfficeBranchDTO();
}
