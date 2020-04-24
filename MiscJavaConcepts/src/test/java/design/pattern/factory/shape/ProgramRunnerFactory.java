package design.pattern.factory.shape;

public class ProgramRunnerFactory {

	public static void main(String[] args) {
		
		Shape s1 = ShapeFactory.getShape("circle");
		s1.draw();
		
		Shape s2 = ShapeFactory.getShape("rectangle");
		s2.draw();
		
		Shape s3 = ShapeFactory.getShape("triangle");
		s3.draw();
	}
}
