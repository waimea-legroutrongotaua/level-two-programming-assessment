/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   NATO Scissors Rock!
 * Project Author: LeBron Grout Rongotaua
 * GitHub Repo:    https://github.com/waimea-legroutrongotaua/level-two-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */
/**
------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------
 Game Name:
      NATO Scissors Rock!

 idea for game:

 1 base for each player (2 players)
 3 lanes with 3 different divisions for the player to put in each lane
 Artillery > Riflemen, Fortress
 Riflemen > Scouts
 Scouts > Artillery
 Special forces > Riflemen, Artillery and Scouts (only get one per game)
 fortress > Riflemen, special forces and Scouts ( replaces scout when the other player is one round from beating you
  plyr 1 losing                       Tied                        plyr 2 losing
      (1)             (2)             (3)             (4)             (5)
   last stand                                                      last stand
   gain fort                                                        gain fort

 if player 1 wins 1 battle and loses 2 at round (3) it will move to round (2) and if player 1 wins 3 battles and loses none then if
 at round (2) moves it back to tied at round (3)
 if player 1 loses at round (1) player 2 wins and the games over
 if both players play the same options in the same lanes the or they both win one and tie on one they tie
 and the round they were on restarts
  Scouts:
       ==========
            //
          //
       ==========

  Riflemen:
       ==========
          \\//
          //\\
       ==========

  Artillery:
       ==========
          //\\
          \\//
       ==========

  Special Forces:
       ==========
          SPEC
          //\\
       ==========

  Fortress:
       ==========
         ||--||
         ||  ||
       ==========
  lane:
       ==========     ==========      ==========
       |\     \1|     |\     \2|      |\     \3|
       |1\     \|     |2\     \|      |3\     \|
       ==========     ==========      ==========
 plan:
 ask user if they want to play, learn how to play or quit game
 if user picks quit close the game
 if user picks how to play show user a page on how to play the game and an option to go back to main menu
 if user picks play give the user the option to press enter to start game
 if user press enter ask user for there Username
 then after they have entered it show them the troops they have and ask which they would like to place in lane 1
 then remove whatever the user has picked from the list and add it to lane 1 then ask what they would like to put in row 2
 then repeat the process till all lanes are full (3 lanes) and ask the user to let the 2nd user enter there username
 after the 2nd user has entered their username and pressed enter ask them to fill there lanes with there troops like user 1
 after the 2nd user is finished ask the user to press enter to see result for battle
 after the battle their may be a winner if so the next round will be one closer to finishing the game
 the rounds will repeat till a user loses on there last stand round leading to the opposing player-
 winning and there name and wins being displayed
 it then gives the user the option to play again (restarting as if the pressed play from the main menu)
 , main menu (taking the user back to the first screen) or quit (closing the game)
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
*/
// where all the global list are used
//the players currentlly avaliable units lists
//player 1's units
val player1Units = mutableListOf<String>()
//player 2's units
val player2Units = mutableListOf<String>()
//the players unit choices for lanes lists
//player 1's lane unit choices
val player1Lane1 = mutableListOf<String>()
val player1Lane2 = mutableListOf<String>()
val player1Lane3 = mutableListOf<String>()
//player 2's lane unit choices
val player2Lane1 = mutableListOf<String>()
val player2Lane2 = mutableListOf<String>()
val player2Lane3 = mutableListOf<String>()

/**the first function which enacts the choices of the user from the
 * menu function
 */
fun main() {
    //the users action being related to the corresponding function
    val action = menu()
    when (action) {
        //startGame is the function where the game is run
        'a' -> startGame()
        //tutorial is the function which explains to the user how to play the game
        's' -> tutorial()
        //endgame closes the game
        'd' -> endGame()

    }
}
/**
 * Game Starting Menu Comes up when you start the program and gives you the option
 * to Play, Learn how to play and quit the program.
 */

    fun menu() : Char {
        println("NATO Scissors Rock! ")
        println("====================")
        println("Welcome To The Game!")
        println("====================")
        println("[A] PLAY")
        println("====================")
        println("[S] HOW TO PLAY")
        println("====================")
        println("[D] QUIT")
        //The options the user can input
        val validChoices = "asd"

        while (true) {
            print("Choice: ")

            val input = readln()
            //typed nothing try again
            if(input.isBlank()) continue
            //grab first letter
            val choice = input.lowercase().first()
            //check choice is a valid option
            if (validChoices.contains(choice)) return choice

        }
    }

