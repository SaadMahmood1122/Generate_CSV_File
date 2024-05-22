package pk.futurenostics.utils;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.bean.BeanField;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CustomColumnPositionAndNameStrategy<T> extends ColumnPositionMappingStrategy<T> {
	
	public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
		
		final int numColumns = getFieldMap().values().size();
		super.generateHeader(bean);

		var header = new String[numColumns];
		for (int i = 0; i < numColumns; i++) {
		
		var beanField = findField(i);
		String columnHeaderName = extractHeaderName (beanField);
	
		header[i] = columnHeaderName;
		
		}
		return header;
		
	}
		private String extractHeaderName (final BeanField beanField) {
		
		if (beanField == null|| beanField.getField() == null
		|| beanField.getField().getDeclaredAnnotationsByType(CsvBindByName.class).length == 0) {
			log.info("expected null......");
		return StringUtils.EMPTY;
		
		}


		final CsvBindByName bindByNameAnnotation =
		beanField.getField().getDeclaredAnnotationsByType (CsvBindByName.class)[0];
		
		return bindByNameAnnotation.column();
	
		}
	
	
	}


