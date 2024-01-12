package informatics.logisticcompany.possitions_catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionCatalogController {
    private final PositionCatalogService positionCatalogService;

    @Autowired
    public PositionCatalogController(PositionCatalogService positionCatalogService) {
        this.positionCatalogService = positionCatalogService;
    }

    @GetMapping
    public List<PositionCatalog> getAllPositions() {
        return positionCatalogService.getAllPositions();
    }

    @PostMapping
    public PositionCatalog createPosition(@RequestBody PositionCatalog position) {
        return positionCatalogService.createPosition(position);
    }
}
