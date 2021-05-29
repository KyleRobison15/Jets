package com.skilldistillery.jets.entity;

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
	
	public List<Jet> getJets() {
		List<Jet> listOfJets = jets;
		
		return listOfJets;
	}
	
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
			jet.refuel(jet.getFuelCapacityInGallons());;
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
	
	public void userAddJet(Scanner input) {
		Jet userJet;
		
		System.out.println("Which type of Jet will you be adding?");
		System.out.println("1. Standard Passenger Jet");
		System.out.println("2. Fighter Jet");
		System.out.println("3. Cargo Jet");
		System.out.println("4. Space Shuttle");
		System.out.println("5. Spy Plane");
		System.out.println("6. Drone");
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Current Jets in Airfield: ").append(jets).append(" |");
		return builder.toString();
	}
	
	
	
}
