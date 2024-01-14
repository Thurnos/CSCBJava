package informatics.logisticcompany.shipment_status;

import informatics.logisticcompany.shipment.Shipment;
import informatics.logisticcompany.shipment_status_cataloc.ShipmentStatusCatalog;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "shipment_status")
public class ShipmentStatus {

    @Id
    @Column(name = "shipment_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "shipment_notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "shipment_status_status_id")
    private ShipmentStatusCatalog shipmentStatus;

    @OneToMany(mappedBy = "shipmentStatus")
    private Set<Shipment> shipments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ShipmentStatusCatalog getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatusCatalog shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public ShipmentStatus() {  }

    public ShipmentStatus(LocalDateTime lastUpdated, String notes, ShipmentStatusCatalog shipmentStatus) {
        this.lastUpdated = lastUpdated;
        this.notes = notes;
        this.shipmentStatus = shipmentStatus;
    }

    @Override
    public String toString() {
        return "ShipmentStatus{" +
                "id=" + id +
                ", lastUpdated=" + lastUpdated +
                ", notes='" + notes + '\'' +
                ", shipmentStatus=" + shipmentStatus +
                '}';
    }
}