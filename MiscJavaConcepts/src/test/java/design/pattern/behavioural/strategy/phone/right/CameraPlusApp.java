package design.pattern.behavioural.strategy.phone.right;

import design.pattern.behavioural.strategy.phone.right.algorithm.*;

public class CameraPlusApp extends PhoneCameraApp {

	public CameraPlusApp() {
		setPhotoSharable(new SharePhotoOnEmail());
	}
	
	@Override
	public void edit() {
		System.out.println("I can Edit Camera Plus App");
	}
}
