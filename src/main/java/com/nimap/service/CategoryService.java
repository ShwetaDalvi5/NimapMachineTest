package com.nimap.service;

import java.io.IOException;
import java.util.List;

import com.nimap.model.Category;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(Integer id);
	
	public Category updateCategory(Category category, Integer id) throws IOException;
	
	public void deleteCategory(int id);

}
