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
// where all the functions are used
fun main() {
    val action = menu()
    when (action) {
        'a' -> startGame()
        's' -> tutorial()
        'd' -> endGame()

    }
}
    //Game Starting Menu Comes up when you start the game
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
//    a == "" && b == "" ->
//fun(choice: ) : Boolean {}
//    return when {
//
//    }
// The Function that starts the game
fun startGame() {
    val player1units = mutableListOf<String>()
    val player2units = mutableListOf<String>()
    val player1lane1 = mutableListOf<String>()
    val player1lane2 = mutableListOf<String>()
    val player1lane3 = mutableListOf<String>()
    val player2lane1 = mutableListOf<String>()
    val player2lane2 = mutableListOf<String>()
    val player2lane3 = mutableListOf<String>()
    var firstround = true
    player1units.add("Riflemen")
    player2units.add("Riflemen")
    player1units.add("Scouts")
    player2units.add("Scouts")
    player1units.add("Artillery")
    player2units.add("Artillery")
    player1units.add("Special Forces")
    player2units.add("Special Forces")
    if (player1lane1.isEmpty()) {
        println("Hello Player 1!")
        println("What is your name?")
        println("Name:")
        var player1name = readln()
        println(player1name)
    }

}
// The Function That tells you how to play the game
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
        var Continue = readln()
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
        println("Riflemen when played in the same lane as Riflemen will win")
        println("==========")
        println("   ||||    ")
        println("   ////   ")
        println("==========")
        println("there are also two special units...")
        println("====================")
        println("PRESS ENTER TO CONTINUE")
        println("====================")
        var Continue2 = readln()
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

// The Function that ends the game
    fun endGame() : Char {
        //Thank the player for playing
        println("=====================================")
        println("          Thanks for playing      ")
        println("=====================================")
    return 'A'
    }



