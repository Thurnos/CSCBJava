package informatics.logisticcompany.possitions_catalog;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
@Entity
@Table(name = "position_catalog")
public class PositionCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_catalog_id")
    private Long id;

    @Column(name = "position_name")
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
        return "PositionCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

// Getters, setters, and constructors
}
