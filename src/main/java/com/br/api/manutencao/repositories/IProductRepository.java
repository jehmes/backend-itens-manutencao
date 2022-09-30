package com.br.api.manutencao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.api.manutencao.models.ProductModel;

@Repository
public interface IProductRepository extends CrudRepository<ProductModel, Integer>{
	
//	public static List<ProductModel> findByFilter(String name, int quantity, float moneyValue, int defective) {
//		return null;
//	}

}
