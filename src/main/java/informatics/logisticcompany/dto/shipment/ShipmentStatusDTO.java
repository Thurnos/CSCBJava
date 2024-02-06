package informatics.logisticcompany.dto.shipment;

import informatics.logisticcompany.shipment_status.ShipmentStatus;

public class ShipmentStatusDTO {

    private Long id;
    private String sender;
    private String recipient;
    private ShipmentStatus shipmentStatus;

    public ShipmentStatusDTO() {
    }

    public ShipmentStatusDTO(Long id, String sender, String recipient, ShipmentStatus shipmentStatus) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.shipmentStatus = shipmentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    @Override
    public String toString() {
        return "ShipmentStatusDTO{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", shipmentStatus=" + shipmentStatus +
                '}';
    }
}
