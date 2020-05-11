package design.pattern.behavioural.strategy.phone.right;

import design.pattern.behavioural.strategy.phone.right.algorithm.*;

public class CameraPlusPlus extends PhoneCameraApp {

	public CameraPlusPlus() {
		setPhotoSharable(new SharePhotoOnSocialNetwork());
	}
	
	@Override
	public void edit() {
		System.out.println("I can Edit Camera Plus Plus Camera App");
	}

}
