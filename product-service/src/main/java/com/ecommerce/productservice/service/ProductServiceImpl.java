package com.ecommerce.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.productservice.dto.ProductRequestDTO;
import com.ecommerce.productservice.dto.ProductResponseDTO;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponseDTO createProduct(ProductRequestDTO request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setStockQuantity(request.getStockQuantity());
		product.setCategory(request.getCategory());
		
		return mapToResponse(productRepository.save(product));
	}

	@Override
	public ProductResponseDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
		
		return mapToResponse(product);
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		return productRepository.findAll()
				.stream()
				.map(this::mapToResponse)
				.toList();
	}

	@Override
	public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
		
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setStockQuantity(request.getStockQuantity());
		product.setCategory(request.getCategory());
		
		return mapToResponse(productRepository.save(product));
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
		
		product.setActive(false);
		productRepository.save(product);
	}

	
	private ProductResponseDTO mapToResponse(Product product) {
		ProductResponseDTO dto = new ProductResponseDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setStockQuantity(product.getStockQuantity());
		dto.setCategory(product.getCategory());
		dto.setActive(product.getActive());
		dto.setCreatedAt(product.getCreatedAt());
		
		return dto;
	}
}
