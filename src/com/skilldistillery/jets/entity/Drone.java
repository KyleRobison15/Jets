package com.skilldistillery.jets.entity;

import java.util.Scanner;

public class Drone extends Jet implements Spy, Combat, RemoteControlled {

	public Drone() {
		// TODO Auto-generated constructor stub
	}

	public Drone(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public Drone(String model, double speed, int range, double price, double fuelCapacityInGallons) {
		super(model, speed, range, price, fuelCapacityInGallons);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getControlled(Scanner input) {
		boolean usingMenu = true;
		input = new Scanner(System.in);
		
		while(usingMenu)
		System.out.println("Control the drone by choosing one of the following options: ");// TODO Auto-generated method stub		
		System.out.println("1. Carry out a drone strike.");
		System.out.println("2. Evade an enemy's incoming rocket.");
		System.out.println("3. Gather intel.");
		System.out.println("4. Go Stealth.");
		System.out.println("5. Refuel.");
		System.out.println("6. Stop controlling.");
		
		int choice = input.nextInt();
		input.nextLine();
		
		switch(choice) {
		
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
		input.close();
		
		}

	@Override
	public void fight() {
		System.out.println("Commensing drone strike. WHAMMY! You didn't even see it coming.");
	}

	@Override
	public void defend() {
		System.out.println("Commensing drone strike. WHAMMY! You didn't even see it coming.");

	}

	@Override
	public void gatherIntel() {
		System.out.println("I'm gathering intel.. but because of polymorphism, I'm doing it differently than a spy plane!");

	}

	@Override
	public void goStealth() {
		System.out.println("I'm goint stealth.. but because of polymorphism, I'm doing it differently than a spy plane!");

	}

	@Override
	public void fly() {
		System.out.println("Im flying, but because of polymorphism, I'm flying differently from all the other Jet objects!");

	}

	@Override
	public void refuel(double amount) {
		System.out.println("Recharging the batteries. Ahhhh feels good to kick back.");
	}

}