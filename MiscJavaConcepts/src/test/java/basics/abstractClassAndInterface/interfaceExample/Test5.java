package basics.abstractClassAndInterface.interfaceExample;

interface Printable1{  
	void print();  
}  
interface Showable{  
	void show();  
}  
class Test5 implements Printable1,Showable{  
	public void print(){System.out.println("Hello");}  
	public void show(){System.out.println("Welcome");}  

	public static void main(String args[]){  
		Test5 obj = new Test5();  
		obj.print();  
		obj.show();  
	}  
} 


