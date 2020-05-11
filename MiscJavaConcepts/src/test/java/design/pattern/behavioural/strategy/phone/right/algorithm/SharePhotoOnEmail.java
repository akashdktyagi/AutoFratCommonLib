package design.pattern.behavioural.strategy.phone.right.algorithm;

public class SharePhotoOnEmail implements PhotoSharable {

	@Override
	public void share() {
		System.out.println("I can share on Email");
	}

}
