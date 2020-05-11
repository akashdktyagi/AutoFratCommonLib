package design.pattern.behavioural.strategy.phone.right;

public class CameraAppRunner {

	public static void main(String[] args) {

		PhoneCameraApp app_basic = new BasicCameraApp();
		PhoneCameraApp app_plus = new CameraPlusApp();
		PhoneCameraApp app_plus_plus = new CameraPlusPlus();
		
		app_basic.save();
		app_basic.take();
		app_basic.edit();
		app_basic.share();

		app_plus.save();
		app_plus.take();
		app_plus.edit();
		app_plus.share();
		
		app_plus_plus.save();
		app_plus_plus.take();
		app_plus_plus.edit();
		app_plus_plus.share();
		
		
	}

}
