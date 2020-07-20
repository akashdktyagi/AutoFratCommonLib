package basics.methods;

import java.util.ArrayList;

public class MyFirstClass {

	//attributes/properties
	static int a;
	String str;
	

	public static void main(String[] args) {
		temp();
		temp1();
	}
	
	public static void temp() {
		a= 9;
		int c=8; // scope of c is limited to same method and not outside
	}
	
	public static void temp1() {
		System.out.print("print the value" + a);
		//System.out.print("print the value of c" + c); // cant access c here
	}
	
}
