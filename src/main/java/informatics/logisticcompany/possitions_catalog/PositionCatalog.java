package informatics.logisticcompany.possitions_catalog;

import informatics.logisticcompany.employees.Employee;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "position_catalog")
public class PositionCatalog {

    @Id
    @Column(name = "position_catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_name")
    private String name;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

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

    public PositionCatalog() {  }

    public PositionCatalog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PositionCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}