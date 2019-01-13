package com.alex.springdata.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alex.springdata.customer.entities.Customer;
import com.alex.springdata.customer.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerdataApplicationTests {
	
	@Autowired
	CustomerRepository repository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setName("Alex");
		customer.setEmail("alex@whitehouse.gov");
		
		repository.save(customer);
	}
	
	@Test
	public void testRead() {
		Customer customer = repository.findById(1).get();
		assertNotNull(customer);
		assertEquals(customer.getName(), "Alex");
	}
	
	@Test
	public void testUpdate() {
		Customer customer = repository.findById(1).get();
		customer.setName("Balex");
		repository.save(customer);
	}
	
	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			repository.deleteById(1);
		}
	}

}

