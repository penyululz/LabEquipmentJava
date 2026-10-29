# Lab Equipment Tracking System

A standalone Java console program demonstrating seven private attributes,
two constructors, seven getters, seven setters and three additional operations.
Main.java demonstrates objects, loops, if/else selection and attribute changes.
The equipment records are fictional. No external libraries are required.

## Run on Windows

1. Extract the project ZIP.
2. Open the extracted LabEquipmentJava folder.
3. Double-click run.bat. The Java Development Kit must be installed.
4. The output window stays open until you press a key.

## Run in a Java editor

Create a Java project, add LabAsset.java and Main.java to the same source
folder without a package declaration, and run Main.java.

## Run in a terminal

Open a terminal in this folder:

```text
mkdir build
javac -d build LabAsset.java Main.java
java -cp build Main
```

Skip mkdir if build already exists. Use a JDK version 8 or later.

## Report screenshot

Run the program and capture the console output. Scroll up for the equipment
details and down for the final summary. Insert the screenshots in the report's
Program Output and Results section. sample-output.txt contains a captured run.

Expected final results: 3 records, 4 units, 2 checked working units,
2 maintenance units, 0 unverified units, inventory value RM 8400.00.
