NotePad/
├── NotePad.java          # Main application class
├── README.md            # Project documentation
└── (compiled .class files after compilation)



# Simple NotePad

## Project Overview
A simple text editor application built with Java Swing that provides basic text editing functionality with file operations.

## System Requirements
- *Java Development Kit (JDK) 17 or higher
- *Any operating system that supports Java Swing


## Limitation
- Basic text editing functionality without advanced features like find/replace, formatting, or undo/redo
- No support for multiple documents (single document interface)
- Limited error handling for very large files

## Future Enhancements
Potential improvements for this application could include:
-  Text Editing: Basic text editing with a scrollable text area
-  File Operations: Open, save, and create new text files
-  User-Friendly Interface: Clean and intuitive GUI with menu navigation
-  Error Handling: Informative error messages for file operations

## Installation
- Clone or download the project files
- Navigate to the project directory

### Navigate to the project directory
## Using Command Line:
# Compile the Java file
javac NotePad.java

# Run the application
java NotePad

## Using an IDE:
- Open the project in your preferred Java IDE (Eclipse, IntelliJ IDEA, NetBeans)
- Build the project
- Run the NotePad class

### Usage
## Creating a New File
The application starts with a blank document. Simply begin typing to create a new file.

## Opening a File
- Click on the "File" menu
- Select "Open" from the dropdown
- Choose a text file from the file chooser dialog
- The content will be loaded into the text area

## Saving a File
- Click on the "File" menu
- Select "Save" from the dropdown
- Choose a location and filename in the file chooser dialog
- The content will be saved to the selected file

## Exiting the Application
- Click on the "File" menu
- Select "Exit" from the dropdown

### Project Structure
NotePad/
├── NotePad.java          # Main application class
├── README.md            # Project documentation
└── (compiled .class files after compilation)


### Code Overview
## Main Class: NotePad - Sets up the GUI and functionality
## Action Handlers:
- OpenAction - Handles file opening operations
- SaveAction - Handles file saving operations
## UI Components:
- JTextArea - For text editing
- JMenuBar and JMenuItems - For menu operations
- JFileChooser - For file selection dialogs







