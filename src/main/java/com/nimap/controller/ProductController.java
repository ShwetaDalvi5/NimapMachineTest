package com.nimap.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Product;
import com.nimap.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);	
	}
	
	@GetMapping("/products")
	public List<Product> products(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getOneProduct(@PathVariable("id") int id)
	{
		return productService.getProductById(id);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProductById(@RequestBody Product product, @PathVariable("id") int id) throws IOException
	{
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") int id)
	{
		productService.deleteProduct(id);
	}
}
