package design.pattern.structural.adapter.client;

import design.pattern.structural.adapter.myadapter.*;
import design.pattern.structural.adapter.yourothersystem.*;
import design.pattern.structural.adapter.yoursystem.*;

public class DuckSimulator {

	public static void main(String[] args) {
		//testDuck is a Client System which u can't change
		IDuck duck = new MallardDuck();
		testDuck(duck);
		
		//Created a turkey object which is your system which u wish to integrate
		ITurkey turkey = new WildTurkey();
		
		//Instance of your adapter which is of the type of client's super type
		//This actually has converted methods of duck to methods call of turkey.
		IDuck turkeyAdapter = new TurkeyAdapter(turkey);
		testDuck(turkeyAdapter);	
		
		//Drone adapter example
		IDrone drone = new SuperDrone();
		IDuck droneAdapter = new DroneAdapter(drone);
		testDuck(droneAdapter);
	}
	
	static void testDuck(IDuck duck) {
		duck.quack();
		duck.fly();
	}

}
/*OUTPUT:

I can Quack.
I can Fly.
I can Gobble
I am a Turkey and I can Fly as well but need hard push
Beep Beep Beep
Rotors are spinning.
Taking Off


*/