/** The Function that starts the game
 * It is where the main game loop is run.
 */
    fun startGame() {
    var round = 3
    var roundName = "EMPTY"
        var player1Name = "EMPTY"
        var player2Name = "EMPTY"
    var firstRound = true
    while (round in 1..5) {
        player1Units.add("Riflemen")
        player2Units.add("Riflemen")
        player1Units.add("Scouts")
        player2Units.add("Scouts")
        player1Units.add("Artillery")
        player2Units.add("Artillery")
        if (firstRound) {
            player1Units.add("Special Forces")
            player2Units.add("Special Forces")
        }
        if (round == 1) {
            player1Units.add("Bunker")
            player1Units.remove("Scouts")
        }
        if (round == 5) {
            player2Units.add("Bunker")
            player2Units.remove("Scouts")
        }
        if (firstRound) {
            player1Name = playersName().toString()
        }
        var laneNumber = 1
        // player 1's choices for their lanes units are chosen within this while loop.
        while (true) {
            options1()
            print("Choice for lane $laneNumber: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player1Units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (player1Lane1.size == 1 && player1Lane2.size == 1 && player1Lane3.size == 0) {
                if (number == 1) {
                    player1Lane3.add(player1Units[0])
                    player1Units.removeAt(0)
                    println(player1Lane1)
                    println(player1Lane2)
                    println(player1Lane3)
                }
                if (number == 2) {
                    player1Lane3.add(player1Units[1])
                    player1Units.removeAt(1)
                    println(player1Lane1)
                    println(player1Lane2)
                    println(player1Lane3)
                }
                if (number == 3) {
                    player1Lane3.add(player1Units[2])
                    player1Units.removeAt(2)
                    println(player1Lane1)
                    println(player1Lane2)
                    println(player1Lane3)
                }
                if (number == 4) {
                    player1Lane3.add(player1Units[3])
                    player1Units.removeAt(3)
                    println(player1Lane1)
                    println(player1Lane2)
                    println(player1Lane3)
                }
                if (number == 5) {
                    player1Lane3.add(player1Units[4])
                    player1Units.removeAt(4)
                    println(player1Lane1)
                    println(player1Lane2)
                    println(player1Lane3)
                }
            }
            if (player1Lane1.size == 1 && player1Lane2.size == 0) {
                if (number == 1) {
                    player1Lane2.add(player1Units[0])
                    player1Units.removeAt(0)
                    println(player1Lane1)
                    println(player1Lane2)
                }
                if (number == 2) {
                    player1Lane2.add(player1Units[1])
                    player1Units.removeAt(1)
                    println(player1Lane1)
                    println(player1Lane2)
                }
                if (number == 3) {
                    player1Lane2.add(player1Units[2])
                    player1Units.removeAt(2)
                    println(player1Lane1)
                    println(player1Lane2)
                }
                if (number == 4) {
                    player1Lane2.add(player1Units[3])
                    player1Units.removeAt(3)
                    println(player1Lane1)
                    println(player1Lane2)
                }
                if (number == 5) {
                    player1Lane2.add(player1Units[4])
                    player1Units.removeAt(4)
                    println(player1Lane1)
                    println(player1Lane2)
                }
            }
            if (player1Lane1.size == 0) {
                if (number == 1) {
                    player1Lane1.add(player1Units[0])
                    player1Units.removeAt(0)
                    println(player1Lane1)
                }
                if (number == 2) {
                    player1Lane1.add(player1Units[1])
                    player1Units.removeAt(1)
                    println(player1Lane1)
                }
                if (number == 3) {
                    player1Lane1.add(player1Units[2])
                    player1Units.removeAt(2)
                    println(player1Lane1)
                }
                if (number == 4) {
                    player1Lane1.add(player1Units[3])
                    player1Units.removeAt(3)
                    println(player1Lane1)
                }
                if (number == 5) {
                    player1Lane1.add(player1Units[4])
                    player1Units.removeAt(4)
                    println(player1Lane1)
                }
            }
            laneNumber += 1
            if (player1Lane3.size == 1) {
                break
            }
            continue

        }
        //Barrier to prevent player 2 from cheating
        println("====================")
        println("NEXT PLAYERS TURN")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("////////////////////")
        println("||||||||||||||||||||")
        println("NEXT PLAYERS TURN")
        println("====================")
        if (firstRound) {
            player2Name = playersName().toString()
        }
        laneNumber = 1
        // player 2's choices for their lanes units are chosen within this while loop.
        while (true) {
            options2()
            print("Choice for lane $laneNumber: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player2Units.size) {
                continue

            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (player2Lane1.size == 1 && player2Lane2.size == 1 && player2Lane3.size == 0) {
                if (number == 1) {
                    player2Lane3.add(player2Units[0])
                    player2Units.removeAt(0)
                    println(player2Lane1)
                    println(player2Lane2)
                    println(player2Lane3)
                }
                if (number == 2) {
                    player2Lane3.add(player2Units[1])
                    player2Units.removeAt(1)
                    println(player2Lane1)
                    println(player2Lane2)
                    println(player2Lane3)
                }
                if (number == 3) {
                    player2Lane3.add(player2Units[2])
                    player2Units.removeAt(2)
                    println(player2Lane1)
                    println(player2Lane2)
                    println(player2Lane3)
                }
                if (number == 4) {
                    player2Lane3.add(player2Units[3])
                    player2Units.removeAt(3)
                    println(player2Lane1)
                    println(player2Lane2)
                    println(player2Lane3)
                }
                if (number == 5) {
                    player2Lane3.add(player2Units[4])
                    player2Units.removeAt(4)
                    println(player2Lane1)
                    println(player2Lane2)
                    println(player2Lane3)
                }
            }
            if (player2Lane1.size == 1 && player2Lane2.size == 0) {
                if (number == 1) {
                    player2Lane2.add(player2Units[0])
                    player2Units.removeAt(0)
                    println(player2Lane1)
                    println(player2Lane2)
                }
                if (number == 2) {
                    player2Lane2.add(player2Units[1])
                    player2Units.removeAt(1)
                    println(player2Lane1)
                    println(player2Lane2)
                }
                if (number == 3) {
                    player2Lane2.add(player2Units[2])
                    player2Units.removeAt(2)
                    println(player2Lane1)
                    println(player2Lane2)
                }
                if (number == 4) {
                    player2Lane2.add(player2Units[3])
                    player2Units.removeAt(3)
                    println(player2Lane1)
                    println(player2Lane2)
                }
                if (number == 5) {
                    player2Lane2.add(player2Units[4])
                    player2Units.removeAt(4)
                    println(player2Lane1)
                    println(player2Lane2)
                }
            }
            if (player2Lane1.size == 0) {
                if (number == 1) {
                    player2Lane1.add(player2Units[0])
                    player2Units.removeAt(0)
                    println(player2Lane1)
                }
                if (number == 2) {
                    player2Lane1.add(player2Units[1])
                    player2Units.removeAt(1)
                    println(player2Lane1)
                }
                if (number == 3) {
                    player2Lane1.add(player2Units[2])
                    player2Units.removeAt(2)
                    println(player2Lane1)
                }
                if (number == 4) {
                    player2Lane1.add(player2Units[3])
                    player2Units.removeAt(3)
                    println(player2Lane1)
                }
                if (number == 5) {
                    player2Lane1.add(player2Units[4])
                    player2Units.removeAt(4)
                    println(player2Lane1)
                }
            }
            laneNumber += 1
            if (player2Lane3.size == 1) {
                break
            }
            continue

        }
        //after units are all selected the results are calculated based on the rules of the game
        val victor = victorCheck()
        if (victor == 0) {
            round += 0
            println("====================")
            println("The round is a stalemate")
            println("====================")
        }
        if (victor > 0) {
            round += 1
            println("====================")
            println("$player1Name wins the round")
            println("====================")
        }
        if (victor < 0) {
            round -= 1
            println("====================")
            println("$player2Name wins the round")
            println("====================")
        }
        if (round == 1){
            roundName = "Last Stand"
        }
        if (round == 2){
            roundName = "Fall Back"
        }
        if (round == 3){
            roundName = "Battle"
        }
        if (round == 4){
            roundName = "Fall Back"
        }
        if (round == 5){
            roundName = "Last Stand"
        }
        if (round in 1..5) {
            println("NEXT ROUND")
        }
        if (round in 1..5) {
            if (round <= 2) {
                println("$player1Name's $roundName")
            }
            if (round >= 4) {
                println("$player2Name's $roundName")
            }
            if (round == 3) {
                println(roundName)
            }
        }
        println("====================")
        println("Press Enter to Continue")
        val continue3 = readln()
        //the list of the players' lane choices are cleared for next round
        //and if it is the end of the first round the firstRound variable is set to false as
        //it would no longer be the first round
        firstRound = false
        if (!player1Units.contains("Special Forces")) {
                player1Units.clear()
            }
        if (!player2Units.contains("Special Forces")) {
            player2Units.clear()
        }
        player1Lane1.clear()
        player1Lane2.clear()
        player1Lane3.clear()
        player2Lane1.clear()
        player2Lane2.clear()
        player2Lane3.clear()
        continue
    }
    //the round number is checked to see if any player has won the game yet
    //if they have there will be no next round and the player that won will be displayed
    if (round == 6){
        println("====================")
        println("$player1Name wins the game!")
        println("====================")
    }
    if (round == 0){
        println("====================")
        println("$player2Name wins the game!")
        println("====================")
    }
}

/**
 * This function contains Player 1's (the First player to enter their name's)
 * Available options based on the Player1Units global list.
 */
fun options1() {
    // based on the size of the unit list of player 1 (player1Units) the corresponding amount of options will be printed.
        if (player1Units.size >= 1) {
            println("====================")
            println("PRESS 1")
            println(player1Units[0])
        }
        if (player1Units.size >= 2) {
            println("====================")
            println("PRESS 2")
            println(player1Units[1])
        }
        if (player1Units.size >= 3) {
            println("====================")
            println("PRESS 3")
            println(player1Units[2])
        }
        if (player1Units.size >= 4) {
            println("====================")
            println("PRESS 4")
            println(player1Units[3])
        }
        if (player1Units.size >= 5) {
            println("====================")
            println("PRESS 5")
            println(player1Units[4])
        }
    println("====================")
}
/**
 * This function contains Player 2's (the Second player to enter their name's)
 * Available options based on the Player2Units global list.
 */
fun options2() {
    // based on the size of the unit list of player 2 (player2Units) the corresponding amount of options will be printed.
        if (player2Units.size >= 1) {
            println("====================")
            println("PRESS 1")
            println(player2Units[0])
        }
        if (player2Units.size >= 2) {
            println("====================")
            println("PRESS 2")
            println(player2Units[1])
        }
        if (player2Units.size >= 3) {
            println("====================")
            println("PRESS 3")
            println(player2Units[2])
        }
        if (player2Units.size >= 4) {
            println("====================")
            println("PRESS 4")
            println(player2Units[3])
        }
        if (player2Units.size >= 5) {
            println("====================")
            println("PRESS 5")
            println(player2Units[4])
        }
    println("====================")
    }
/**
 * This function checks and compares player 1's lane unit choice's
 * with player 2's lane unit choices. And based off the rules of the game returns
 * the checks result.
 */
fun victorCheck(): Int {
    var Check = 0
    //depending on the unit in player 1's lane it checks if weather player won's choice for the lane would beat player 2's
    //unit choice for that lane. if i twas a win for player 1 adding a point to the check or removing a point if player 1
    //loses. At the end the check will be returned as num and if num is negative player 2 wins the round if positive player 1
    //wins and if 0 the round is a tie.
    if (player1Lane1.contains("Riflemen")) {
        if (player2Lane1.contains("Special Forces")){
            Check -= 1
            }
        if (player2Lane1.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane1.contains("Artillery")){
            Check -= 1
        }
        if (player2Lane1.contains("Scouts")){
            Check += 1
        }
        if (player2Lane1.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1Lane1.contains("Scouts")) {
        if (player2Lane1.contains("Special Forces")){
            Check -= 1
        }
        if (player2Lane1.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane1.contains("Artillery")){
            Check += 1
        }
        if (player2Lane1.contains("Scouts")){
            Check -= 0
        }
        if (player2Lane1.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1Lane1.contains("Artillery")) {
        if (player2Lane1.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane1.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane1.contains("Artillery")) {
            Check -= 0
        }
        if (player2Lane1.contains("Scouts")) {
            Check -= 1
        }
        if (player2Lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane1.contains("Bunker")) {
        if (player2Lane1.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane1.contains("Bunker")) {
            Check -= 0
        }
        if (player2Lane1.contains("Artillery")) {
            Check -= 1
        }
        if (player2Lane1.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane1.contains("Special Forces")) {
        if (player2Lane1.contains("Special Forces")) {
            Check -= 0
        }
        if (player2Lane1.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane1.contains("Artillery")) {
            Check += 1
        }
        if (player2Lane1.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    //======================================================
    // check lane 2
    //======================================================
    if (player1Lane2.contains("Riflemen")) {
        if (player2Lane2.contains("Special Forces")){
            Check -= 1
        }
        if (player2Lane2.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane2.contains("Artillery")){
            Check -= 1
        }
        if (player2Lane2.contains("Scouts")){
            Check += 1
        }
        if (player2Lane2.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1Lane2.contains("Scouts")) {
        if (player2Lane2.contains("Special Forces")){
            Check -= 1
        }
        if (player2Lane2.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane2.contains("Artillery")){
            Check += 1
        }
        if (player2Lane2.contains("Scouts")){
            Check -= 0
        }
        if (player2Lane2.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1Lane2.contains("Artillery")) {
        if (player2Lane2.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane2.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane2.contains("Artillery")) {
            Check -= 0
        }
        if (player2Lane2.contains("Scouts")) {
            Check -= 1
        }
        if (player2Lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane2.contains("Bunker")) {
        if (player2Lane2.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane2.contains("Bunker")) {
            Check -= 0
        }
        if (player2Lane2.contains("Artillery")) {
            Check -= 1
        }
        if (player2Lane2.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane2.contains("Special Forces")) {
        if (player2Lane2.contains("Special Forces")) {
            Check -= 0
        }
        if (player2Lane2.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane2.contains("Artillery")) {
            Check += 1
        }
        if (player2Lane2.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    //======================================================
    // check lane 3
    //======================================================
    if (player1Lane3.contains("Riflemen")) {
        if (player2Lane3.contains("Special Forces")){
            Check -= 1
        }
        if (player2Lane3.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane3.contains("Artillery")){
            Check -= 1
        }
        if (player2Lane3.contains("Scouts")){
            Check += 1
        }
        if (player2Lane3.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1Lane3.contains("Scouts")) {
        if (player2Lane3.contains("Special Forces")){
            Check -= 1
        }
        if (player2Lane3.contains("Bunker")){
            Check -= 1
        }
        if (player2Lane3.contains("Artillery")){
            Check += 1
        }
        if (player2Lane3.contains("Scouts")){
            Check -= 0
        }
        if (player2Lane3.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1Lane3.contains("Artillery")) {
        if (player2Lane3.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane3.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane3.contains("Artillery")) {
            Check -= 0
        }
        if (player2Lane3.contains("Scouts")) {
            Check -= 1
        }
        if (player2Lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane3.contains("Bunker")) {
        if (player2Lane3.contains("Special Forces")) {
            Check -= 1
        }
        if (player2Lane3.contains("Bunker")) {
            Check -= 0
        }
        if (player2Lane3.contains("Artillery")) {
            Check -= 1
        }
        if (player2Lane3.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1Lane3.contains("Special Forces")) {
        if (player2Lane3.contains("Special Forces")) {
            Check -= 0
        }
        if (player2Lane3.contains("Bunker")) {
            Check += 1
        }
        if (player2Lane3.contains("Artillery")) {
            Check += 1
        }
        if (player2Lane3.contains("Scouts")) {
            Check += 1
        }
        if (player2Lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    val num = Check
    return num
}
/**
 * This function asks for the users name.
 */
fun playersName(): String? {
    println("====================")
    println("What is your name?")
    println("====================")
    val name = readlnOrNull()
    return name
}
/**
 * This Function That tells you how to play the game.
 */
fun tutorial() {
    println("Welcome To NATO Scissors Rock!")
    println("This game is a 2 player 5 round")
    println("Rock paper scissors like game")
    println("but you have 3 lanes and")
    println("5 possible units to play")
    println("These units are...")
    println("====================")
    println("PRESS ENTER TO CONTINUE")
    println("====================")
    val Continue = readln()
    println("Riflemen:")
    println("Riflemen when played in the same lane will as scouts will win")
    println("==========")
    println("   ||||   ")
    println("   ||||   ")
    println("==========")
    println("Scouts:")
    println("Scouts when played in the same lane as Artillery will win")
    println("==========")
    println("   ////   ")
    println("   ////   ")
    println("==========")
    println("Artillery:")
    println("Artillery when played in the same lane as Riflemen will win")
    println("==========")
    println("   ||||   ")
    println("   ////   ")
    println("==========")
    println("there are also two special units...")
    println("====================")
    println("PRESS ENTER TO CONTINUE")
    println("====================")
    val Continue2 = readln()
    println("Fortress:")
    println("Fortress when played in the same lane as Riflemen or Scouts will win but only appears in a players last stand round")
    println("==========")
    println("   |==|   ")
    println("   ||||   ")
    println("==========")
    println("Special Forces:")
    println("Special Forces when played in the same lane as Any unit will win but each side only gets one per game")
    println("==========")
    println("   SPEC   ")
    println("   ////   ")
    println("==========")
    println("====================")
    println("PRESS ENTER TO CONTINUE")
    println("====================")
    println("Lanes:")
    println("Each player will take turns putting 1 unit in each of the 3 lanes")
    println("       ==========     ==========      ==========")
    println("       |       1|     |       2|      |       3|")
    println("       |1       |     |2       |      |3       |")
    println("       ==========     ==========      ==========")

}
/**
 * The Function that ends the game and is used if the user picks option d ( (D) quit ) at the menu.
 */
fun endGame() {
    //Thank the player for playing
    println("=====================================")
    println("          Thanks for playing         ")
    println("=====================================")
}
//End of code