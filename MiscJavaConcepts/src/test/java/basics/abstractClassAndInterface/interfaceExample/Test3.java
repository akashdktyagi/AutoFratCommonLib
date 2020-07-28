package basics.abstractClassAndInterface.interfaceExample;

//Interface declaration: by first user  
interface Drawable{  
	void draw();  
}  

//Implementation: by second user  
class Rectangle implements Drawable{  
	public void draw(){System.out.println("drawing rectangle");}  
}  

class Circle implements Drawable{  
	public void draw(){System.out.println("drawing circle");}  
}  

//Using interface: by third user  
class Test3{  
	public static void main(String args[]){  
		
		Drawable d = getDrawable("rectangle");
		d.draw();  
	}

	public static Drawable getDrawable(String type) {
		Drawable d = null;
		if (type.equalsIgnoreCase("circle")) {
			d=new Circle();
		}else {
			d = new Rectangle();
		}
		
		return d;
		
	}
}