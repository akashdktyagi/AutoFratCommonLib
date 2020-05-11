package design.pattern.behavioural.strategy.phone.wrong;

public abstract class PhoneCameraApp {

	public abstract void edit();
	
	public void take() {
		System.out.println("Take pictures behaviour");
	}
	
	public void save() {
		System.out.println("Save pictures behaviour");
	}
	
	public void share() {
		System.out.println("Share pictures on phone");
	}
}
