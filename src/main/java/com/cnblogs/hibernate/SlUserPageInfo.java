package com.cnblogs.hibernate;

import com.cnblogs.json.pojo.Person;

public class SlUserPageInfo {
	private long totalPage ;

	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	private Person person;

}
