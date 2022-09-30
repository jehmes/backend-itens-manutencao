package com.br.api.manutencao.dto;

import java.io.Serializable;

import javax.persistence.Entity;

import com.br.api.manutencao.models.ProductModel;


public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private int quantity;
	
	private int defective;
	
	private float moneyValue;
	
	private String imageName;
	
	private String binaryImage;
	
	public ProductDto() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
