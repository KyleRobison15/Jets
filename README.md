# Jets Project
### Overview of Program
This program creates a fleet of various types of jets by reading in data from a text file and stores those different jets in an airfield. The user can then choose from various menu options to perform different actions with each individual jet or the fleet as whole.

In my particular program, there are two different "hangars" the user can go to which each has a different set of menu options:
1. Standard Airfield Operations: Has menu options for simple actions like listing the fleet of jets, flying all the jets, viewing the fastest jet, viewing the jet with the longest range, adding and removing jets and a few other options.
2. Specialized Airfield Operations: Has menu options for more specialized actions like flying an individual jet, controlling a drone, hiring a pilot, and saving the current fleet of jets to a text file.

### Object Oriented Programming (OOP)
This project exemplifies OOP in several different ways. The program uses a Jet abstract class that serves as the blueprint for creating different Jet objects. This Jet abstract class is the parent class (or superclass) for 6 different subclasses of Jet - CargoJet, FighterJet, SpaceShuttle, SpyPlane, and Drone. Lastly, this program utilizes 4 different interfaces that are implemented by certain types of jets.

#### Data Abstraction
I took a look at what a Jet is in the real world, and modeled a very simple version in my Jet abstract class. My abstraction of a Jet includes instance fields for its unique ID, pilot, model, speed, range, price, and fuel capacity. In addition, all the subclasses of Jet have different behavior based on what those types of jets can do in the real world. For example, the FighterJet subclass has a method for fighting and the CargoJet subclass has a method for loading cargo.

This program also utilizes an AirField class to store the different types of jets. The AirField class uses the ArrayList data structure within java to represent what an airfield is in the real world - a collection of jets.

#### Data Encapsulation
As part of the design process of the Jet class and all of the subclasses of Jet, I made the visibility of the instance fields private. The user cannot directly change each Jet object's fields. Instead, they can only interact with the instance fields through getters and setters (accessors and mutators).

The setPilot() method in the Jet class is a great example of this. This method defines the way a user can change the pilot of a jet. They cannot directly change the pilot field to anything they want. Instead, the user must choose one of 6 available pilots for hire.

Finally, the Jet class has 3 static fields that only belong to the class. The mphToMachConversion static field is declared as a final field because there is only one number to convert MPH to Mach, which should never change.

#### Inheritance and Polymorphism
The use of inheritance and polymorphism is where the real magic of this program lies. Each of the 6 different subclasses of Jet inherit the state (fields) and behavior (methods) from the Jet superclass. This means that each of the subclasses is-a Jet, so we can store them all in an ArrayList data structure that holds Jet objects.

However the fields and methods of each subclass are defined differently depending on which type of Jet it is.
For example, the fly() method for a FighterJet is defined differently from that of a CargoJet or Drone. This allows the program to run through the collection of jets in our airfield calling each of their fly() methods, and each jet will fly differently.

The Drone class in this program is an excellent demonstration of the power of OOP. It is-a Jet but has its own unique method definitions, and also implements three different interfaces! This means it can do all the things a standard Jet, SpyPlane and FighterJet can do on top of its own unique behavior.

### Other Features and Technologies Used
*Interfaces
This program uses 4 different interfaces that are implemented differently by certain types of jets. The drone implements 3 of these interfaces (combat, spy, and remote controlled) because it can behave like a both a SpyPlane and a FighterJet as well as in its own unique way.

*ArrayList Data Structure
The AirField class uses the ArrayList data structure to store Jet objects. This was a very useful way to allow the user to interact with the jets in the fleet. All of the menu options the user can select to do things revolve around being able to access the data within the ArrayList.

*java.io package
I utilized the FileReader and BufferedReader classes and the readLine() method within the java.io package to read in data from an outside text file. The readLine method goes line by line of the text file and parses out each piece of data. Because the text file is formatted so that each line represents the instance fields for a particular jet type, I was able to call the constructors for each type, and pass in the instance fields to instantiate new Jet objects of the correct type.

I also utilized the FileWriter and PrintWriter classes to allow users to save down the data from the current fleet of jets to a text file.

*Debugger
The debugger was absolutely essential for this project. There are several different loops that run in this program, which can become difficult to get right. The debugger allowed me to run the code to a certain breakpoint, and then go line by line to see what each statement was doing in detail.

*Loops
There are several loops in this program. While loops are used in conjunction with boolean variables in several methods to print menus for the user and allow them to continue choosing options until they quit. For loops and for each loops are also used quite often to iterate through the AirField's fleet of jets.

*Switches and Fall Through
I was able to utilize switches in a few different methods of this program. They were very useful because I knew exactly which options the user could choose for each menu that is displayed. Fall through is also intentionally utilized to capture the potential variances in input from the user.
