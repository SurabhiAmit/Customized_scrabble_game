# Use Case Model

**Author**: Surabhi Amit Chembra

## 1 Use Case Diagram

![Use case diagram](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/UseCaseDiagram.pdf)

## 2 Use Case Descriptions

### Play Game Turn

 * **Requirements**: This use case allows the user to place a game turn.
 * **Pre-conditions**: The game should be in “Started” state and not yet Finished/Stopped.  
 * **Post-conditions**: Either a word is formed on the rack, or the rack letters are swapped, or the pool is empty.  
 * **Scenarios**: The player starts a game or finishes the previous turn. The game checks the current turn number and makes sure that it is below the maximum number of turns. If yes, then, allows the player to play the turn.
 ![Play game turn](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_PlayGameTurn.pdf)
 
 ### Set Word on Board

 * **Requirements**: The player sets the word on the board using a board letter and rack letters.  
 * **Pre-conditions** The player must start a game turn and the current turn number should be less than the maximum turn count.  
 * **Post-conditions**: A word will be formed on the board using a board letter and the rest as rack letters.  
 * **Scenarios**: The player chooses a board letter in a turn, picks up rack letters and place on board squares such that a meaningful word is formed. This word is checked against the used words list to make sure that a word is not repeated in the game. Now, if the word was used earlier in the same game, it is not considered as a word formed and the player has to find another word to form. If the word was not used earlier in the same game, the word formation is considered as a turn, and a letter in the word other than the board letter replaces the board letter in the word for the next turn. 
![Set_word_on_board](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_SetWordOnBoard.pdf)

### Swap Letters

 * **Requirements**: The player swaps the rack letters with the pool letters.  
 * **Pre-conditions**: The player must start a game turn and the current turn number should be less than the maximum turn count.  
 * **Post-conditions**: A word could not be formed on the board using a board letter and the rest as rack letters.  
 * **Scenarios**: The player puts the rack letters into the pool, and puts the letters from the pool into the rack, thus swapping the rack letters with the pool letters.
 ![Swap letters](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_SwapLetters.pdf)

### Update score and statistics

 * **Requirements**: The game score, letter statistics and word bank are updated as required.  
 * **Pre-conditions**: The player must have just finished a game turn.  
 * **Post-conditions**: The score and statistics would be updated for the game turn.  
 * **Scenarios**: After each game turn, the game score of the statistics tab is updated. For the letters played or traded in the turn, the letter statistics are updated. For the words played in the game, the word count statistics in word bank are also updated.
 ![Update score and statistics](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_UpdateScoreAndStatistics.pdf)

### Adjust Game Settings

 * **Requirements**: This use case allows the user to adjust the game settings like maximum number of turns, number of and letter points for each pool letter.  
 * **Pre-conditions**: The number of and letter points for each pool letter is either English Scrabble distribution by default or user-adjusted.  
 * **Post-conditions**: The maximum number of turns, number of and letter points for each pool letter are adjusted as required.  
 * **Scenarios**: The user can adjust the count of tiles for any letter, the points for a letter and the maximum number of turns for the game.
 ![Adjust game settings](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_AdjustGameSettings.pdf)

### View Statistics

 * **Requirements**: The player sees the game score statistics, letter statistics and word bank.  
 * **Pre-conditions**: The player must specify which statistics to show.  
 * **Post-conditions**: The specified statistics will be displayed after appropriate data retrieval and calculations.  
 * **Scenarios**: The player logs in and access the Statistics Tab to select which type of statistics to see and click on it thus getting forwarded to the specific use case for the type of statistic selected.
 ![View_statistics](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_ViewStatistics.pdf)

### View Game Score Statistics

 * **Requirements**: The player accesses the game score statistics.  
 * **Pre-conditions**: The player must specify the game for which the score statistics has to be displayed.  
 * **Post-conditions**: The score statistics for the specified game will be displayed after appropriate data retrieval and calculations.  
 * **Scenarios**: The logged-in player sends the request to Statistics tab to access the game score. 
 ![View game score statistics](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_ViewGameScoreStatistics.pdf)

### View Letter Statistics

 * **Requirements**: The player accesses the letter statistics.  
 * **Pre-conditions**: The player must specify the letter for which the letter statistics has to be displayed.  
 * **Post-conditions**: The score statistics for the specified letter will be displayed after appropriate data retrieval and calculations.  
 * **Scenarios**: The logged-in player sends the request to Statistics to access the letter statistics.
 ![View letter statistics](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_ViewLetterStatistics.pdf)

### View Word Bank Statistics

 * **Requirements**: The player accesses the word bank statistics.  
 * **Pre-conditions**: The player must specify that he wants to access word bank statistics.  
 * **Post-conditions**: The word bank statistics will be displayed after appropriate data retrieval and calculations.  
 * **Scenarios**: The logged-in player sends the request to Statistics to access the word bank statistics.
 ![View word bank statistics](https://github.gatech.edu/gt-omscs-se-2019fall/6300Fall19Team115/blob/master/GroupProject/Docs/SequenceDiagram_ViewWordBankStatistics.pdf)


