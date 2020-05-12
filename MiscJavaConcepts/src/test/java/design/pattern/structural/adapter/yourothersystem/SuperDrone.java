package design.pattern.structural.adapter.yourothersystem;

public class SuperDrone implements IDrone {

	@Override
	public void beep() {
		System.out.println("Beep Beep Beep");
		
	}

	@Override
	public void spin_rotors() {
		System.out.println("Rotors are spinning.");
		
	}

	@Override
	public void take_off() {
		System.out.println("Taking Off");
		
	}

}
