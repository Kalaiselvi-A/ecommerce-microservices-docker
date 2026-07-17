package com.ecommerce.productservice.service;

import java.util.List;

import com.ecommerce.productservice.dto.ProductRequestDTO;
import com.ecommerce.productservice.dto.ProductResponseDTO;

public interface ProductService {
	
	ProductResponseDTO createProduct(ProductRequestDTO request);
	
	ProductResponseDTO getProductById(Long id);
	
	List<ProductResponseDTO> getAllProducts();
	
	ProductResponseDTO updateProduct(Long id, ProductRequestDTO request);
	
	void deleteProduct(Long id);

}
