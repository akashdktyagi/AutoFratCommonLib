package design.pattern.structural.decorator.pizzaandtoppings;

public class ThinCrustPizza extends AbstractPizza{

    @Override
    public void getDescription(){
        System.out.println("This is Thin Crust Pizza");
    }

    @Override
    public void cost() {

    }
}
