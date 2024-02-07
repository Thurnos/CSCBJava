package informatics.logisticcompany.dto.logistic_companies;

import java.time.LocalDate;

public class LogisticCompanyDTO {

    private Long id;
    private String name;
    private String address;
    private LocalDate foundationDate;

    public LogisticCompanyDTO() {
    }

    public LogisticCompanyDTO(Long id, String name, String address, LocalDate foundationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.foundationDate = foundationDate;
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "LogisticCompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
