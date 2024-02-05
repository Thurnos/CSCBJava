package informatics.logisticcompany.dto.shipment_status;

import java.time.LocalDateTime;

public class ShipmentStatusDTO {

    private Long id;
    private LocalDateTime lastUpdated;
    private String notes;
    private String catalog;

    public ShipmentStatusDTO() {
    }

    public ShipmentStatusDTO(Long id, LocalDateTime lastUpdated, String notes, String catalog) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.notes = notes;
        this.catalog = catalog;
    }

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

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "ShipmentStatusDTO{" +
                "id=" + id +
                ", lastUpdated=" + lastUpdated +
                ", notes='" + notes + '\'' +
                ", catalog='" + catalog + '\'' +
                '}';
    }
}
