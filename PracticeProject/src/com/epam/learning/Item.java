package com.epam.learning;

import java.math.BigDecimal;

public class Item {
	private String fruitName;
	private int weight;
	private BigDecimal size;
	public Item() {
		
	}
	public Item(String fruitName, int weight, BigDecimal size) {
		super();
		this.fruitName = fruitName;
		this.weight = weight;
		this.size = size;
	}
	public String getFruitName() {
		return fruitName;
	}
	@Override
	public String toString() {
		return "Item [fruitName=" + fruitName + ", weight=" + weight + ", size=" + size + "]";
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public BigDecimal getSize() {
		return size;
	}
	public void setSize(BigDecimal size) {
		this.size = size;
	}
	
}
