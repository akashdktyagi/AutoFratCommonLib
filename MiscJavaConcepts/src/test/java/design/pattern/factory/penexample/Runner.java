package design.pattern.factory.penexample;

public class Runner {

	public static void main(String[] args) {

		PenManager penManager = PenFactory.getInstance("blue");
		penManager.drawLine();
		
		PenManager penManager1 = PenFactory.getInstance("pink");
		penManager1.drawLine();
		
		PenManager penManager2 = PenFactory.getInstance("red");
		penManager2.drawLine();
	}
}
