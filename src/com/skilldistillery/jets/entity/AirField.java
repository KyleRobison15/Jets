package com.skilldistillery.jets.entity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AirField {
	private List<Jet> jets;
	Scanner input = new Scanner(System.in);

	public AirField() {
		jets = new ArrayList<>();
	}

	public void addJet(Jet j) {
		jets.add(j);
	}

	public void removeJet(Jet j) {
		if (getJets().size() == 1) {
			System.out.println("Sorry, you're not allowed to remove the last jet in the fleet.");
		} else {
			jets.remove(j);
		}
	}

	public List<Jet> getJets() {
		List<Jet> listOfJets = jets;

		return listOfJets;

	}
	/////////////////////////////// Standard Airfield Operations Methods ///////////////////////////////

	public void listAllJets() {
		System.out.println("Current Jets in the Airfield:");
		for (Jet jet : this.getJets()) {
			System.out.println(jet.toString());
		}
		System.out.println();
	}

	public void flyAllJets() {
		System.out.println("This is quite the sortee of jets! Look at em' go!");
		System.out.println();
		for (Jet jet : this.getJets()) {
			jet.fly();
		}
	}

	public void refuelAllJets() {
		System.out.println("Fill em' up!");
		System.out.println();
		for (Jet jet : this.getJets()) {
			System.out.println(jet.toString());
			jet.refuel(jet.getFuelCapacityInGallons());
			;
			System.out.println();
		}
	}

	public void findFastestJet() {
		Jet fastest = this.getJets().get(0);
		for (int i = 0; i < this.getJets().size(); i++) {
			if (this.getJets().get(i).getSpeedInMph() > fastest.getSpeedInMph()) {
				fastest = this.getJets().get(i);
			}
		}
		System.out.println("Currently, the fastest jet in the fleet is:");
		System.out.println(fastest.toString());
		System.out.println();
	}

	public void findLongestRange() {
		Jet longestRange = this.getJets().get(0);
		for (int i = 0; i < this.getJets().size(); i++) {
			if (this.getJets().get(i).getRange() > longestRange.getRange()) {
				longestRange = this.getJets().get(i);
			}
		}
		System.out.println("Currently, the jet with the longest range is: ");
		System.out.println(longestRange.toString());
		System.out.println();
	}

	public void loadAllCargoJets() {
		for (Jet jet : this.getJets()) {
			if (jet instanceof CargoPlane) {
				System.out.println(((CargoPlane) jet).toString());
				((CargoPlane) jet).loadCargo();
				System.out.println();
			}
		}
	}

	public void unloadAllCargoJets() {
		for (Jet jet : this.getJets()) {
			if (jet instanceof CargoPlane) {
				System.out.println(((CargoPlane) jet).toString());
				((CargoPlane) jet).unloadCargo();
				System.out.println();
			}
		}
	}

	public void dogFight() {
		for (Jet jet : this.getJets()) {
			if (jet instanceof FighterJet) {
				System.out.println(((FighterJet) jet).toString());
				((FighterJet) jet).fight();
				System.out.println();
			}
		}
	}

	public void defendFighters() {
		for (Jet jet : this.getJets()) {
			if (jet instanceof FighterJet) {
				System.out.println(((FighterJet) jet).toString());
				((FighterJet) jet).defend();
				System.out.println();
			}
		}
	}

	public int userJetChoice(Scanner input) {
		int choice;

		System.out.println("Which type of Jet will you be adding?");
		System.out.println("1. Standard Passenger Jet");
		System.out.println("2. Fighter Jet");
		System.out.println("3. Cargo Jet");
		System.out.println("4. Space Shuttle");
		System.out.println("5. Spy Plane");
		System.out.println("6. Drone");

		choice = input.nextInt();
		input.nextLine();
		System.out.println();

		return choice;
	}

	public Jet userJetCreation(int userJetChoice) {
		Jet userJet = null;
		switch (userJetChoice) {
		case 1:
			userJet = new JetImpl();
			break;
		case 2:
			userJet = new FighterJet();
			break;
		case 3:
			userJet = new CargoPlane();
			break;
		case 4:
			userJet = new SpaceShuttle();
			break;
		case 5:
			userJet = new SpyPlane();
			break;
		case 6:
			userJet = new Drone();
			break;
		default:
			System.out.println("Invalid choice. Please enter the number of the correspinding menu option.");

		}
		return userJet;
	}

	public Jet userJetConstruction(Jet constructedUserJet, Scanner input) {

		System.out.println("What is the model of this jet?");
		String model = input.nextLine();
		constructedUserJet.setModel(model);

		System.out.println("What is this jet's top speed in mph?");
		double speed = input.nextDouble();
		constructedUserJet.setSpeedInMph(speed);

		System.out.println("What is the range of this jet in miles?");
		int range = input.nextInt();
		constructedUserJet.setRange(range);

		System.out.println("What is the price of this jet in USD?");
		double price = input.nextDouble();
		constructedUserJet.setPrice(price);

		System.out.println("What is the fuel capacity of this jet in gallons?");
		double fuel = input.nextDouble();
		input.nextLine();
		constructedUserJet.setFuelCapacityInGallons(fuel);

		return constructedUserJet;
	}

	public boolean addingJets(Scanner input) {

		System.out.println("Would you like to add another jet?");
		System.out.println("Yes or No");
		String choice = input.nextLine();
		if (choice.equals("Y") || choice.equals("y") || choice.equals("Yes")) {
			return true;
		} else if (choice.equals("N") || choice.equals("n") || choice.equals("No")) {
			return false;
		} else {
			System.out.println("Invalid choice. Please enter Yes or No.");
			return true;
		}

	}

	public void userJetRemove(Scanner input) {
		int jetId;
		Jet jetToRemove = null;

		System.out.println("Enter the Jet ID of the Jet you would like to remove:");
		listAllJets();
		jetId = input.nextInt();
		input.nextLine();

		for (int i = 0; i < getJets().size(); i++) {
			if (getJets().get(i).getId() == jetId) {
				jetToRemove = getJets().get(i);
			}
		}

		if (jetToRemove == null) {
			System.out.println("Invalid choice. No jet was removed.");
		} else {
			System.out
					.println("You've removed Jet ID: " + (int) (jetToRemove.getId()) + " | " + jetToRemove.getModel());
			removeJet(jetToRemove);
		}
	}

	public boolean removingJets(Scanner input) {

		System.out.println("Would you like to remove another jet?");
		System.out.println("Yes or No");
		String choice = input.nextLine();
		if (choice.equals("Y") || choice.equals("y") || choice.equals("Yes")) {
			return true;
		} else if (choice.equals("N") || choice.equals("n") || choice.equals("No")) {
			return false;
		} else {
			System.out.println("Invalid choice. Please enter Yes or No.");
			return true;
		}

	}

	/////////////////////////////// Specialized Airfield Operations Methods ///////////////////////////////

	public void flyIndividualJet(Scanner input) {

		int jetId;
		Jet jetToFly = null;

		System.out.println("Enter the ID of the jet you would like to fly: ");
		listAllJets();
		jetId = input.nextInt();
		input.nextLine();

		for (int i = 0; i < getJets().size(); i++) {
			if (getJets().get(i).getId() == jetId) {
				jetToFly = getJets().get(i);
			}
		}

		jetToFly.fly();

	}

	public void controlDrone(Scanner input) {
		boolean isNotDrone = true;
		int jetId;
		Jet droneToControl = null;

		while (isNotDrone) {
		System.out.println("Enter the ID of the drone you would like to control: ");
		
		for (int i = 0; i < getJets().size(); i++) {
			if (getJets().get(i) instanceof Drone) {
				System.out.println(getJets().get(i).toString());
			}
		}

		jetId = input.nextInt();

			for (int i = 0; i < getJets().size(); i++) {
				if (getJets().get(i).getId() == jetId) {
					droneToControl = getJets().get(i);
				} 
				
			}
			if (droneToControl instanceof Drone) {
				
				isNotDrone = false;
				((Drone) (droneToControl)).getControlled(input);
			}
			else {
				System.out.println("Invalid choice. Please choose a drone.");
				isNotDrone = true;
			}
		}
	}

	public boolean isThereDronesInFleet() {
		int numberOfDrones = 0;

		for (int i = 0; i < getJets().size(); i++) {
			if (getJets().get(i) instanceof Drone) {
				numberOfDrones++;
			}
		}

		if (numberOfDrones > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public void hirePilot(Scanner input) {

		int jetId;
		Jet jetToHireFor = null;

		System.out.println("Enter the ID of the jet you would like to hire a pilot for.");
		listAllJets();
		jetId = input.nextInt();
		input.nextLine();

		for (int i = 0; i < getJets().size(); i++) {
			if (getJets().get(i).getId() == jetId) {
				jetToHireFor = getJets().get(i);
			}
		}

		jetToHireFor.setPilot(input);
		System.out.println(jetToHireFor.toString());
		System.out.println();

	}
	
	  public void writeFleetToFile(Scanner input) {
		 String name;
		 String fileName;
		  
		  System.out.println("Note: The current jets in the fleet will be saved to a standard .txt file.");
		  System.out.println("Enter a file name: ");
		  name = input.next();
				  
			 if (name.contains(".txt") || name.contains(".csv")) {
				fileName = name;
			} 
			 else {
				 fileName = (name + ".txt");
			 }
		  
		  
		  try {
		      FileWriter fw = new FileWriter(fileName);
		      PrintWriter pw = new PrintWriter(fw);
		      for (Jet jet : jets) {
		        
		    	StringBuilder sb = new StringBuilder();
		        sb.append(jet.getId());
		        sb.append(',');
		        sb.append(jet.getPilot());
		        sb.append(',');
		        sb.append(jet.getModel());
		        sb.append(',');
		        sb.append(jet.getSpeedInMph());
		        sb.append(',');
		        sb.append(jet.getRange());
		        sb.append(',');
		        sb.append(jet.getPrice());
		        sb.append(',');
		        sb.append(jet.getFuelCapacityInGallons());
		        pw.println(sb);
		      }
		      pw.close();
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Current Jets in Airfield: ").append(jets).append(" |");
		return builder.toString();
	}

}
