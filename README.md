# Battleship
Based around the original board game Battleship, created by Hasbro.

Originally developed in the Summer of 2022, this was a side project that I've used to keep up my Java skills, with a strong emphasis on Object Orientation.

Click [here](https://www.youtube.com/watch?v=aQdkfcBG9o4) to watch a demo!

## Getting Started
These instructions provide a basic method for you to get Battleship running on your own machine!

### Prequisities
* This Game was developed using Java 10, and has not been tested on any other version of the language.
* Rather than porting the source code into an IDE, the best experience is when running the game using your terminal of choice.
* Another person to play along with!

### Installing
Firstly, clone this repo to your local machine using `https://github.com/nmstory/Battleship`

Next, open your terminal of choice and navigate to the directory with the source code.

```
javac *.java
```
This will allow you to compile the code with your pre-installed version of Java.

```
java Play
```
This will initialise the Battleship game and run.

### Features
- Being able to place a variety of sized ships on an 8x8 grid, either horizontally or vertically
  - Initial check if the proposed location will fit on the grid
  - Every spot is checked for collisions (does another ship already exist there?)
- Turn based system
  - Displaying the players current grid (how well the enemy is doing) and the grid the players is attacking
  - The grid being attacked is masked with question marks, as the players makes their way through the game uncovering grid spots
  - Checking whether a player has won yet
- Exception handling
  - If the player wants to hit a spot that's outside the 8x8 grid
  - If the player enters false data for the row/column locations

## What's the basic structure of the Game?
1. The core of the game is the GridSpot with 3 attributes (hit, occupied and hidden).

2. On top of that is a GridRow. This class has a linked list of type GridSpot, whereby 8 GridSpots make a GridRow.

3. Above that is the Grid. This class has a linked list of type GridRow, whereby 8 GridRows make a Grid.

This structure, combined with the power of Object Orientation in Java makes it very simple to develop any grid-based game.

- For instance to be able to place a ship of size 5 thats horizontal at position [row = 1, column = 1]:
  - Iterate through the linked list on the Grid for the first GridRow
  - Then iterate through that GridRow, starting from 1 (up to 6) setting each GridSpot as occupied.
- When placing a ship of size 3 thats vertical at position [row = 2, column = 2]:
  - Iterate through the linked list on the Grid for the second GridRow, and assign its second GridSpot as occupied
  - We do this again as we move through the GridRow's in Grid


## The next version?
Whilst the current version does represent the complete game of Battleship, there's always more that could be done:
* Using the Java Swing framework to develop an interactive GUI.
* Remove the requirement of a second player by creating an AI.

## Contact
Feel free to contact me through my main email: `nathanmstory@gmail.com`
