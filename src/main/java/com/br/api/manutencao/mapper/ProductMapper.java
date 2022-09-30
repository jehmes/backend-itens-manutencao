package com.br.api.manutencao.mapper;

import com.br.api.manutencao.dto.ProductDto;
import com.br.api.manutencao.models.ProductModel;

public class ProductMapper {

	public static ProductDto ProductToDto(ProductModel productModel) {
		ProductDto productDto = new ProductDto();
		productDto.setId(productModel.getId());
		productDto.setName(productModel.getName());
		productDto.setQuantity(productModel.getQuantity());
		productDto.setDefective(productModel.getDefective());
		productDto.setMoneyValue(productModel.getMoneyValue());
		productDto.setImageName(productModel.getImageName());
		productDto.setBinaryImage(productModel.getBinaryImage());
		return productDto;
	}
	
	public static ProductModel DtoToProduct(ProductDto productDto) {
		ProductModel productModel = new ProductModel();
		productModel.setId(productDto.getId());
		productModel.setName(productDto.getName());
		productModel.setQuantity(productDto.getQuantity());
		productModel.setDefective(productDto.getDefective());
		productModel.setMoneyValue(productDto.getMoneyValue());
		productModel.setImageName(productDto.getImageName());
		productModel.setBinaryImage(productDto.getBinaryImage());
		return productModel;
	}
}
