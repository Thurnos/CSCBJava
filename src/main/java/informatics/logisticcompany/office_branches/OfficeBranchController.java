package informatics.logisticcompany.office_branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing office branches.
 * Provides endpoints for retrieving and creating office branches.
 */
@RestController
@RequestMapping("/api/office-branches")
public class OfficeBranchController {
    private final OfficeBranchService officeBranchService;


    /**
     * Constructs the controller with the required service.
     * @param officeBranchService The service that will handle all office branch operations.
     */
    @Autowired
    public OfficeBranchController(OfficeBranchService officeBranchService) {
        this.officeBranchService = officeBranchService;
    }

    /**
     * Retrieves a list of all office branches.
     * @return A list of OfficeBranch entities.
     */
    @GetMapping
    public List<OfficeBranch> getAllOfficeBranches() {
        return officeBranchService.getAllOfficeBranches();
    }


    /**
     * Creates a new office branch from the provided office branch data.
     * @param officeBranch The office branch data to create a new office branch.
     * @return The created OfficeBranch entity.
     */
    @PostMapping
    public OfficeBranch createOfficeBranch(@RequestBody OfficeBranch officeBranch) {
        return officeBranchService.createOfficeBranch(officeBranch);
    }
}

