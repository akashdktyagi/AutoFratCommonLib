package design.pattern.factory.penexample;

public class PenFactory {

	public static PenManager getInstance(String color) {
		PenManager penManager=null;
		if(color.equalsIgnoreCase("pink")) {
			penManager = new PinkPen();
		}else if(color.equalsIgnoreCase("blue")) {
			penManager = new BluePen();
		}else {
			penManager = new RedPen();	
		}
		return penManager;
	}
}
