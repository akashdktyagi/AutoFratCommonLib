package design.pattern.structural.adapter.client;

public class MallardDuck implements IDuck {

	@Override
	public void quack() {
		System.out.println("I can Quack.");	
	}

	@Override
	public void fly() {
		System.out.println("I can Fly.");
	}
}
