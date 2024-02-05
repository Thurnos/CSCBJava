package informatics.logisticcompany.dto.employee;

import java.util.Date;

public class EmployeeDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int logisticCompanyId;
    private int officeBranchId;
    private int employeePosition;

    public EmployeeDTO() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getLogisticCompanyId() {
        return logisticCompanyId;
    }

    public void setLogisticCompanyId(int logisticCompanyId) {
        this.logisticCompanyId = logisticCompanyId;
    }

    public int getOfficeBranchId() {
        return officeBranchId;
    }

    public void setOfficeBranchId(int officeBranchId) {
        this.officeBranchId = officeBranchId;
    }

    public int getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(int employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeDTO(int userId, String firstName, String lastName, Date birthDate, int logisticCompanyId, int officeBranchId, int employeePosition) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.logisticCompanyId = logisticCompanyId;
        this.officeBranchId = officeBranchId;
        this.employeePosition = employeePosition;
    }
}