package employee.data;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	 @Autowired
	  private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 
	@Override
	  public void run(String... args) throws Exception {
	    repository.deleteAll();
	    
	    /*Pre-populating the database with some values */
	    repository.insert(new EmployeeDetails("Alice", "Smith","Project Engineer",20000,"alice@tc.com",new Department(101,"Digital"),new Address("Pune","Maharashtra","India",571433)));
	    repository.insert(new EmployeeDetails("Bob", "Smith","Mangager",50000,"bob@tc.com",new Department(101,"Digital"),new Address("Pune","Maharashtra","India",571433)));

	  }
}
