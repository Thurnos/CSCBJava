package informatics.logisticcompany.possitions_catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for handling requests related to position catalogs.
 * Provides REST endpoints for operations such as retrieving all positions
 * and creating a new position within the catalog.
 */
@RestController
@RequestMapping("/api/positions")
public class PositionCatalogController {
    private final PositionCatalogService positionCatalogService;


    /**
     * Constructor for dependency injection of PositionCatalogService.
     *
     * @param positionCatalogService Service layer that handles business logic for position catalog operations.
     */
    @Autowired
    public PositionCatalogController(PositionCatalogService positionCatalogService) {
        this.positionCatalogService = positionCatalogService;
    }

    /**
     * Retrieves a list of all positions in the catalog.
     *
     * @return A list of PositionCatalog entities.
     */
    @GetMapping
    public List<PositionCatalog> getAllPositions() {
        return positionCatalogService.getAllPositions();
    }

    /**
     * Creates a new position in the catalog based on the provided position data.
     *
     * @param position The PositionCatalog entity to be created.
     * @return The created PositionCatalog entity.
     */
    @PostMapping
    public PositionCatalog createPosition(@RequestBody PositionCatalog position) {
        return positionCatalogService.createPosition(position);
    }
}
