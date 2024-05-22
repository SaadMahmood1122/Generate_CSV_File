package pk.futurenostics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import pk.futurenostics.service.CaseMapService;

@RestController
@RequestMapping("/download-Csv")
public class CsvFileDownloadController {
	@Autowired
	private CaseMapService caseMapService;
	
	
	@PostMapping(value ="/empId", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE )
	public ResponseEntity<StreamingResponseBody> download(){
		Integer empId= 10;
		return ResponseEntity.ok()
				.headers(caseMapService.getCsvDownloadHeaders())
				.body(caseMapService.generateDownloadFile(empId));
		
	}

}
