package basics.abstractClassAndInterface.interfaceExample;

interface Drawable2{  
	void draw();  
	
	default void msg(){
		System.out.println("default method");
	}  
}  

class Rectangle2 implements Drawable2{  
	public void draw(){
		System.out.println("drawing rectangle");
    }  
}
  
public class Test6{  
	public static void main(String[] args){  
		Drawable2 d=new Rectangle2();  
		d.draw();  
		d.msg();  
	}
	
} 

