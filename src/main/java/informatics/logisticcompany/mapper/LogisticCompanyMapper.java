package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.logistic_companies.LogisticCompanyDTO;
import informatics.logisticcompany.logistic_companies.LogisticCompany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogisticCompanyMapper {

    // TODO: Moje da se dobavi final
    private final ModelMapper modelMapper;

    @Autowired
    public LogisticCompanyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LogisticCompanyDTO convertToDTO(LogisticCompany logisticCompany) {

        LogisticCompanyDTO logisticCompanyDTO = modelMapper.map(logisticCompany, LogisticCompanyDTO.class);

        return logisticCompanyDTO;
    }

    public LogisticCompany convertToEntity(LogisticCompanyDTO logisticCompanyDTO) {

        LogisticCompany logisticCompany = modelMapper.map(logisticCompanyDTO, LogisticCompany.class);

        return logisticCompany;
    }
}
