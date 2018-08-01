package com.caozeal.practice;

public class TryAboutChild extends TryAboutFather {

	public TryAboutChild(String lastName) {
		super(lastName);
		this.lastName = lastName;
		System.out.println("子类构造");
	}

	{
		System.out.println("子类块");
	}
	static {
		System.out.println("子类静态块");
	}
}

