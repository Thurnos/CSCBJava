package informatics.logisticcompany.pricing_tier;

import informatics.logisticcompany.dto.pricing_tier.PricingTierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingTierService {

    private final PricingTierRepository pricingTierRepository;

    @Autowired
    public PricingTierService(PricingTierRepository pricingTierRepository) {
        this.pricingTierRepository = pricingTierRepository;
    }

    public List<PricingTierDTO> getAllWithPricingTierDTO() {
        return pricingTierRepository.findAllWithPricingTierDTO();
    }
}
