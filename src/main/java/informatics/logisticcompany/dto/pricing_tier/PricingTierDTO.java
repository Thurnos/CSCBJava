package informatics.logisticcompany.dto.pricing_tier;

public class PricingTierDTO {

    private Long id;
    private String deliveryType;

    public PricingTierDTO() {
    }

    public PricingTierDTO(Long id, String deliveryType) {
        this.id = id;
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "PricingTierDTO{" +
                "id=" + id +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
