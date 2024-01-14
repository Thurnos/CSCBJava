package informatics.logisticcompany.shipment;

import informatics.logisticcompany.client.Client;
import informatics.logisticcompany.delivery.DeliveryType;
import informatics.logisticcompany.employees.Employee;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import informatics.logisticcompany.pricing_tier.PricingTier;
import informatics.logisticcompany.shipment_status.ShipmentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_uuid")
    private UUID uuid;

    @Column(name = "shipment_destination")
    private String destination;

    @Column(name = "package_weight")
    private BigDecimal weight;

    @Column(name = "shipment_created")
    private LocalDateTime created;

    @Column(name = "shipment_total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "shipment_sender_id")
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "shipment_recipient_id")
    private Client recipient;

    @ManyToOne
    @JoinColumn(name = "registered_by_employee_id")
    private Employee registeredBy;

    @ManyToOne
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

    @ManyToOne
    @JoinColumn(name = "shipment_status_id")
    private ShipmentStatus shipmentStatus;

    @ManyToOne
    @JoinColumn(name = "logistic_company_id")
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "pricing_tier_id")
    private PricingTier pricingTier;

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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public Employee getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(Employee registeredBy) {
        this.registeredBy = registeredBy;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public PricingTier getPricingTier() {
        return pricingTier;
    }

    public void setPricingTier(PricingTier pricingTier) {
        this.pricingTier = pricingTier;
    }

    public Shipment() {  }

    public Shipment(String destination, BigDecimal weight, LocalDateTime created, BigDecimal total, Client sender, Client recipient, Employee registeredBy, DeliveryType deliveryType, ShipmentStatus shipmentStatus, LogisticCompany logisticCompany, PricingTier pricingTier) {
        this.uuid = UUID.randomUUID();
        this.destination = destination;
        this.weight = weight;
        this.created = created;
        this.total = total;
        this.sender = sender;
        this.recipient = recipient;
        this.registeredBy = registeredBy;
        this.deliveryType = deliveryType;
        this.shipmentStatus = shipmentStatus;
        this.logisticCompany = logisticCompany;
        this.pricingTier = pricingTier;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", created=" + created +
                ", total=" + total +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", registeredBy=" + registeredBy +
                ", deliveryType=" + deliveryType +
                ", shipmentStatus=" + shipmentStatus +
                ", logisticCompany=" + logisticCompany +
                ", pricingTier=" + pricingTier +
                '}';
    }
}