package basics.abstractClassAndInterface.interfaceExample;


//what: Interfaces and Abstract both solves the same problem. Blueprint==> Uniformity
// Planning

//How:
interface printable{  
	void print();  //Abstract method
}  

class Test1 implements printable{  
	public void print(){System.out.println("Hello");}  

	public static void main(String args[]){  
		Test1 obj = new Test1();  
		obj.print();  
	}  
} 

