package com.br.api.manutencao.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.api.manutencao.models.ProductModel;

public interface IProductRepository extends CrudRepository<ProductModel, Integer>{

}
