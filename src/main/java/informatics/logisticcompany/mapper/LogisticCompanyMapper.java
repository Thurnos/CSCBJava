package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Component for mapping between LogisticCompany entities and LogisticCompanyDTOs.
 * Utilizes ModelMapper to automate the conversion process, reducing the need for manual mapping code.
 */
@Component
public class LogisticCompanyMapper {

    // TODO: Moje da se dobavi final
    private final ModelMapper modelMapper;


    /**
     * Constructs a LogisticCompanyMapper with an injected ModelMapper instance.
     * This setup allows for flexible and configurable object mapping.
     *
     * @param modelMapper The ModelMapper instance used for object mapping.
     */
    @Autowired
    public LogisticCompanyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    /**
     * Converts a LogisticCompany entity to a LogisticCompanyDTO.
     *
     * @param logisticCompany The LogisticCompany entity to convert.
     * @return A LogisticCompanyDTO that represents the entity's data.
     */
    public LogisticCompanyDTO convertToDTO(LogisticCompany logisticCompany) {

        LogisticCompanyDTO logisticCompanyDTO = modelMapper.map(logisticCompany, LogisticCompanyDTO.class);

        return logisticCompanyDTO;
    }


    /**
     * Converts a LogisticCompanyDTO to a LogisticCompany entity.
     *
     * @param logisticCompanyDTO The LogisticCompanyDTO to convert.
     * @return A LogisticCompany entity populated with the DTO's data.
     */
    public LogisticCompany convertToEntity(LogisticCompanyDTO logisticCompanyDTO) {

        LogisticCompany logisticCompany = modelMapper.map(logisticCompanyDTO, LogisticCompany.class);

        return logisticCompany;
    }
}
