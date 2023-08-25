											***GuessingNumberGame v1.0_BETA;***

Guessing game programmed in java in NetBeans IDE.


Operation:

Basically, the game consists of guessing a randomly generated number within a specific range, according to the selected level.
for each wrong result, a simple hint is generated, providing the user with a direction.


Levels:
	-If the selected level is easy, a random number from 0 to 100 will be generated;
	-If the selected level is intermediate, a random number from 0 to 200 will be generated;
	-If the selected level is difficult, a random number from 0 to 500 will be generated;
	-If the selected level is veteran, a random number from 0 to 1000 will be generated;
	-And if the selected level is Custom, the user will need to configure the level before starting a custom game;
	 |
	  -If the user does not configure a level, the game will not start due to lack of basic data to run the custom level engine.


Project Status:

The game is still going through some improvements. This version will be Beta, as the menu interface file is very overloaded.
With that in mind, I'm going to split some options into other class files so that the overall app performs slightly better at runtime.

I'm releasing this version here for backup purposes, as the next improvements I make to the game will be complex and abrupt, and I don't know how well the game will adapt to the changes. So I leave here this functional version for possible future clones.

If the implementations (not only these, but also the future ones) work out, I will constantly update the project here so that it always has a better and functional version.

I'll keep your version in 1.0 BETA for now...


Test Yourself:

-to clone this repository on your machine, use the following command in your linux terminal, termux or windows cmd:

	git clone https://github.com/GrimReaper3223/GuessingNumberGame-v1.0-BETA

***I will also be leaving a .jar executable for those who want to run it directly in the terminal or in cmd.

-the syntax to run this game in the terminal is just below:
	
	-linux & termux:
		
		java -jar GuessingNumberGame-1.0_BETA.jar

	-for windows users, the folder comes with a .bat script that executes the same code above, just by double clicking on it.


Final Considerations:
	---NOTE: as it is a beta version with some things that may weigh down its execution, stutters may occur in the application when calling certain functions (probably nothing that you may notice strange);

I hope you enjoy! :)
