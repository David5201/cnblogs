package com.cnblogs.json.pojo;

public class Person {
	String familyName;
	String sex;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public Person(String familyName, String sex) {
		this.familyName = familyName;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [familyName=" + familyName + ", sex=" + sex + "]";
	}
	
	
	
}
