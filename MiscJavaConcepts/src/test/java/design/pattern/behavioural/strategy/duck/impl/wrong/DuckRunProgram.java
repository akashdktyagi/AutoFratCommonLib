package design.pattern.behavioural.strategy.duck.impl.wrong;

public class DuckRunProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duck duck = new IndianDuck();
		//Duck duck = new JellyDuck();
		duck.appearance();
		duck.speak();
		duck.fly();
		duck.swim();
		

	}

}
