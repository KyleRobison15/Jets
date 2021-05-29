package com.skilldistillery.jets.entity;

public class SpyPlane extends Jet implements Spy {

	public SpyPlane() {
		// TODO Auto-generated constructor stub
	}

	public SpyPlane(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public SpyPlane(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		super(model, speed, range, price, fuelCapacityInGallons);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gatherIntel() {
		System.out.println("I have all your darkest secrets! Muwahahaaa!");
	}

	@Override
	public void goStealth() {
		System.out.println("You didn't see anything.. I'm not even here.");
	}

	@Override
	public void fly() {
		System.out.println("I'm fast, but quiet. Even more quiet if you call my goStelth() method!");
	}

	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
