package informatics.logisticcompany.office_branches;

import informatics.logisticcompany.dto.office_branch.OfficeBranchDTO;
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


    public List<OfficeBranchDTO> getAllWithOfficeBranchDTO() {
        return officeBranchRepository.findAllWithOfficeBranchDTO();
    }

    public List<OfficeBranch> getAllOffices() {
        return officeBranchRepository.findAll();
    }

    public OfficeBranch getOfficeBranchById(Long id) {
        return officeBranchRepository.findById(id).orElse(null);
    }

    public Optional<OfficeBranch> findById(Long id) {
        return officeBranchRepository.findById(id);
    }


    public void updateOfficeBranch(Long id, OfficeBranch updatedOfficeBranch) {
        Optional<OfficeBranch> officeBranchOptional = officeBranchRepository.findById(id);
        if (officeBranchOptional.isPresent()) {
            OfficeBranch officeBranch = officeBranchOptional.get();
            // Update properties of officeBranch with values from updatedOfficeBranch
            officeBranch.setName(updatedOfficeBranch.getName());
            officeBranch.setAddress(updatedOfficeBranch.getAddress());
            // Update other properties as needed
            officeBranchRepository.save(officeBranch);
        }

    }


}
