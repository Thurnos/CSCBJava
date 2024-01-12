package informatics.logisticcompany.shipment_status_cataloc;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
@Entity
@Table(name = "shipment_status_catalog")
public class ShipmentStatusCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_status_catalog_id")
    private Long id;

    @Column(name = "shipment_status_name")
    private String name;

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

    @Override
    public String toString() {
        return "ShipmentStatusCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

// Getters, setters, and constructors
}
