package com.br.api.manutencao.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.br.api.manutencao.models.ProductModel;

@Repository
public class ProductRepositoryCustom {
	
	private final EntityManager em;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductRepositoryCustom(EntityManager em) {
		this.em = em;
	}

	public List<ProductModel> findByFilter(String name, Long quantity, Float moneyValue, Long defective) {

		String q = "";
		
		q = "select * from product ";
		if (name != null || moneyValue != null || defective != null || quantity != null) {
			q += "where ";
		}
		if (name != null) {
			name = name.toUpperCase();
			q += "UPPER(name) LIKE '%" + name + "%' and ";
		}

		if (moneyValue != null) {
			q += "money_value = " + moneyValue + " and ";
		}

		if (defective != null) {
			q += "defective = " + defective + " and ";
		}
		
		if (quantity != null) {
			q += "quantity > " + quantity + " and ";
		}

		q = q.substring(0, q.length() - 5);
		
		
		return jdbcTemplate.query(q, 
				(rs, rowNum) -> new ProductModel(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getInt("quantity"), 
						rs.getInt("defective"),
						rs.getFloat("money_value"),
						rs.getString("image_name"),
						rs.getString("binary_image")
						) );
		
	}
}
