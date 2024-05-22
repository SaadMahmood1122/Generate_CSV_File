package pk.futurenostics.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pk.futurenostics.model.EmployeeCsvDto;
import pk.futurenostics.model.EmployeeDetailDto;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface DtoMapper {
	List<EmployeeCsvDto>  employeeDetailDtoToEmployeeCsv(List<EmployeeDetailDto> empDetailDto);
	
	EmployeeCsvDto employeeDetailDtoToEmployeeCsv(EmployeeDetailDto empDetailDto);

}
