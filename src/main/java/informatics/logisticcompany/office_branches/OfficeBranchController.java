package informatics.logisticcompany.office_branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office-branches")
public class OfficeBranchController {
    private final OfficeBranchService officeBranchService;

    @Autowired
    public OfficeBranchController(OfficeBranchService officeBranchService) {
        this.officeBranchService = officeBranchService;
    }

    @GetMapping
    public List<OfficeBranch> getAllOfficeBranches() {
        return officeBranchService.getAllOfficeBranches();
    }

    @PostMapping
    public OfficeBranch createOfficeBranch(@RequestBody OfficeBranch officeBranch) {
        return officeBranchService.createOfficeBranch(officeBranch);
    }
}

