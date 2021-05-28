package com.skilldistillery.jets.entity;

public interface Refuelable {
	
	void fillUp();
	boolean isFull(double amount);
	
}
