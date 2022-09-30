package com.br.api.manutencao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.br.api.manutencao.dto.ProductDto;


@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true, name = "id")
	private int id;
	
	@Column(nullable = false, name = "name")
	private String name;
	
	@Column(nullable = false, name = "quantity")
	private int quantity;
	
	@Column(nullable = false, name = "defective")
	private int defective;
	
	@Column(nullable = false, name = "moneyValue")
	private float moneyValue;
	
	@Column(nullable = false, name = "image_name")
	private String imageName;
	
	@Lob
	@Column(nullable = false, name = "binary_image")
	private String binaryImage;

	
	public ProductModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDefective() {
		return defective;
	}

	public void setDefective(int defective) {
		this.defective = defective;
	}

	public float getMoneyValue() {
		return moneyValue;
	}

	public void setMoneyValue(float moneyValue) {
		this.moneyValue = moneyValue;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBinaryImage() {
		return binaryImage;
	}

	public void setBinaryImage(String binaryImage) {
		this.binaryImage = binaryImage;
	}
	
}
