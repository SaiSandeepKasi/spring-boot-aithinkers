package com.springboot.jpacrud;

import com.springboot.jpacrud.DAO.EmployeeDAO;
import com.springboot.jpacrud.Entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemolearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolearningsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
		return runner ->{
			//createEmployee(employeeDAO);
			//createmultipleemployees(employeeDAO);
			//reademployee(employeeDAO);
			//queryForEmployess(employeeDAO);
			//queryforemployeeemail(employeeDAO);
			//updateage(employeeDAO);
			//deleteemployeeById(employeeDAO);
			//deleteAllemp(employeeDAO);
		};
	}

	private void deleteAllemp(EmployeeDAO employeeDAO) {
		System.out.println("Deleting all allemployees Records");
		Integer DeletedCount = employeeDAO.deleteAll();
		System.out.println("Deleted Records " + DeletedCount + " Count");
	}

	private void deleteemployeeById(EmployeeDAO employeeDAO) {
		int id=5;
		System.out.println("Deleting employee with id "+id);
		employeeDAO.delete(id);
	}

	private void updateage(EmployeeDAO employeeDAO) {
		//get employee based on Id
		int employeeId=2;
		Employee employee = employeeDAO.findById(employeeId);
		//change the age
		employee.setAge(24);
		//update the Employee
		employeeDAO.update(employee);
		//print
		System.out.println("Updated age :"+employee);
	}

	private void queryforemployeeemail(EmployeeDAO employeeDAO) {
		List<Employee> employees = employeeDAO.findByEmailContaining("%@gmail.com");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private void queryForEmployess(EmployeeDAO employeeDAO) {
		//get list of students
		List<Employee> employees = employeeDAO.findAll();
		//display
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

	private void reademployee(EmployeeDAO employeeDAO) {
		//add employee object or create employee
		Employee employeeread = new Employee("abid","syed","abidsyed@gmail.com",23,"Male");
		//save the employee to sql
		employeeDAO.save(employeeread);
		//print the id and details and saved
		System.out.println("employee saved");
		int id = employeeread.getId();
		System.out.println("Id of the employee"+ employeeread.getId());

		//retrving the employee based on id: primary key
		Employee employee = employeeDAO.findById(id);
		System.out.println("employee found");
		//display
		System.out.println("Id of the employee"+ employee);


	}

	private void createmultipleemployees(EmployeeDAO employeeDAO) {
		System.out.println("Creating Mulitiple employees...");
		Employee employee1 = new Employee("jeevan","vinjam","jeevankrishna02@gmail.com",22,"male");
		Employee employee2 = new Employee("dhruthi","yadav","dhruthiyadav@gmail.com",22,"Female");
		Employee employee3 = new Employee("eswar","akkala","eswarakkala23@gmail.com",23,"male");



		System.out.println("Saving employee...");
		employeeDAO.save(employee1);
		employeeDAO.save(employee2);
		employeeDAO.save(employee3);

		System.out.println("Employee saved.");
		System.out.println("Employee id: " + employee1.getId());
		System.out.println("Employee id: " + employee2.getId());
		System.out.println("Employee id: " + employee3.getId());

	}

	private void createEmployee(EmployeeDAO employeeDAO) {
		System.out.println("Creating employee...");
		Employee employee = new Employee("sandeep","kasi","saisandeep802@gmail.com",22,"male");

		System.out.println("Saving employee...");
		employeeDAO.save(employee);

		System.out.println("Employee saved.");
		System.out.println("Employee id: " + employee.getId());


	}

}
