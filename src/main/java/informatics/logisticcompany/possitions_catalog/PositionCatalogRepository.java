package informatics.logisticcompany.possitions_catalog;

import informatics.logisticcompany.dto.position.PositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionCatalogRepository extends JpaRepository<PositionCatalog, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.position.PositionDTO(p.id, p.name) FROM PositionCatalog p")
    List<PositionDTO> findAllWithPositionDTO();


}
