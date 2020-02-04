package employee.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class EmployeeDetails {

	@Id
	private String empId;
	@NotNull(message="name can't be null")
	@Size(min=2,message="Name should atleast be 2 charectors")
	private String firstName;
	private String lastName;
	private String designation;
	private double salary;
	@Email(message="Please provide a valid email id")
	private String email;
	private Department dept;
	private Address addr;

	public EmployeeDetails( String firstName, String lastName, String designation, double salary,
			String email, Department dept, Address addr) {
		super();
		//this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.email = email;
		this.dept = dept;
		this.addr = addr;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee[id=%s, firstName='%s', lastName='%s',Designation='%s',salary='%d,email='%s',dept='%',address='%']",
				empId, firstName, lastName, designation, salary, email, dept, addr);
	}

}
