package informatics.logisticcompany.pricing_tier;

import informatics.logisticcompany.dto.pricing_tier.PricingTierDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingTierRepository extends JpaRepository<PricingTier, Long> {

    @Query("SELECT new informatics.logisticcompany.dto.pricing_tier.PricingTierDTO(p.id, p.deliveryType.name) FROM PricingTier p")
    List<PricingTierDTO> findAllWithPricingTierDTO();
}
