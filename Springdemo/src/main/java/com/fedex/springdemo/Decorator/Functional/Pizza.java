package com.fedex.springdemo.Decorator.Functional;

public class Pizza {

	private String pizza;

	public Pizza() {

		this.pizza = "Base Pizza";
	}

	private Pizza(String type) {
		this.pizza = type;
	}

	public Pizza addJalepeno() {
		System.out.println("Adding Jalepeno to the burger");
		return new Pizza(this.pizza += " Jalepeno");
	}

	public Pizza addCheese() {
		System.out.println("Adding cheese to the burger");
		return new Pizza(this.pizza += " Cheese");
	}

	public String toString() {
		return String.format("%s", pizza);
	}

}