package com.skilldistillery.jets.entity;

public class JetImpl extends Jet {

	public JetImpl() {}
	
	public JetImpl(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		super(model, speedInMph, range, price, fuelCapacityInGallons);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("Standard Jet: " + this.toString());
		System.out.println("Amount of time this jet can fly: " + this.getHoursCanFly(getRange(), getSpeedInMph()));
	}

	@Override
	public void refuel(double amount) {

	}

}
