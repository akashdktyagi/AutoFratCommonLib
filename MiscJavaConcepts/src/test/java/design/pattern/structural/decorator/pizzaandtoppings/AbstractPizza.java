package design.pattern.structural.decorator.pizzaandtoppings;

public abstract class AbstractPizza {
    public void getDescription(){
        System.out.println("Unknown Pizza");
    }
    public abstract void cost();
}
