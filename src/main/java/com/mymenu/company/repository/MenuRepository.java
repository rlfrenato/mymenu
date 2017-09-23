package com.mymenu.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymenu.company.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
