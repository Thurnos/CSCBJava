package informatics.logisticcompany.office_branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service for handling operations related to office branches.
 * This includes retrieving all office branches and creating new ones.
 */
@Service
public class OfficeBranchService {
    private final OfficeBranchRepository officeBranchRepository;


    /**
     * Constructs the service with the required repository.
     *
     * @param officeBranchRepository The repository for accessing office branch data.
     */
    @Autowired
    public OfficeBranchService(OfficeBranchRepository officeBranchRepository) {
        this.officeBranchRepository = officeBranchRepository;
    }


    /**
     * Retrieves all office branches from the database.
     *
     * @return A list of OfficeBranch entities.
     */
    public List<OfficeBranch> getAllOfficeBranches() {
        return officeBranchRepository.findAll();
    }


    /**
     * Saves a new office branch to the database.
     *
     * @param officeBranch The OfficeBranch entity to save.
     * @return The saved OfficeBranch entity.
     */
    public OfficeBranch createOfficeBranch(OfficeBranch officeBranch) {
        return officeBranchRepository.save(officeBranch);
    }

    public void deleteOfficeBranch(Long id) {
        officeBranchRepository.deleteById(id);
    }

    public OfficeBranch updateOfficeBranch(Long id, OfficeBranch updatedOfficeBranch) {
        Optional<OfficeBranch> existingOfficeBranch = officeBranchRepository.findById(id);  // Retrieve the existing OfficeBranch by its ID
        // check if the existing OfficeBranch is present in the repository
        if (existingOfficeBranch.isPresent()) {
            OfficeBranch officeBranch = existingOfficeBranch.get();  // If present, get the OfficeBranch object

            // update the properties of the existing OfficeBranch with the values from the updatedOfficeBranch
            officeBranch.setName(updatedOfficeBranch.getName());
            officeBranch.setAddress(updatedOfficeBranch.getAddress());
            officeBranch.setLogisticCompany(updatedOfficeBranch.getLogisticCompany());
            // save the updated OfficeBranch back to the repository
            return officeBranchRepository.save(officeBranch);
        }
        // If the OfficeBranch with the given ID is not found, return null
        return null;
    }


    }
