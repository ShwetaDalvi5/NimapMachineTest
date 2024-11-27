package com.nimap.service;

import java.io.IOException;
import java.util.List;

import com.nimap.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Integer id);
	
	public Product updateProduct(Product product, Integer id) throws IOException;
	
	public void deleteProduct(int id);
}
