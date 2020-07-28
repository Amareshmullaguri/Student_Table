/*
public class Cclass extends Bclass {
	int g=60;
	int h=70;
	public static void main(String[] args) {
		
		//SINGLE INHERITANCE
//		// TODO Auto-generated method stub
//		Cclass y= new Cclass();
//		System.out.println(y.a);
//		System.out.println(y.d);
//		int k=y.a+y.age+y.h;
//		System.out.println(k);
//		
	}

*/


//public class Cclass extends Aclass {--heirarchial inheriatnce
//NOW WE CAN ACCESS THE ACLASS VARIABLE AND METHOS IN BCLASS AND IN CCLASS


public class Cclass extends Aclass {
	int x=60;
public static void main(String[] args) {
	Cclass x1=new Cclass();
	int y=x1.x+x1.a;
	System.out.println(y);
	x1.Aclassmethod();
		
}	
}

