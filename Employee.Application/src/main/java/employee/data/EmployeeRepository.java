package employee.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

import employee.data.EmployeeDetails;

public interface EmployeeRepository extends MongoRepository<EmployeeDetails,String>{
	
	public Collection<EmployeeDetails> findAllByFirstNameContains(String firstName);
	public List<EmployeeDetails> findAllByLastNameContains(String lastName);
	public Collection<EmployeeDetails> findAllByDesignationContains(String designation);
	public Collection<EmployeeDetails> findBySalaryGreaterThan(double salary);
	
	

}
