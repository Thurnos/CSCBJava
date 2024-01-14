package informatics.logisticcompany.delivery;

import informatics.logisticcompany.pricing_tier.PricingTier;
import informatics.logisticcompany.shipment.Shipment;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "delivery_types")
public class DeliveryType {

    @Id
    @Column(name = "delivery_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_type_name")
    private String name;

    @OneToMany(mappedBy = "deliveryType")
    private Set<PricingTier> pricingTiers;

    @OneToMany(mappedBy = "deliveryType")
    private Set<Shipment> shipments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliveryType() {  }

    public DeliveryType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
