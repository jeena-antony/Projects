package employee.data;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.mongodb.core.query.Query;

@RestController
@RequestMapping("employees")
public class UserController {

	@Autowired
	private EmployeeRepository employeeRepository;

	public UserController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	/* Method that insert a value to database*/
	@PostMapping
	public void insert(@Valid @RequestBody EmployeeDetails empDetails) {
		this.employeeRepository.insert(empDetails);
		System.out.println("Employee has been added");
	}

	/* Method that selects all documents from database*/
	@GetMapping("/all")
	public Collection<EmployeeDetails> all() {
		Collection<EmployeeDetails> emp = this.employeeRepository.findAll();
		return emp;
	}

	
	/* Method that selects an employee details based on id */
	@GetMapping("/{id}")
	public EmployeeDetails byId(@PathVariable String id) {
		EmployeeDetails emp = this.employeeRepository.findById(id).orElse(null);
		
			return emp;
	}
	
	/* Method that selects an employee's details with the given first name */
	@GetMapping("/byFirstName/{firstName}")
	public Collection<EmployeeDetails> byFirstName(@PathVariable String firstName  ){
		Collection<EmployeeDetails> emp=this.employeeRepository.findAllByFirstNameContains(firstName) ;
		return emp;
	}
	
	/* Method that selects an employee's details with the given last name */
	@GetMapping("/byLastName/{lastName}")
	public Collection<EmployeeDetails> byLastName(@PathVariable String lastName  ){
		Collection<EmployeeDetails> emp=this.employeeRepository.findAllByLastNameContains(lastName) ;
		return emp;
	}
	
	/* Method that selects an employee's details whose designation is as  provided */
	@GetMapping("/byDesignation/{designation}")
	public Collection<EmployeeDetails> byDesignation(@PathVariable String designation  ){
		Collection<EmployeeDetails> emp=this.employeeRepository.findAllByDesignationContains(designation) ;
	return emp;
	}

	
	/* Method that selects an employee's details whose salary greater than the salary provided */
	@GetMapping("/bySalaryGreaterThan/{salary}")
	public Collection<EmployeeDetails> bySalaryGreaterThan(@PathVariable double salary ){
		Collection<EmployeeDetails> emp=this.employeeRepository.findBySalaryGreaterThan(salary) ;
	return emp;
	}

	
	/* Method that updates an employee's details to database*/
	@PutMapping
	public void update(@Valid @RequestBody EmployeeDetails empDetails) {

		this.employeeRepository.save(empDetails);

	}

	/* Method that deletes employee details based on id*/
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.employeeRepository.deleteById(id);
	

	}

}
