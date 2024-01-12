package informatics.logisticcompany.possitions_catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionCatalogService {
    private final PositionCatalogRepository positionCatalogRepository;

    @Autowired
    public PositionCatalogService(PositionCatalogRepository positionCatalogRepository) {
        this.positionCatalogRepository = positionCatalogRepository;
    }

    public List<PositionCatalog> getAllPositions() {
        return positionCatalogRepository.findAll();
    }

    public PositionCatalog createPosition(PositionCatalog position) {
        return positionCatalogRepository.save(position);
    }
}
