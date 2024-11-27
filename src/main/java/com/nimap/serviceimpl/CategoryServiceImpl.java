package com.nimap.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.Category;
import com.nimap.repository.CategoryRepository;
import com.nimap.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		Category cate = new Category();
		cate.setCategoryName(category.getCategoryName());
		cate.setProducts(category.getProducts());
		return categoryRepository.save(cate);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Category category, Integer id) throws IOException{
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent())
		{
			Category cate =optionalCategory.get();
			cate.setCategoryName(category.getCategoryName());
			cate.setProducts(category.getProducts());
			return categoryRepository.save(cate);
		}
		else
			throw new IOException("Category not found");
	}

	@Override
	public void deleteCategory(int id) {
		
		categoryRepository.deleteById(id);
		
	}
	
	

}
