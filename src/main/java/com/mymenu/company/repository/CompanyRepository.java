package com.mymenu.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.mymenu.company.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
