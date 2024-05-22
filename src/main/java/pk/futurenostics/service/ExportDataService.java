package pk.futurenostics.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import lombok.extern.slf4j.Slf4j;
import pk.futurenostics.utils.CustomColumnPositionAndNameStrategy;

@Service
@Slf4j
public class ExportDataService {
	
	public <T> StreamingResponseBody generateCsvFileFromObjects(List<T> records, Class<T> tClass) {
		
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				OutputStreamWriter streamWriter = new OutputStreamWriter(out);
				CSVWriter writer = new CSVWriter(streamWriter))
		{
			log.info("records are {}",records);
			
			 CustomColumnPositionAndNameStrategy<T>  mappingStrategy= new CustomColumnPositionAndNameStrategy<T>();
			mappingStrategy.setType(tClass);
			
			StatefulBeanToCsv<T> builder = new StatefulBeanToCsvBuilder<T>(writer)
					.withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
					.withMappingStrategy(mappingStrategy)
					.build();
			builder.write(records);
			streamWriter.flush();

			return out::writeTo;
		} catch (Exception e) {
			log.error("Exception generated in generateCsvFileFromObjects() method.........");
			return null;
		}
		
	}

}
