package informatics.logisticcompany.dto.logistic_companies;


import java.math.BigDecimal;
import java.time.LocalDate;

public class LogisticCompanyWithCostDTO extends LogisticCompanyDTO {
    private BigDecimal totalDeliveryCost;

    public LogisticCompanyWithCostDTO(Long id, String name, String address, LocalDate foundationDate, BigDecimal totalDeliveryCost) {
        super(id, name, address, foundationDate);
        this.totalDeliveryCost = totalDeliveryCost;
    }

    // Getter and Setter
    public BigDecimal getTotalDeliveryCost() {
        return totalDeliveryCost;
    }

    public void setTotalDeliveryCost(BigDecimal totalDeliveryCost) {
        this.totalDeliveryCost = totalDeliveryCost;
    }
}
