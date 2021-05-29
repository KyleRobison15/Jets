package com.skilldistillery.jets.entity;

public class JetImpl extends Jet {

	public JetImpl() {
		// TODO Auto-generated constructor stub
	}

	public JetImpl(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public JetImpl(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		super(model, speed, range, price, fuelCapacityInGallons);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refuel(double amount) {
		// TODO Auto-generated method stub

	}

}
