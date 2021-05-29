package com.skilldistillery.jets.entity;

public class SpyPlane extends Jet implements Spy {

	public SpyPlane() {
	}

	public SpyPlane(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		super(model, speedInMph, range, price, fuelCapacityInGallons);
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
		System.out.println("Spy Plane: " + this.toString());
		System.out.println("I'm fast, but quiet. Even more quiet if you call my goStelth() method!");
		System.out.println("Number of hours this jet can fly: " + this.getHoursCanFly(getRange(), getSpeedInMph()) + " hours.");
		System.out.println("Speed in Mach: " + this.getSpeedInMach(getSpeedInMph()));
		System.out.println();
	}

	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
