package com.br.api.manutencao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.manutencao.dto.ProductDto;
import com.br.api.manutencao.mapper.ProductMapper;
import com.br.api.manutencao.models.ProductModel;
import com.br.api.manutencao.services.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts()); 
	}
	
	@GetMapping("/filter")
	public ResponseEntity<List<ProductModel>> getFilteredProducts(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Long quantity,
			@RequestParam(required = false) Float moneyValue,
			@RequestParam(required = false) Long defective
			) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getFilteredProducts(name, quantity, moneyValue, defective)); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) {
		Optional<ProductModel> productModelOptional = productService.findById(id);
		
		if (!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<ProductModel> createProduct(@RequestBody @Validated ProductDto productDto) {
		ProductModel productModel = ProductMapper.DtoToProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productModel));  
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") int id, @RequestBody @Validated ProductDto productDto) {
		Optional<ProductModel> productModelOptional = productService.findById(id);
		
		if (!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
		
		ProductModel productModel = ProductMapper.DtoToProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(productModel));  
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") int id) {
		Optional<ProductModel> productModelOptional = productService.findById(id);

		productService.deleteProduct(productModelOptional.get());
		return ResponseEntity.noContent().build();
	}
}
