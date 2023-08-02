package com.fedex.springdemo.Decorator.Functional;

public class DecoratorPattern {
	
	public static void main(String[] args) {
		
		Pizza myOrder = new PizzaShop(pizza -> pizza.addJalepeno())
				.use(
					new PizzaShop(pizza -> pizza.addCheese())
						.use(
							new Pizza()
							)
					);
		
		System.out.println(myOrder);
		
	}

}
