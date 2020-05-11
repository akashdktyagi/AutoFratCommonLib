package design.pattern.behavioural.strategy.phone.right.algorithm;

public class SharePhotoOnSocialNetwork implements PhotoSharable {

	@Override
	public void share() {
		System.out.println("I can share on Social Network and phone and email");
	}

}
