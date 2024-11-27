package com.nimap.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.Product;
import com.nimap.repository.ProductRepository;
import com.nimap.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		Product prod = new Product();
		prod.setProductName(product.getProductName());
		prod.setCategory(product.getCategory());
		return productRepository.save(prod);
	}

	@Override
	public List<Product> getAllProducts() {		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product, Integer id) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
		{
		
			Product prod = optionalProduct.get();
			prod.setProductName(product.getProductName());
			prod.setCategory(product.getCategory());
			return productRepository.save(prod);
		}
		else
			throw new IOException("Product Not Found");
	
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}

}
