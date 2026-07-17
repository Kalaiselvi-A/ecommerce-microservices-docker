package com.ecommerce.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.dto.ProductRequestDTO;
import com.ecommerce.productservice.dto.ProductResponseDTO;
import com.ecommerce.productservice.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(
			@Valid @RequestBody ProductRequestDTO request) {
		return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> updateProduct(
			@PathVariable Long id, 
			@Valid @RequestBody ProductRequestDTO request) {
		return ResponseEntity.ok(productService.updateProduct(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
