package pk.futurenostics.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeCsvDto {
	@CsvBindByName(column = "emp_name")
	@CsvBindByPosition(position= 0)
	private String name;
	@CsvBindByName(column = "emp_email")
	@CsvBindByPosition(position= 1)
	private String email;
	@CsvBindByName(column = "emp_address")
	@CsvBindByPosition(position= 2)
	private String address;

}
