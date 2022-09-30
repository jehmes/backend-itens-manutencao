package com.br.api.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.manutencao.dto.ProductDto;
import com.br.api.manutencao.mapper.ProductMapper;
import com.br.api.manutencao.models.ProductModel;
import com.br.api.manutencao.repositories.IProductRepository;
import com.br.api.manutencao.repositories.ProductRepositoryCustom;

@Service
public class ProductService {
	
	@Autowired
	IProductRepository iProductRepository;
	
	@Autowired
	ProductRepositoryCustom productRepositoryCustom;
	
	public List<ProductModel> getAllProducts() {
		return (List<ProductModel>) iProductRepository.findAll();
	}
	
	public List<ProductModel> getFilteredProducts(String name, Long quantity, Float moneyValue, Long defective) {
		return productRepositoryCustom.findByFilter(name, quantity, moneyValue, defective);
	}
	
	public Optional<ProductModel> findById(int id) {
		return iProductRepository.findById(id);
	}
	
	public ProductModel createProduct(ProductModel productModel) {
		return iProductRepository.save(productModel);
	}
	
	public ProductModel updateProduct(ProductModel productModel) {
		return iProductRepository.save(productModel);
	}
	
	public void deleteProduct(ProductModel productModel) {
		iProductRepository.delete(productModel);
	}
}
