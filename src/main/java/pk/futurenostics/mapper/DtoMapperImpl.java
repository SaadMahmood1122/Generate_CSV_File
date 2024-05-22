package pk.futurenostics.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pk.futurenostics.model.EmployeeCsvDto;
import pk.futurenostics.model.EmployeeDetailDto;
@Component
@Slf4j
public class DtoMapperImpl implements DtoMapper{

	@Override
	public List<EmployeeCsvDto> employeeDetailDtoToEmployeeCsv(List<EmployeeDetailDto> empDetailDto) {
		if(empDetailDto == null) {
			log.info("empDetail is null");
			return null;
		}
		
		List<EmployeeCsvDto> list = new  ArrayList<EmployeeCsvDto>(empDetailDto.size());
		for (EmployeeDetailDto empDtildto : empDetailDto) {
			log.info("empDetail is converting to csv {}",empDtildto);
			list.add(employeeDetailDtoToEmployeeCsv(empDtildto));
		}
		return list;
	}

	public EmployeeCsvDto employeeDetailDtoToEmployeeCsv(EmployeeDetailDto empDetailDto) {
		if(empDetailDto == null) {
			return null;
		}
		
		EmployeeCsvDto employeeCsvDto = new EmployeeCsvDto();
		employeeCsvDto.setAddress(empDetailDto.getAddress());
		employeeCsvDto.setName(empDetailDto.getName());
		employeeCsvDto.setEmail(empDetailDto.getEmail());
		return employeeCsvDto;
	}

}
