package informatics.logisticcompany.pricing_tier;

import informatics.logisticcompany.delivery.DeliveryType;
import informatics.logisticcompany.shipment.Shipment;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pricing_tier")
public class PricingTier {

    @Id
    @Column(name = "pricing_tier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

    @Column(name = "pricing_min_weight")
    private BigDecimal minWeight;

    @Column(name = "pricing_max_weight")
    private BigDecimal maxWeight;

    @Column(name = "pricing_base_cost")
    private BigDecimal baseCost;

    @Column(name = "pricing_cost_per_unit_weight")
    private BigDecimal costPerUnitWeight;

    @OneToMany(mappedBy = "pricingTier")
    private Set<Shipment> shipments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(BigDecimal minWeight) {
        this.minWeight = minWeight;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public BigDecimal getCostPerUnitWeight() {
        return costPerUnitWeight;
    }

    public void setCostPerUnitWeight(BigDecimal costPerUnitWeight) {
        this.costPerUnitWeight = costPerUnitWeight;
    }

    public PricingTier() {  }

    public PricingTier(DeliveryType deliveryType, BigDecimal minWeight, BigDecimal maxWeight, BigDecimal baseCost, BigDecimal costPerUnitWeight) {
        this.deliveryType = deliveryType;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.baseCost = baseCost;
        this.costPerUnitWeight = costPerUnitWeight;
    }

    @Override
    public String toString() {
        return "PricingTier{" +
                "id=" + id +
                ", deliveryType=" + deliveryType +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", baseCost=" + baseCost +
                ", costPerUnitWeight=" + costPerUnitWeight +
                '}';
    }
}
