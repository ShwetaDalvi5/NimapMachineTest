package com.nimap.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Category;
import com.nimap.repository.CategoryRepository;
import com.nimap.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired 
	CategoryService categoryService;
	
	@PostMapping("/category")
	public Category createCategory(@RequestBody Category category)
	{
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getCategories()
	{
		return categoryService.getAllCategories();
	}
	
	@GetMapping("category/{id}")
	public Category getOneCategory(@PathVariable("id") int id)
	{
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/category/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable("id") int id) throws IOException
	{
		 return categoryService.updateCategory(category, id);	
	}
	
	@DeleteMapping("/category/{id}")
	public void deleteCategoryById(@PathVariable("id") int id)
	{
		categoryService.deleteCategory(id);
	}
}
