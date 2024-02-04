package informatics.logisticcompany.dto.shipment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ShipmentDTO {
    private Long id;
    private UUID uuid;
    private String destination;
    private BigDecimal weight;
    private LocalDateTime createdAt;
    private BigDecimal totalCost;
    private String sender;
    private String recipient;
    private String registeredBy;
    private String deliveryType;
    private String status;
    private String logisticCompany;
    private Long pricingTier;

    public ShipmentDTO() {
    }

    public ShipmentDTO(Long id, UUID uuid, String destination, BigDecimal weight, LocalDateTime createdAt, BigDecimal totalCost, String sender, String recipient, String registeredBy, String deliveryType, String status, String logisticCompany, Long pricingTier) {
        this.id = id;
        this.uuid = uuid;
        this.destination = destination;
        this.weight = weight;
        this.createdAt = createdAt;
        this.totalCost = totalCost;
        this.sender = sender;
        this.recipient = recipient;
        this.registeredBy = registeredBy;
        this.deliveryType = deliveryType;
        this.status = status;
        this.logisticCompany = logisticCompany;
        this.pricingTier = pricingTier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
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

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(String logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public Long getPricingTier() {
        return pricingTier;
    }

    public void setPricingTier(Long pricingTier) {
        this.pricingTier = pricingTier;
    }

    @Override
    public String toString() {
        return "ShipmentDTO{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", createdAt=" + createdAt +
                ", totalCost=" + totalCost +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", registeredBy='" + registeredBy + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", status='" + status + '\'' +
                ", logisticCompany='" + logisticCompany + '\'' +
                ", pricingTier=" + pricingTier +
                '}';
    }
}
