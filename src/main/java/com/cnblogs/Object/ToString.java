package com.cnblogs.Object;

public class ToString {
	private String name;
	private int age;
	
	public ToString(String name, int age) {
		this.name = name;
		this.age = age;
	}



//	@Override
//	public String toString() {
//		return "ToString [name=" + name + ", age=" + age + "]";
//	}



	public static void main(String[] args) {
		ToString tostr = new ToString("david",22);
		System.out.println(tostr);

	}

}
