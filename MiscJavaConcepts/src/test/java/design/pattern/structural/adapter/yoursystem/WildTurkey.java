package design.pattern.structural.adapter.yoursystem;

public class WildTurkey implements ITurkey {

	@Override
	public void gobble() {
		System.out.println("I can Gobble");
		
	}

	@Override
	public void fly() {
		System.out.println("I am a Turkey and I can Fly as well but need hard push");
		
	}

}
