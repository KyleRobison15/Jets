package com.skilldistillery.jets.entity;

public class SpaceShuttle extends Jet implements ExploresSpace {

	public SpaceShuttle() {
	}

	public SpaceShuttle(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public SpaceShuttle(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		super(model, speed, range, price, fuelCapacityInGallons);
	}

	@Override
	public void goToSpace() {
		System.out.println("T-minus 3..2..1.. Liftoff!!");

	}

	@Override
	public void returnFromSpace() {
		System.out.println("Entering earth's atmosphere!");

	}

	@Override
	public void orbit() {
		System.out.println("Trajectory stable. Shuttle is in orbit!");
	}

	@Override
	public void fly() {
		System.out.println("Just up here floating... Nice and quiet. Shhhh.");

	}

	@Override
	public void refuel(double amount) {
		System.out.println("Refueling my tank with " + amount + " gallons of high quality jet fuel!");

	}

}
