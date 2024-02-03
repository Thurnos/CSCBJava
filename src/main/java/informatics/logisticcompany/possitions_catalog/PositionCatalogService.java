package informatics.logisticcompany.possitions_catalog;

import informatics.logisticcompany.dto.position.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing the position catalog.
 * Handles business logic related to position operations, such as retrieving all positions
 * and adding new positions to the catalog.
 */
@Service
public class PositionCatalogService {
    private final PositionCatalogRepository positionCatalogRepository;



    /**
     * Constructs the service with a repository for position catalog data access.
     *
     * @param positionCatalogRepository The repository for performing CRUD operations on positions.
     */
    @Autowired
    public PositionCatalogService(PositionCatalogRepository positionCatalogRepository) {
        this.positionCatalogRepository = positionCatalogRepository;
    }

    /**
     * Retrieves all positions from the position catalog.
     *
     * @return A list of all PositionCatalog entities.
     */
    public List<PositionCatalog> getAllPositions() {
        return positionCatalogRepository.findAll();
    }

    /**
     * Creates and saves a new position to the position catalog.
     *
     * @param position The PositionCatalog entity to be saved.
     * @return The saved PositionCatalog entity.
     */
    public PositionCatalog createPosition(PositionCatalog position) {
        return positionCatalogRepository.save(position);
    }
    public List<PositionDTO> getAllWithPositionDTO() {
        return positionCatalogRepository.findAllWithPositionDTO();
    }
}
