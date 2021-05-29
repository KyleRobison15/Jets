package com.skilldistillery.jets.entity;

public class CargoPlane extends Jet implements CarryCargo {

	
	public CargoPlane() {
	}

	public CargoPlane(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		super(model, speedInMph, range, price, fuelCapacityInGallons);
	}

	@Override
	public void loadCargo() {
		System.out.println("Tossing your fragile cargo carelessly onto the conveyor belt...");

	}

	@Override
	public void unloadCargo() {
		System.out.println("Removing your broken fragile cargo from the cargo hold...");

	}

	@Override
	public void fly() {
		System.out.println("CargoPlane: " + this.toString());
		System.out.println("I'm flying as slow as possible directly above your house!"
				+ " Shaking everything and your soul to its core!!!!");
		System.out.println("Number of hours this jet can fly: " + this.getHoursCanFly(getRange(), getSpeedInMph()) + " hours.");
		System.out.println("Speed in Mach: " + this.getSpeedInMach(getSpeedInMph()));
		System.out.println();

	}
	
	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
