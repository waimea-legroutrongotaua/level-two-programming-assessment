/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: LeBron Grout Rongotaua
 * GitHub Repo:    https://github.com/waimea-legroutrongotaua/level-two-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
// Game Name:
//      NATO Scissors Rock!
//
// idea for game:
//
// 1 base for each player (2 players)
// 3 lanes with 3 different divisions for the player to put in each lane
// Artillery > Riflemen, Fortress
// Riflemen > Scouts
// Scouts > Artillery
//Special forces > Riflemen, Artillery and Scouts (only get one per game)
// fortress > Riflemen, special forces and Scouts ( replaces scout when the other player is one round from beating you
//  plyr 1 losing                       Tied                        plyr 2 losing
//      (1)             (2)             (3)             (4)             (5)
//   last stand                                                      last stand
//   gain fort                                                        gain fort
//
//if player 1 wins 1 battle and loses 2 at round (3) it will move to round (2) and if player 1 wins 3 battles and loses none then if
// at round (2) moves it back to tied at round (3)
// if player 1 loses at round (1) player 2 wins and the games over
//if both players play the same options in the same lanes the or they both win one and tie on one they tie
//and the round they were on restarts
//  Scouts:
//       ==========
//            //
//          //
//       ==========
//
//  Riflemen:
//       ==========
//          \\//
//          //\\
//       ==========
//
//  Artillery:
//       ==========
//          //\\
//          \\//
//       ==========
//
//  Special Forces:
//       ==========
//          SPEC
//          //\\
//       ==========
//
//  Fortress:
//       ==========
//         ||--||
//         ||  ||
//       ==========
//  lane:
//       ==========     ==========      ==========
//       |\     \1|     |\     \2|      |\     \3|
//       |1\     \|     |2\     \|      |3\     \|
//       ==========     ==========      ==========
// plan:
// ask user if they want to play, learn how to play or quit game
// if user picks quit close the game
// if user picks how to play show user a page on how to play the game and an option to go back to main menu
// if user picks play give the user the option to press enter to start game
// if user press enter ask user for there Username
// then after they have entered it show them the troops they have and ask which they would like to place in lane 1
// then remove whatever the user has picked from the list and add it to lane 1 then ask what they would like to put in row 2
// then repeat the process till all lanes are full (3 lanes) and ask the user to let the 2nd user enter there username
// after the 2nd user has entered their username and pressed enter ask them to fill there lanes with there troops like user 1
// after the 2nd user is finished ask the user to press enter to see result for battle
// after the battle their may be a winner if so the next round will be one closer to finishing the game
//the rounds will repeat till a user loses on there last stand round leading to the opposing player-
// winning and there name and wins being displayed
// it then gives the user the option to play again (restarting as if the pressed play from the main menu)
// , main menu (taking the user back to the first screen) or quit (closing the game)
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
fun main(){

}

fun main_menu() {
    println("NATO Scissors Rock! ")
    println("====================")
    println("Welcome To The Game!")
    println("====================")
    println("[A] PLAY")
    println("====================")
    println("[S] HOW TO PLAY")
    println("====================")
    println("[D] QUIT")
    val ValidChoices = asd

    while (True) {
        print("Choice: ")

        val input = readln()
        //typed nothing try again
        if(input.isBlank()) continue
        //grab first letter
        val choice = input.lowercase().first()
        //check choice is a valid option
        if (ValidChoices.contains(choice)) return choice

        }

    }

}

