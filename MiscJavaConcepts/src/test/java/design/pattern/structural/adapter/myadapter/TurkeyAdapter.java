package design.pattern.structural.adapter.myadapter;

import design.pattern.structural.adapter.client.IDuck;
import design.pattern.structural.adapter.yoursystem.ITurkey;

public class TurkeyAdapter implements IDuck{

	ITurkey turkey;
	
	public TurkeyAdapter(ITurkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
