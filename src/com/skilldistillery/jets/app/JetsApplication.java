package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.CargoPlane;
import com.skilldistillery.jets.entity.Drone;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.Jet;
import com.skilldistillery.jets.entity.JetImpl;
import com.skilldistillery.jets.entity.SpaceShuttle;
import com.skilldistillery.jets.entity.SpyPlane;

public class JetsApplication {
	private AirField airField;

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		Scanner input = new Scanner(System.in);

		jetsApp.airField = jetsApp.readJetsFromFile("jets.txt");

		int userChoice1 = jetsApp.menuChoice1(input);
		jetsApp.whichMenu(input, userChoice1);

		input.close();
	}

	private AirField readJetsFromFile(String fileName) {
		AirField fleetOfJets = new AirField();

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = bufIn.readLine()) != null) {

				String[] jetRecord = line.split(",");
				String model = jetRecord[0];
				double speed = Float.parseFloat(jetRecord[1]);
				int range = Integer.parseInt(jetRecord[2]);
				double price = Float.parseFloat(jetRecord[3]);
				double fuelCapacityInGallons = Float.parseFloat(jetRecord[4]);
				Jet jet;

				switch (model.charAt(0)) {

				case 'F':
				case 'f':
					jet = new FighterJet(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);
					break;

				case 'C':
				case 'c':
					jet = new CargoPlane(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);
					break;

				case 'S':
				case 's':
				case 'U':
				case 'u':
					jet = new SpyPlane(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);
					break;

				case 'O':
				case 'o':
					jet = new SpaceShuttle(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);
					break;

				case 'M':
				case 'm':
					jet = new Drone(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);
					break;
				default:
					jet = new JetImpl(model, speed, range, price, fuelCapacityInGallons);
					fleetOfJets.addJet(jet);

				}

			}

		} catch (IOException e) {
			System.err.println(e);
		}

		return fleetOfJets;
	}

	private void whichMenu(Scanner input, int userChoice1) {

		switch (userChoice1) {

		case 1:
			boolean usingMenu2 = true;
			while (usingMenu2) {
				int userChoice2 = menuChoice2(input);
				usingMenu2 = doStandardAirfieldOptions(userChoice2, airField, input);
			}
			break;
		case 2:
			boolean usingMenu3 = true;
			while (usingMenu3) {
				int userChoice3 = menuChoice3(input);
				usingMenu3 = doSpecializedAirfieldOptions(userChoice3, airField, input);
			}
			break;

		default:
			System.out.println("You entered an invalid choice. Please enter a number.");

		}

	}

	private int menuChoice1(Scanner input) {
		int choice = 0;
		boolean usingMenu = true;

		while (usingMenu) {
			System.out.println("------ WELCOME TO THE AIRFIELD ------");
			System.out.println("Which hangar would you like to go to?");
			System.out.println("--------------------------------------");
			System.out.println("1. Standard Airfield Operations ");
			System.out.println("2. Specialized Airfield Operations ");
			System.out.println("--------------------------------------");

			choice = input.nextInt();
			input.nextLine();

			if (choice == 1 || choice == 2) {
				usingMenu = false;
			} else {
				System.out.println("You entered an invalid choice. Please enter a number.");
				usingMenu = true;
			}

		}
		return choice;
	}

	private int menuChoice2(Scanner input) {
		int choice;

		System.out.println("------- HANGAR 1: STANDARD AIRFIELD OPERATIONS -------");
		System.out.println("Enter the number for which menu option you would like.");
		System.out.println("------------------------------------------------------");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. Refuel all jets");
		System.out.println("4. View fastest jet");
		System.out.println("5. View jet with longest range");
		System.out.println("6. Load all Cargo Jets");
		System.out.println("7. Unload all Cargo Jets");
		System.out.println("8. Attack with all Fighter Jets");
		System.out.println("9. Defend with all Fighter Jets");
		System.out.println("10. Add a jet to the fleet");
		System.out.println("11. Remove a jet from the fleet");
		System.out.println("12. Go to hangar 2 (Specialized Operations)");
		System.out.println("13. Quit (leave the airfield)");
		System.out.println("-------------------------------------------------------");

		choice = input.nextInt();
		System.out.println();

		return choice;

	}

	private int menuChoice3(Scanner input) {
		int choice;

		System.out.println("----- HANGAR 2: SPECIALIZED AIRFIELD OPERATIONS ------");
		System.out.println("Enter the number for which menu option you would like.");
		System.out.println("------------------------------------------------------");
		System.out.println("1. Fly an individual jet");
		System.out.println("2. Control a drone (only applicable if there is a drone in the fleet)");
		System.out.println("3. Hire a pilot");
		System.out.println("4. Save current fleet of jets to file");
		System.out.println("5. List Fleet");
		System.out.println("6. Fly all jets");
		System.out.println("7. Go to hangar 1 (Standard Operations)");
		System.out.println("8. Quit (leave the airfield)");
		System.out.println("-------------------------------------------------------");

		choice = input.nextInt();
		System.out.println();

		return choice;
	}

	private boolean doStandardAirfieldOptions(int userChoice, AirField af, Scanner input) {

		switch (userChoice) {

		case 1:
			af.listAllJets();
			return true;
		case 2:
			af.flyAllJets();
			return true;
		case 3:
			af.refuelAllJets();
			return true;
		case 4:
			af.findFastestJet();
			return true;
		case 5:
			af.findLongestRange();
			return true;
		case 6:
			af.loadAllCargoJets();
			return true;
		case 7:
			af.unloadAllCargoJets();
			return true;
		case 8:
			af.dogFight();
			return true;
		case 9:
			af.defendFighters();
			return true;
		case 10:
			boolean addingJets = true;
			Jet userJet;

			while (addingJets) {
				int userJetChoice = af.userJetChoice(input);
				userJet = af.userJetCreation(userJetChoice);
				userJet = af.userJetConstruction(userJet, input);
				af.addJet(userJet);
				addingJets = af.addingJets(input);
			}
			return true;
		case 11:
			boolean removingJets = true;
			while (removingJets) {
				af.userJetRemove(input);
				removingJets = af.removingJets(input);
			}
			return true;
		case 12:
			whichMenu(input, 2);
			return false;
		case 13:
			System.out.println("Thanks for flying with us! Goodbye.");
			return false;
		default:
			System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
			return true;

		}
	}

	private boolean doSpecializedAirfieldOptions(int userChoice, AirField af, Scanner input) {

		switch (userChoice) {

		case 1:
			af.flyIndividualJet(input);
			return true;
		case 2:
			boolean isDrones = af.isThereDronesInFleet();
			if (isDrones) {
				af.controlDrone(input);
			} else {
				System.out.println("Sorry there are no drones currently in the fleet.");
				System.out.println();
			}
			return true;
		case 3:
			af.hirePilot(input);
			return true;
		case 4:
			af.writeFleetToFile(input);
			return true;
		case 5:
			af.listAllJets();
			return true;
		case 6:
			af.flyAllJets();
			return true;
		case 7:
			whichMenu(input, 1);
			return false;
		case 8:
			System.out.println("Thanks for flying with us! Goodbye.");
			return false;
		default:
			System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
			return true;

		}
	}

}
