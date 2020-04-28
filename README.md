# User Manual: SingleScrabbler

SingleScrabbler is an Android application designed for word game lovers who enjoy single player mode. It is built using java, XML to create android layout files on pixel 2 phone and database persistence was employed on SQLite database so that players can return to their unfinished games.

## Getting Started

As you open your application, you will be brought to a *Menu View* where you will have the option to select among either starting a new game, updating the settings, or viewing game statistics.

<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/menuActivity.PNG" width="140" height="200" />

## How To

### Settings
 * Update *Max # of Turns* to modify the number of turns you would like to have during the game.
	- The *Max # of Turns* should be greater than 0 and up to 1000.
 * Choose from the *Letter* dropdown menu to update the *Count* and *Score* for each letter in the game.
	- The *Count* value per letter should be a number between 1 and 20, inclusive.
	- The *Points* value per letter should be a number between 0 and 100, inclusive.
 * Click on the **Save** button in order to save your new preferences. Everytime you wish to change a letter's count and points make sure to click on **Save** button; otherwise, it will not get recorded. If a settings change is made in the middle of a game, the effects will take place from the next new game onwards only.
 * **Note:** The default settings contain 100 letter tiles with the following distribution:
	- 2 blank tiles (scoring 0 points)
	- 1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4
	- 2 points: D ×4, G ×3
	- 3 points: B ×2, C ×2, M ×2, P ×2
	- 4 points: F ×2, H ×2, V ×2, W ×2, Y ×2
	- 5 points: K ×1
	- 8 points: J ×1, X ×1
	- 10 points: Q ×1, Z ×1

	The total number of points is 187.

As cited in: 

![English Scrabble](https://en.wikipedia.org/wiki/Scrabble_letter_distributions)

<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/settingsActivity.PNG" width="140" height="200"/>

### Statistics
The statistics menu will give you three options to choose from:
 * Score Statistics
 	- To view a list of scores, in descending order by final game score, displaying:
		* The final game score
		* The number of turns in that game
		* The average score per turn
		The player may select any of the game scores to view the settings for that game’s maximum number of turns, letter distribution, and letter points.
		
<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/gameScoreStatsActivity.PNG" width="140" height="200"/>

Clicking on any game score would take the user to the settings of letter counts and points pertaining to that game.

<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/statsSettingsActivity.PNG" width="140" height="200"/>

 * Letter Statistics
 	- To view the list of letters, in ascending order by number of times played, displaying:
		* The total number of times that letter has been played in a word
		* The total number of times that letter has been traded back into the pool
		* The percentage of times that the letter is used in a word, out of the total number of times it has been drawn
<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/letterStatActivity.PNG" width="140" height="200"/>
 * Word Bank
 	- The player will view the list of words used, starting from the most recently played, 	displaying:
		* The word
		* The number of times the word has been played
		
<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/wordbankActivity.PNG" width="140" height="200"/>

### Game
* The game will initiate with 7 letters in your rack and 4 letters in the board.
* Clicking on the ? button on the top right hand side of the screen will show the instructions on how to play the game.

<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/Instructions.PNG" width="140" height="200"/>

* In each turn, the player can either form a word or swap letters from the rack with the pool letters.
* When forming a word, the user needs to select at least one letter from the board and must not repeat any words already utilized in the same game. If the word is written incorrectly, the user can tap the delete button to remove the last letters selected. Once the word has been formed, the board letter used in the formed word will be randomly replaced with one of the rack letters used in the word formed, and the total points will be increased accordingly. The turn count will also be incremented by one.
* When swapping rack letters, the user utilizes his or her turn to switch letters from the rack with letters from the pool.
<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/gameActivity.PNG" width="140" height="200"/>

## End Game
* The game ends when either of the following happens:
	- The pool is empty. (10 additional points will be added to the total score!)
	- The number of turns has reached its maximum value.
<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/finishedGameActivity.PNG" width="140" height="200"/>

## Return to game
* If a user had to stop the game in the middle, he can always return to the unfinished game.

<img src="https://github.com/SurabhiAmit/Customized_scrabble_game/blob/master/Docs/returnActivity.PNG" width="140" height="200"/>

Words6300 folder has the project code and Docs folder has the documentations.
