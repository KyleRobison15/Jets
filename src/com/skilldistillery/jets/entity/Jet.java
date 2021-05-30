package com.skilldistillery.jets.entity;

public abstract class Jet{
	
	private static final double mphToMachConversion = 0.001303;
	private static int nextJetId;
	private int jetId;
	private String model;
	private double speedInMph;
	private int range;
	private double price;
	private double fuelCapacityInGallons;
	
	public abstract void refuel(double amount);
	public abstract void fly();
	
	public double getSpeedInMach(double speedInMph) {
		double speedInMach = Math.floor((speedInMph * mphToMachConversion)*100) / 100; 
		return speedInMach;
	}
	
	public double getHoursCanFly(int range, double speedInMph) {
		double hoursCanFly = Math.floor((range/speedInMph)*100) / 100;
		return hoursCanFly;
	}
	
	public Jet() {
		this.jetId = nextJetId;
		nextJetId++;
	}
	
	
	public Jet(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		
		this.model = model;
		this.speedInMph = speedInMph;
		this.range = range;
		this.price = price;
		this.fuelCapacityInGallons = fuelCapacityInGallons;
		this.jetId = nextJetId;
		nextJetId++;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeedInMph() {
		return speedInMph;
	}
	public void setSpeedInMph(double speedInMph) {
		this.speedInMph = speedInMph;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFuelCapacityInGallons() {
		return fuelCapacityInGallons;
	}
	public void setFuelCapacityInGallons(double fuelCapacityInGallons) {
		this.fuelCapacityInGallons = fuelCapacityInGallons;
	}
	public double getId() {
		return jetId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| Jet ID: ").append(jetId).append(" | Model: ").append(model).append(" | Top Speed: ").append(speedInMph).append(" Mph").append(" | Range: ")
				.append(range).append(" miles").append(" | Price: ").append(price).append(" |");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + range;
		temp = Double.doubleToLongBits(speedInMph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speedInMph) != Double.doubleToLongBits(other.speedInMph))
			return false;
		return true;
	}
	
}
