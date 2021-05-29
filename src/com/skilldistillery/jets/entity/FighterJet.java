package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements Combat {

	public FighterJet() {
	}
	
	public FighterJet(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		super(model, speedInMph, range, price, fuelCapacityInGallons);
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
		System.out.println("Fighter Jet: " + this.toString());
		System.out.println("WOOOSH. I'm fast and agile");
		System.out.println("Number of hours this jet can fly: " + this.getHoursCanFly(getRange(), getSpeedInMph()) + " hours.");
		System.out.println("Speed in Mach: " + this.getSpeedInMach(getSpeedInMph()));
		System.out.println();

	}

	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
