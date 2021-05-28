package com.skilldistillery.jets.entity;

public abstract class Jet implements Refuelable {
	
	private String model;
	private double speedInMph;
	private int range;
	private double price;
	private double fuelCapacityInGallons;
	private static final double mphToMachConversion = 0.001303;
	
	public abstract void fly();
	public double getSpeedInMach(double speedInMph) {
		double speedInMach = speedInMph * mphToMachConversion; 
		
		return speedInMach;
	}
	
	public Jet() {}
	
	
	public Jet(String model, double speed, int range, double price) {
		this.model = model;
		this.speedInMph = speed;
		this.range = range;
		this.price = price;
	}
	
	public Jet(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		this(model, speed, range, price);
		this.fuelCapacityInGallons = fuelCapacityInGallons;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=").append(model).append(", speedInMph=").append(speedInMph).append(", range=")
				.append(range).append(", price=").append(price).append("]");
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
