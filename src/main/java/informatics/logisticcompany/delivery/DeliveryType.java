package informatics.logisticcompany.delivery;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
@Entity
@Table(name = "delivery_types")
public class DeliveryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_type_id")
    private int id;

    @Column(name = "delivery_type_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "DeliveryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
