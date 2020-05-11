package design.pattern.behavioural.strategy.phone.right;

import design.pattern.behavioural.strategy.phone.right.algorithm.PhotoSharable;

public abstract class PhoneCameraApp {

	PhotoSharable photoShareable;
	
	public void setPhotoSharable(PhotoSharable ps) {
		photoShareable = ps;
	}
	
	public abstract void edit();
	
	public void take() {
		System.out.println("Take pictures behaviour");
	}
	
	public void save() {
		System.out.println("Save pictures behaviour");
	}
	
	public void share() {
		photoShareable.share();
	}
	
}
