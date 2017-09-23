package com.mymenu.company.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mymenu.company.model.Menu;
import com.mymenu.company.model.MenuCategory;
import com.mymenu.company.model.MenuItem;
import com.mymenu.company.repository.MenuRepository;

@Component
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;	
	
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public Menu getMenu(Long menuId) {
		return menuRepository.findOne(menuId);
	}
	
	public void saveCategory(Long menuId, MenuCategory menuCategory) {
		
		Menu menu = getMenu(menuId);
		menu.getMenuCategories().add(menuCategory);
		this.saveMenu(menu);
	}
	
	public void removeCategory(Long menuId, Long categoryId) {
		
		Menu menu = getMenu(menuId);
		List<MenuCategory> menuCategories = menu.getMenuCategories();
		
		Iterator<MenuCategory> menuCategoriesIterator = menuCategories.iterator();
		
		while (menuCategoriesIterator.hasNext()) {
			MenuCategory menuCategory = menuCategoriesIterator.next();
			if (menuCategory.getId().equals(categoryId)) {
				menuCategoriesIterator.remove();
			}
		}
		
		this.saveMenu(menu);
		
	}
	
	public void saveMenuItem(Long menuId, Long menuCategoryId, MenuItem menuItem) {
		
		Menu menu = getMenu(menuId);
		menu.getMenuCategory(menuCategoryId).getMenuItems().add(menuItem);
		this.saveMenu(menu);
	}
	
	public void removeMenuItem(Long menuId, Long menuItemId) {
		
		Menu menu = getMenu(menuId);
		List<MenuItem> menuItems = menu.getAllMenuItems();
		
		Iterator<MenuItem> menuItemsIterator = menuItems.iterator();
		
		while (menuItemsIterator.hasNext()) {
			MenuItem menuItem = menuItemsIterator.next();
			if (menuItem.getId().equals(menuItemId)) {
				menuItemsIterator.remove();
				
				break;
			}
		}
		
		this.saveMenu(menu);
	}
	
}
