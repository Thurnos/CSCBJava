package informatics.logisticcompany.possitions_catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionCatalogRepository extends JpaRepository<PositionCatalog, Long> {
    // additional custom queries can be added here
}
