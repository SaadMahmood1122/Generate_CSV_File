package pk.futurenostics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailDto {
	
	private Integer id;
	private String name;
	private String email;
	private String address;

}
