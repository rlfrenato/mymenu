package com.mymenu.company.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mymenu.common.BusinessObject;

@Entity
public class Menu extends BusinessObject {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany
	private List<Company> companies;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<MenuCategory> menuCategories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<MenuCategory> getMenuCategories() {
		
		if (menuCategories == null) {
			menuCategories = new ArrayList<>();
		}
		
		return menuCategories;
	}

	public void setMenuCategories(List<MenuCategory> menuCategories) {
		this.menuCategories = menuCategories;
	}

	@JsonIgnoreProperties
	public MenuCategory getMenuCategory(Long menuCategoryId) {
		
		if (!getMenuCategories().isEmpty()) {
			for (MenuCategory menuCategory : getMenuCategories()) {
				if (menuCategory.getId().equals(menuCategoryId)) {
					return menuCategory;
				}
			}
		}
		
		return null;
	}
	
	@JsonIgnore
	public List<MenuItem> getAllMenuItems() {
		
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		if (!getMenuCategories().isEmpty()) {
			for (MenuCategory menuCategory : getMenuCategories()) {
				menuItems.addAll(menuCategory.getMenuItems());
			} 			
		}
		
		return menuItems;
	}
}
