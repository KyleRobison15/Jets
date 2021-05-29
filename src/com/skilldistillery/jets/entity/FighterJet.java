package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements Combat {

	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public FighterJet(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		super(model, speed, range, price, fuelCapacityInGallons);
	}
	
	@Override
	public void fight() {
		System.out.println("Slingshot.. engage.  Shake and Bake babyyy! Firing rockets!!!");
		
	}

	@Override
	public void defend() {
		System.out.println("Deploying flares and commensing evasive maneuver!!!");
		
	}

	@Override
	public void fly() {
		System.out.println("WOOOSH. I'm fast and agile");

	}

	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
