package com.skilldistillery.jets.entity;

import java.util.Scanner;

public class Drone extends Jet implements Spy, Combat, RemoteControlled {

	public Drone() {
	}

	public Drone(String model, double speedInMph, int range, double price, double fuelCapacityInGallons) {
		super(model, speedInMph, range, price, fuelCapacityInGallons);
	}

	@Override
	public void getControlled(Scanner input) {
		boolean usingMenu = true;

		while (usingMenu) {

			System.out.println("Control the drone by choosing one of the following options: ");
			System.out.println("1. Carry out a drone strike.");
			System.out.println("2. Evade an enemy's incoming rocket.");
			System.out.println("3. Gather intel.");
			System.out.println("4. Go Stealth.");
			System.out.println("5. Refuel.");
			System.out.println("6. Stop controlling.");

			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 1:
				fight();
				break;
			case 2:
				defend();
				break;
			case 3:
				gatherIntel();
				break;
			case 4:
				goStealth();
				break;
			case 5:
				refuel(getFuelCapacityInGallons());
				break;
			case 6:
				usingMenu = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter the number of the cooresponding menu option.");

			}
		}
	}

	@Override
	public void fight() {
		System.out.println("Commensing drone strike. WHAMMY! You didn't even see it coming.");
		System.out.println();
	}

	@Override
	public void defend() {
		System.out.println("Evasive maneuver!!! Deploying Flares!");
		System.out.println();

	}

	@Override
	public void gatherIntel() {
		System.out.println(
				"I'm gathering intel.. but because of polymorphism, I'm doing it like a drone, rather than a spy plane!");
		System.out.println();

	}

	@Override
	public void goStealth() {
		System.out
				.println("I'm goint stealth.. but because of polymorphism, I'm doing it differently than a spy plane!");
		System.out.println();

	}

	@Override
	public void fly() {
		System.out.println("Drone: " + this.toString());
		System.out.println(
				"Im flying, but because of polymorphism, I'm flying differently from all the other Jet objects!");
		System.out.println(
				"Number of hours this jet can fly: " + this.getHoursCanFly(getRange(), getSpeedInMph()) + " hours.");
		System.out.println("Speed in Mach: " + this.getSpeedInMach(getSpeedInMph()));
		System.out.println();
	}

	@Override
	public void refuel(double amount) {
		System.out.println("Recharging the batteries. Ahhhh feels good to kick back.");
		System.out.println();
	}

}
