package informatics.logisticcompany.shipment_status_cataloc;
import informatics.logisticcompany.shipment_status.ShipmentStatus;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shipment_status_catalog")
public class ShipmentStatusCatalog {

    @Id
    @Column(name = "shipment_status_catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_status_name")
    private String name;

    @OneToMany(mappedBy = "shipmentStatus")
    private Set<ShipmentStatus> shipmentStatuses;

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

    public ShipmentStatusCatalog() {  }

    public ShipmentStatusCatalog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShipmentStatusCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}