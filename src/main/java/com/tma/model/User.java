package com.tma.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {
	
	@Id
	private String id;
	private String name;
	private String address;
	private int age;
	public User() {
	}
	
	public User(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public User(String id, String name, String address, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address
				+ ", age=" + age + "]";
	}
	
}
