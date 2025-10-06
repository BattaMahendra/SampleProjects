package com.fedex.springdemo.Decorator;

public class CheeseBurstDecorator extends PizzaDecorator{
    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }
    public String bake() {
        return pizza.bake() + addCheese();
    }

    public String addCheese(){
        return " Cheese";
    }

}
