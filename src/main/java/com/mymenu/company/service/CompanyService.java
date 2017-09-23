package com.mymenu.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mymenu.company.model.Company;
import com.mymenu.company.model.Company.CompanyStatus;
import com.mymenu.company.model.Employee;
import com.mymenu.company.model.Employee.EmployeeStatus;
import com.mymenu.company.repository.CompanyRepository;
import com.mymenu.company.repository.EmployeeRepository;

@Component
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveEmployee(Long companyId, Employee newEmployee) {
		
		Company company = companyRepository.findOne(companyId);
		newEmployee.setStatus(EmployeeStatus.INACTIVE);
		company.getEmployees().add(newEmployee);	
		
		companyRepository.save(company);
	}
	
	public void activateCompany(Long companyId) {
		
		Company company = companyRepository.findOne(companyId);
		company.setStatus(CompanyStatus.ACTIVE);	
		
		companyRepository.save(company);
	}
	
	public void deactivateCompany(Long companyId) {
		
		Company company = companyRepository.findOne(companyId);
		company.setStatus(CompanyStatus.INACTIVE);
		
		companyRepository.save(company);
	}
	
	public void activateEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findOne(employeeId);
		employee.setStatus(EmployeeStatus.ACTIVE);		
		
		employeeRepository.save(employee);
	}
	
	public void deactivateEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findOne(employeeId);
		employee.setStatus(EmployeeStatus.INACTIVE);		
		
		employeeRepository.save(employee);
	}

}
