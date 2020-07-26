package basics.finalAndStatic.staticexample;

public class StaticClassExampleCaller {

	public void method3() {
		
		//Static members can be called directly
		StaticClassExample.method1();
		StaticClassExample.b = 100;
		
		//Non static needs obj
		StaticClassExample obj = new StaticClassExample();
		obj.method2();
		
		
	}
	

}
