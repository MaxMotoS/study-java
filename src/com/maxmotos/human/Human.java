package com.maxmotos.human;

public class Human {
	private String name;

	public void sayHello() {
		System.out.println("Hello. My name is " + name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}