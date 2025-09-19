package com.fedex.springdemo.Decorator;

public class BasePizza implements Pizza{
	@Override
	public String bake() {
		return "Base Pizza";
	}

}
