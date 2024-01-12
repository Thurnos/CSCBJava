package informatics.logisticcompany.office_branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeBranchService {
    private final OfficeBranchRepository officeBranchRepository;

    @Autowired
    public OfficeBranchService(OfficeBranchRepository officeBranchRepository) {
        this.officeBranchRepository = officeBranchRepository;
    }

    public List<OfficeBranch> getAllOfficeBranches() {
        return officeBranchRepository.findAll();
    }

    public OfficeBranch createOfficeBranch(OfficeBranch officeBranch) {
        return officeBranchRepository.save(officeBranch);
    }
}
