# GuessingNumberGame-v1.0_BETA

Project version specifications: 

<br>

![Version](https://img.shields.io/badge/Version-1.0__BETA-red)  ![Version Status](https://img.shields.io/badge/Version_Status-unstable-red)
![GitHub repo size](https://img.shields.io/github/repo-size/GrimReaper3223/GuessingNumberGame-v1.0-BETA)  ![MAINTAIN](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
  <hr>
  
  OS that run this project: 

<br>

![OS](https://img.shields.io/badge/Debian-A81D33?style=for-the-badge&logo=debian&logoColor=white) ![OS 2](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) ![OS 3](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white) 
<hr>

  Skill and IDE: 

<br>

![Skiil](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![IDE](https://img.shields.io/badge/apache%20netbeans-1B6AC6?style=for-the-badge&logo=apache%20netbeans%20IDE&logoColor=white) 
<hr>

 Supported terminals: 

<br>

![TERM](https://img.shields.io/badge/GNU%20Bash-4EAA25?style=for-the-badge&logo=GNU%20Bash&logoColor=white) ![TERM 2](https://img.shields.io/badge/tmux-1BB91F?style=for-the-badge&logo=tmux&logoColor=white) 
<hr>

 Please review my project and provide me with feedback if needed. 

<br>

 ![FEEDBACK](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)
<hr>

							---Documentation---

<hr>
						
Operation:

Basically, the game consists of guessing a randomly generated number within a specific range, according to the selected level.
For each wrong result, a simple hint is generated, providing the user with a direction.

<hr>

***Levels:***

 - If the selected level is easy, a random number from 0 to 100 will be generated;
 - If the selected level is intermediate, a random number from 0 to 200 will be generated;
 - If the selected level is difficult, a random number from 0 to 500 will be generated;
 - If the selected level is veteran, a random number from 0 to 1000 will be generated;
 - And if the selected level is Custom, the user will need to configure the level before starting a custom game;
	|
	--- If the user does not configure a level, the game will not start due to lack of basic data to run the custom level engine.

<hr>

***Project Status***

The game is still going through some improvements. This version will be **Beta**, as the menu interface file is very overloaded.
With that in mind, I'm going to split some options into other class files so that the overall app performs slightly better at runtime.

I'm releasing this version here for backup purposes, as the next improvements I make to the game will be complex and abrupt, and I don't know how well the game will adapt to the changes. So I leave here this functional version for possible future clones.

If the implementations (not only these, but also the future ones) work out, I will constantly update the project here so that it always has a better and functional version.

I'll keep your version in **1.0_BETA** for now...

<hr>

***Test Yourself:***

--- To clone this repository on your machine, use the following command in your linux terminal, termux or Windows cmd:

    git clone https://github.com/GrimReaper3223/GuessingNumberGame-v1.0-BETA

--- I will also be leaving a .jar executable for those who want to run it directly in the terminal or in cmd.

--- The syntax to run this game in the terminal is just below:

**Note: To run the projects through the terminal, enter the 'target' folder and execute the commands below* 
	
<hr>

**Linux & Termux:**
		
    java -jar GuessingNumberGame-1.0_BETA.jar

<hr>

**Windows:**

For Windows users, the folder comes with a .bat script that executes the same code above, just by double clicking on it.

<hr>

--- Both files (.jar and .bat) will be in the following directory:

	GuessingNumberGame-v1.0_BETA/target/

<hr>

***Final Considerations:***

---**NOTE:** as it is a beta version with some things that may weigh down its execution, stutters may occur in the application when calling certain functions (probably nothing that you may notice strange);

I hope you enjoy! :)
