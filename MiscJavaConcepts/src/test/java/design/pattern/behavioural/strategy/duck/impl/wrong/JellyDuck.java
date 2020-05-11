package design.pattern.behavioural.strategy.duck.impl.wrong;

public class JellyDuck extends Duck{

	public void appearance() {
		System.out.println("I am a Jelly Duck.");
	}

	@Override
	public void fly() {
		System.out.println("But I can't fly because I am Jelly Duck.");
	}

	@Override
	public void speak() {
		System.out.println("But I can't speak because I am Jelly Duck.");
	}

	@Override
	public void swim() {
		System.out.println("But I can't swim because I am Jelly Duck.");
	}

}
