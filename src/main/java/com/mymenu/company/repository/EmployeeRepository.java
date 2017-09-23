package com.mymenu.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.mymenu.company.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
