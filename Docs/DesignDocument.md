# Design Document

**Author**: Esther D. Rios Lopez

## 1 Design Considerations

### 1.1 Assumptions

* It is assumed that the users of the application own a smartphone with an Android native operating system.
* The user must be familiar with utilizing a smartphone device and understanding basic icon meanings, such as “?” or “i” for questions and information on the rules of the game.
* The device must have enough storage to store game statistics data and basic preferences.
* The user can recognize that the game is single player.
* Understanding with few instructions on how to modify the game settings or preferences.
* While the user is playing the game, it is assumed the player always enters real words that are spelled correctly.
* It is assumed that the user will view last 9 game scores in the score statistics view, but all game data is saved in the database and the best score shown on the score statistics is the best score of all of the games. 

### 1.2 Constraints

* Users:
	- Smartphone must have a minimum internal storage available of 30 MB.
* Developers:
	- The game application must be ready in 3 weeks.
	- The application will be constructed utilizing Android Studio 3.0 or later versions, for reasons of faster programming and testing.
	- The computing devices used for development need to have 2 GB RAM minimum, 400 MB hard disk space plus at least 1 GB for Android SDK, emulator system images, and caches.
	- The application development team is to have Java JDK Version 11 or 12.
	- The budget for the development team is limited; hence, each software engineer will take care individually of being responsible for problems encountered and have a backup development device in case of unexpected malfunctions.

### 1.3 System Environment

* Application users’ device must have Android OS with minimum version being Marshmallow (version 6.0).
* Android device internal storage must be of at least 30 MB.
* There shall be a single system running the application.

## 2 Architectural Design

### 2.1 Component Diagram

![Component Diagram](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/ComponentDiagram.pdf)

### 2.2 Deployment Diagram

![Deployment Diagram](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/DeploymentDiagram.pdf)

## 3 Low-Level Design

### 3.1 Class Diagram

![Class Diagram](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/ClassDiagram.pdf)

### 3.2 Other Diagrams

![Activity Diagram](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/ActivityDiagram.pdf)

## 4 User Interface Design

![GUI Wireframes](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/UserInterfaceDesign.pdf)
