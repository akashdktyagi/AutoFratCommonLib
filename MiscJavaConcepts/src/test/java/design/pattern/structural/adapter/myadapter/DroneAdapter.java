package design.pattern.structural.adapter.myadapter;

import design.pattern.structural.adapter.client.IDuck;
import design.pattern.structural.adapter.yourothersystem.IDrone;

public class DroneAdapter implements IDuck {
	
	IDrone drone;

	public DroneAdapter(IDrone drone) {
		this.drone=drone;
	}
	
	@Override
	public void quack() {
		drone.beep();
	}

	@Override
	public void fly() {
		drone.spin_rotors();
		drone.take_off();	
	}

}
