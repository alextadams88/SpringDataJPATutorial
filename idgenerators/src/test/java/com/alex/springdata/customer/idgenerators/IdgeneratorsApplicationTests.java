package com.alex.springdata.customer.idgenerators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alex.springdata.customer.idgenerators.entities.Employee;
import com.alex.springdata.customer.idgenerators.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdgeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository er;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateEmployee() {
		
		Employee employee = new Employee();
		employee.setName("John");
		
		er.save(employee);
	}

}

