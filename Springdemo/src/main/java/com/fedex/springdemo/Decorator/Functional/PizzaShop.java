package com.fedex.springdemo.Decorator.Functional;

import java.util.function.Function;

public class PizzaShop {

	Function<Pizza, Pizza> decoration;

	public PizzaShop(Function<Pizza, Pizza> decoration) {
		this.decoration = decoration;
	}

	public Pizza use(Pizza basePizza) {
		return decoration.apply(basePizza);
	}

}
