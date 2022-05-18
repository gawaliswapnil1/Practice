package com.epam.learning;

public class PassingBYVaue {

	public static void main(String[] args) {
	    int a = 6;
	    System.out.println(a);

	    String s = "John";
	    System.out.println(s);

	    StringBuffer sb = new StringBuffer("Apple");
	    meth(sb);
	    System.out.println(sb);

	    A obj = new A();
	    obj.a = 2;
	    obj.b = "Hi";

	    meth(obj);
	    System.out.println(obj.a);
	    System.out.println(obj.b);
	}

	public static void meth(A obj) {
	    obj.a = 4;
	    obj.b = "Hello";
	}

	public static void meth(StringBuffer sb) {
	    sb.replace(0,sb.length(),"Orange");
	}

	public static void meth(String s) {
	    s = "Steve";
	}

	public static void meth(int s) {
	    s=2;
	}

	
}
class A{
	int a;
	String b;
}
