package com.mymenu.company.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.mymenu.common.BusinessObject;

@Entity
public class MenuCategory extends BusinessObject {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Menu menu; 
	
	@NotNull
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<MenuItem> menuItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuItem> getMenuItems() {
		
		if (menuItems == null) {
			menuItems = new ArrayList<>();
		}
		
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
