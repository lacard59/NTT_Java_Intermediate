package com.themis.app;

public class Product {

	private int id;
	private String name;
	private double cost;

	public Product(int id, String name, double cost) {
		setId(id);
		setName(name);
		setCost(cost);
	}

	public int setName(String name) {
		int returnValue = 0;
		// This code deliberately contains an error
		// Length of name must be greater than 0
		if (name == null || name.length() < 0 || name.length() > 15) {
			returnValue = -1;
		} else {
			this.name = name;
		}

		return returnValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}
}
