package com.alex.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alex.springdata.product.entities.Product;
import com.alex.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("A piece of shit iPhone");
		product.setPrice(1000.50);

		repository.save(product);
	}

	@Test
	public void testRead() {

		Optional<Product> findOne = repository.findById(1);
		assertTrue(findOne.isPresent());
		if (findOne.isPresent()) {
			Product product = findOne.get();
			assertEquals("Iphone", product.getName());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
		} else {
			fail("item with id 1 not present in database");
		}

	}

	@Test
	public void testUpdate() {

		Optional<Product> findOne = repository.findById(1);
		if (findOne.isPresent()) {
			Product product = findOne.get();
			product.setPrice(1200d);
			repository.save(product);
		} else {
			fail("item with id 1 not present in database");
		}

	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting a product");
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records=======================>" + repository.count());
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("TV", "From Samsung");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("Apple");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByIdsIn() {
		List<Product> products = repository.findByIdIn(Arrays.asList(1,2,3));
		products.forEach(p -> System.out.println(p.getName()));
	}

}
