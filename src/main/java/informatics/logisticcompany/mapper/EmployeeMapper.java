package informatics.logisticcompany.mapper;

import informatics.logisticcompany.dto.employee.UpdateEmployeeDTO;
import informatics.logisticcompany.employees.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final ModelMapper modelMapper;

    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Employee convertToEntity(UpdateEmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}
