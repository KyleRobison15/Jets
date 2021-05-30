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
		
		// Read in names from jets.txt and store in AirField
		jetsApp.airField = jetsApp.readJetsFromFile("jets.txt");
		
		// Allow user to choose menu options and call methods based on choice
		boolean usingMenu = true;
		while (usingMenu) {
			int userChoice = jetsApp.menuChoice(input);
			usingMenu = jetsApp.doUserChoice(userChoice, jetsApp.airField, input);
			
			}
			
		}
		
	private AirField readJetsFromFile(String fileName) {
		// Declare outside the try/catch.
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
	
	public int menuChoice(Scanner input) {
		int choice;

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
		System.out.println("12. Quit");
		System.out.println("-------------------------------------------------------");

		choice = input.nextInt();
		System.out.println();

		return choice;

	}
	
	public boolean doUserChoice (int userChoice, AirField af, Scanner input) {
		
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
			
			while(addingJets) {
				int userJetChoice = af.userJetChoice(input);
				userJet = af.userJetCreation(userJetChoice);
				userJet = af.userJetConstruction(userJet, input);
				af.addJet(userJet);
				addingJets = af.addingJets(input);
			}
			
			return true;
		case 11:
			boolean removingJets = true;
			while(removingJets) {
				af.userJetRemove(input);
				removingJets = af.removingJets(input);
			}
			
			return true;
		case 12:
			System.out.println("Thanks for flying with us! Goodbye.");
			return false;
		default:
			System.out.println("Your entry was invalid. Please enter the number of the cooresponding menu item.");
			return true;
		
		}
	}

}
