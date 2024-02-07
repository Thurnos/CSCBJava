package informatics.logisticcompany.office_branches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing office branches.
 * Provides endpoints for retrieving and creating office branches.
 */
@Controller
@RequestMapping("/office-branches")
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




    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable("id") Long id) {
        officeBranchService.deleteOfficeBranch(id);
        return "redirect:/office-branches/list";
    }


    @GetMapping("/list")
    public String listOffices(Model model) {
        List<OfficeBranch> officeList = officeBranchService.getAllOffices();
        model.addAttribute("officeList", officeList);
        return "office/list-offices";
    }

    @GetMapping("/create")
    public String showCreateOfficeForm(Model model) {
        model.addAttribute("officeBranch", new OfficeBranch()); // Add an empty OfficeBranch object to bind the form
        return "/office/create-offices";
    }

    @PostMapping("/create")
    public String createOffice(@ModelAttribute OfficeBranch officeBranch) {
        officeBranchService.createOfficeBranch(officeBranch);
        return "redirect:/office-branches/list";
    }


    @PostMapping("/edit/{id}")
    public String editOffice(@PathVariable Long id, Model model) {
        Optional<OfficeBranch> officeBranchOptional = officeBranchService.findById(id);
        if (officeBranchOptional.isPresent()) {
            OfficeBranch officeBranch = officeBranchOptional.get();
            model.addAttribute("officeBranch", officeBranch);
            return "office/edit-offices";
        } else {
            return "redirect:/office-branches/list";
        }
    }






    }





