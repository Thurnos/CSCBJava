package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.client.ClientDTO;
import informatics.logisticcompany.dto.user.UserBasicInfo;

public class ClientDTOMapper {
    public static ClientDTO mapToClientDTO(Object[] data) {
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
}
