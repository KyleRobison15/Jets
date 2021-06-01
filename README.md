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
*ArrayList Data Structure
*FileIO
*Debugger
*Loops
