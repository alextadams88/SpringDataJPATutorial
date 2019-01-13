package com.alex.springdata.customer.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.alex.springdata.customer.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
