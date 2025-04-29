# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Test the lanes work

I want to test that when a unit is placed in a lane the unit is kept there
### Testing the lanes

I will run the game multiple times to see if the information the player inputs is kept and used properly by the program

### Expected Test Result

I hope to see the unit in the lane kept as what is picked by the player

---

## Test the units work properly

I want to test the units and that they beat the opposing units they are meant to lose to and win against the opposing units they are supposed to
### Test Data To Use

I will run the game multiple times with different battles with units against other units
### Expected Test Result
I hope to see that the units are consistently winning and losing when they should, and they can only be placed once in each round

---


## Test that the menu works as expected

I want to test that the main menu allows you to pick to start the game learn how to play and quit
### Testing the main menu options

I will go through the menu testing the input and invalid inputs as well to make sure it can handle it

### Expected Test Result

I hope to see that the menu can handle invalid inputs and gives the player the option to correct their mistake and doesn't crash when faced with invalid inputs

---


## Test that players can win the game

I want to test that the game allows you to win when you are meant to
### Testing what happens when the win conditions are meet

I will go through the game setting up a win for a player then seeing what results from it

### Expected Test Result

I hope to see that when a player has met their win condition (winning on the players last stand round) that the game registers that they won
