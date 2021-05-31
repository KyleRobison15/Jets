package com.skilldistillery.jets.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Jet{

	private static List<String> pilots;
	private String pilot;
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
	
	private static void addPilots() {
		pilots = new ArrayList<>();
		
		pilots.add("Maverick");
		pilots.add("Goose");
		pilots.add("Iceman");
		pilots.add("Viper");
		pilots.add("Cougar");
		pilots.add("Hollywood");
		
	}
	
	public double getSpeedInMach(double speedInMph) {
		double speedInMach = Math.floor((speedInMph * mphToMachConversion)*100) / 100; 
		return speedInMach;
	}
	
	public double getHoursCanFly(int range, double speedInMph) {
		double hoursCanFly = Math.floor((range/speedInMph)*100) / 100;
		return hoursCanFly;
	}
	
	private String setInitialPilot () {
		addPilots();
		String pilotToAssign;
		pilotToAssign = pilots.get((int)(Math.random() * pilots.size()));
		
		return pilotToAssign;
	}
	
	public void listPilots() {
		for (String string : pilots) {
			System.out.println(string); 
		}
		
	}
	
	public Jet() {
		this.pilot = setInitialPilot();
		this.jetId = nextJetId;
		nextJetId++;
	}
	
	
	public Jet(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		
		this.model = model;
		this.speedInMph = speedInMph;
		this.range = range;
		this.price = price;
		this.fuelCapacityInGallons = fuelCapacityInGallons;
		this.pilot = setInitialPilot();
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
	public String getPilot() {
		return pilot;
	}
	
	public void setPilot(Scanner input) {
		
		
		boolean hiringPilot = true;
		while (hiringPilot) {
			
		System.out.println("Which pilot would you like to hire? (Enter name)");
		System.out.println("------------------------------------------------");
		for (String string : pilots) {
			System.out.println(string);
		}
		
		String pilotToHire = input.nextLine();
		
		for (String string : pilots) {
			if (pilotToHire.equalsIgnoreCase(string)) {
				this.pilot = pilotToHire;
			}
		}
		
		if (pilotToHire.equals(null)) {
			hiringPilot = true;
		}
		else {
			System.out.println("Great choice! You've hired " + pilotToHire + ", a former Top Gun pilot!");
			System.out.println();
			hiringPilot = false;
		}
		
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| Jet ID: ").append(jetId).append(" | Pilot: ").append(pilot).append(" | Model: ").append(model).append(" | Top Speed: ").append(speedInMph).append(" Mph").append(" | Range: ")
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
