package callcenter.models.initializers;

import java.util.ArrayList;
import java.util.List;

import callcenter.models.Employee;

/**
 * @author Andrea
 *
 */
public class EmployeesInitializer {
	
	/** metodo para llenar arreglo de empleados
	 * @return
	 */
	public static List<Employee> getEmployees(){
		List<Employee>employees= new ArrayList<Employee>();
		for(int i=1;i<=5;i++){
			Employee emp= new Employee("Operario "+i,1);
			employees.add(emp);
		}
		
		for(int i=1;i<=3;i++){
			Employee emp= new Employee("supervisor "+i,2);
			employees.add(emp);
		}
		
		for(int i=1;i<=3;i++){
			Employee emp= new Employee("director "+i,3);
			employees.add(emp);
		}		
		return employees;
	}
	
}
