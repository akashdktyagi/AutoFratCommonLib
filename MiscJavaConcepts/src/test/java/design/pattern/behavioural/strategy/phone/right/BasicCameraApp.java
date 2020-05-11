package design.pattern.behavioural.strategy.phone.right;

import design.pattern.behavioural.strategy.phone.right.algorithm.SharePhotoOnPhone;

public class BasicCameraApp extends PhoneCameraApp {

	public BasicCameraApp() {
		setPhotoSharable(new SharePhotoOnPhone());
	}
	
	@Override
	public void edit() {
		System.out.println("I can Edit Basic Camera App");
	}

}
