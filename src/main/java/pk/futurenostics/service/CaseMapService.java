package pk.futurenostics.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import lombok.extern.slf4j.Slf4j;
import pk.futurenostics.mapper.DtoMapper;
import pk.futurenostics.model.EmployeeCsvDto;
import pk.futurenostics.model.EmployeeDetailDto;
@Service
@Slf4j
public class CaseMapService{
	@Autowired
	private DtoMapper mapper;
	@Autowired
	private ExportDataService exportDataService;
	
	
public StreamingResponseBody generateDownloadFile(Integer id) {
	
	List<EmployeeDetailDto> emps = List.of(new EmployeeDetailDto(12,"khan","khan@gamil.com","swat")
			                               ,new EmployeeDetailDto(13,"ali","ali@gamil.com","dir")
			                               ,new EmployeeDetailDto(14,"babar","babar@gamil.com","swat")
			                               ,new EmployeeDetailDto(15,"rizwan","rizwan@gamil.com","swat"));
	 List<EmployeeCsvDto> csvDtos = mapper.employeeDetailDtoToEmployeeCsv(emps);
	  StreamingResponseBody body = exportDataService.generateCsvFileFromObjects(csvDtos, EmployeeCsvDto.class);
	  log.info("csv file {}",body);
	  String fileName = String.format("%s_Employee.csv", id);
	  log.info("file name is {}",fileName);
	 
return body;
}


	public HttpHeaders getCsvDownloadHeaders() {
		int empId = 10;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+ String.format("%s_Employee.csv", empId));
		headers.set(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		return headers;
	}
}
