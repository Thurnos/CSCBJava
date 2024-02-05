package informatics.logisticcompany.dto.client;

import informatics.logisticcompany.dto.user.UserBasicInfo;

public class ClientDTO {

    private UserBasicInfo userBasicInfo;
    private String clientFirstName;
    private String clientLastName;
    private String clientAddress;
    private String clientPhoneNumber;
    private String logisticCompanyName;


    public ClientDTO(UserBasicInfo userBasicInfo, String clientFirstName, String clientLastName, String clientAddress, String clientPhoneNumber, String logisticCompanyName) {
        this.userBasicInfo = userBasicInfo;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientAddress = clientAddress;
        this.clientPhoneNumber = clientPhoneNumber;
        this.logisticCompanyName = logisticCompanyName;
    }
    private ClientDTO mapToClientDTO(Object[] data) {
        UserBasicInfo userBasicInfo = new UserBasicInfo(
                (Long) data[0],
                (String) data[1],
                (String) data[2]
        );

        return new ClientDTO(
                userBasicInfo,
                (String) data[3],
                (String) data[4],
                (String) data[5],
                (String) data[6],
                (String) data[7]
        );
    }

    public UserBasicInfo getUserBasicInfo() {
        return userBasicInfo;
    }

    public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
        this.userBasicInfo = userBasicInfo;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getLogisticCompanyName() {
        return logisticCompanyName;
    }

    public void setLogisticCompanyName(String logisticCompanyName) {
        this.logisticCompanyName = logisticCompanyName;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "userBasicInfo=" + userBasicInfo +
                ", clientFirstName='" + clientFirstName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", logisticCompanyName='" + logisticCompanyName + '\'' +
                '}';
    }
}
