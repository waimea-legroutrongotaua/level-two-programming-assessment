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
// where all the global list are used
//the players currentlly avaliable units lists
//player 1's units
val player1units = mutableListOf<String>()
//player 2's units
val player2units = mutableListOf<String>()
//the players unit choices for lanes lists
//player 1's lane unit choices
val player1lane1 = mutableListOf<String>()
val player1lane2 = mutableListOf<String>()
val player1lane3 = mutableListOf<String>()
//player 2's lane unit choices
val player2lane1 = mutableListOf<String>()
val player2lane2 = mutableListOf<String>()
val player2lane3 = mutableListOf<String>()
//the first function which enacts the choices of the user from the menu function (line 115)
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
// The Function that starts the game
    fun startGame() {
    var round = 3
    var roundName = "EMPTY"
        var player1name = "EMPTY"
        var player2name = "EMPTY"
    var firstround = true
    while (round < 6 && round > 0) {
        player1units.add("Riflemen")
        player2units.add("Riflemen")
        player1units.add("Scouts")
        player2units.add("Scouts")
        player1units.add("Artillery")
        player2units.add("Artillery")
        if (firstround == true) {
            player1units.add("Special Forces")
            player2units.add("Special Forces")
        }
        if (round == 1){
            player1units.add("Bunker")
            player1units.remove("Scouts")
        }
        if (round == 5){
            player2units.add("Bunker")
            player2units.remove("Scouts")
        }
        if (firstround == true) {
            player1name = playersName().toString()
        }
        options1()
        while (true) {
            print("Choice for lane 1: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player1units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player1lane1.add(player1units[0])
                player1units.removeAt(0)
                println(player1lane1)
            }
            if (number == 2) {
                player1lane1.add(player1units[1])
                player1units.removeAt(1)
                println(player1lane1)
            }
            if (number == 3) {
                player1lane1.add(player1units[2])
                player1units.removeAt(2)
                println(player1lane1)
            }
            if (number == 4) {
                player1lane1.add(player1units[3])
                player1units.removeAt(3)
                println(player1lane1)
            }
            if (number == 5) {
                player1lane1.add(player1units[4])
                player1units.removeAt(4)
                println(player1lane1)
            }
            break
        }
        options1()
        while (true) {
            print("Choice for lane 2: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player1units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player1lane2.add(player1units[0])
                player1units.removeAt(0)
                println(player1lane1)
                println(player1lane2)
            }
            if (number == 2) {
                player1lane2.add(player1units[1])
                player1units.removeAt(1)
                println(player1lane1)
                println(player1lane2)
            }
            if (number == 3) {
                player1lane2.add(player1units[2])
                player1units.removeAt(2)
                println(player1lane1)
                println(player1lane2)
            }
            if (number == 4) {
                player1lane2.add(player1units[3])
                player1units.removeAt(3)
                println(player1lane1)
                println(player1lane2)
            }
            if (number == 5) {
                player1lane2.add(player1units[4])
                player1units.removeAt(4)
                println(player1lane1)
                println(player1lane2)
            }
            break
        }
        options1()
        while (true) {
            print("Choice for lane 3: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player1units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player1lane3.add(player1units[0])
                player1units.removeAt(0)
                println(player1lane1)
                println(player1lane2)
                println(player1lane3)
            }
            if (number == 2) {
                player1lane3.add(player1units[1])
                player1units.removeAt(1)
                println(player1lane1)
                println(player1lane2)
                println(player1lane3)
            }
            if (number == 3) {
                player1lane3.add(player1units[2])
                player1units.removeAt(2)
                println(player1lane1)
                println(player1lane2)
                println(player1lane3)
            }
            if (number == 4) {
                player1lane3.add(player1units[3])
                player1units.removeAt(3)
                println(player1lane1)
                println(player1lane2)
                println(player1lane3)
            }
            if (number == 5) {
                player1lane3.add(player1units[4])
                player1units.removeAt(4)
                println(player1lane1)
                println(player1lane2)
                println(player1lane3)
            }
            break
        }
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
        println("NEXT PLAYERS TURN")
        println("====================")
        if (firstround == true) {
            player2name = playersName().toString()
        }
        options2()
        while (true) {
            print("Choice for lane 1: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player2units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player2lane1.add(player2units[0])
                player2units.removeAt(0)
                println(player2lane1)
            }
            if (number == 2) {
                player2lane1.add(player2units[1])
                player2units.removeAt(1)
                println(player2lane1)
            }
            if (number == 3) {
                player2lane1.add(player2units[2])
                player2units.removeAt(2)
                println(player2lane1)
            }
            if (number == 4) {
                player2lane1.add(player2units[3])
                player2units.removeAt(3)
                println(player2lane1)
            }
            if (number == 5) {
                player2lane1.add(player2units[4])
                player2units.removeAt(4)
                println(player2lane1)
            }
            break
        }
        options2()
        while (true) {
            print("Choice for lane 2: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player2units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player2lane2.add(player2units[0])
                player2units.removeAt(0)
                println(player2lane1)
                println(player2lane2)
            }
            if (number == 2) {
                player2lane2.add(player2units[1])
                player2units.removeAt(1)
                println(player2lane1)
                println(player2lane2)
            }
            if (number == 3) {
                player2lane2.add(player2units[2])
                player2units.removeAt(2)
                println(player2lane1)
                println(player2lane2)
            }
            if (number == 4) {
                player2lane2.add(player2units[3])
                player2units.removeAt(3)
                println(player2lane1)
                println(player2lane2)
            }
            if (number == 5) {
                player2lane2.add(player2units[4])
                player2units.removeAt(4)
                println(player2lane1)
                println(player2lane2)
            }
            break
        }
        options2()
        while (true) {
            print("Choice for lane 2: ")
            val input = readln()
            if (input.isBlank()) continue
            val number = input.toIntOrNull() ?: continue
            if (number > player2units.size) {
                continue
            }
            if (number == 0) {
                continue
            }
            if (number <= 0) {
                continue
            }
            if (number == 1) {
                player2lane3.add(player2units[0])
                player2units.removeAt(0)
                println(player2lane1)
                println(player2lane2)
                println(player2lane3)
            }
            if (number == 2) {
                player2lane3.add(player2units[1])
                player2units.removeAt(1)
                println(player2lane1)
                println(player2lane2)
                println(player2lane3)
            }
            if (number == 3) {
                player2lane3.add(player2units[2])
                player2units.removeAt(2)
                println(player2lane1)
                println(player2lane2)
                println(player2lane3)
            }
            if (number == 4) {
                player2lane3.add(player2units[3])
                player2units.removeAt(3)
                println(player2lane1)
                println(player2lane2)
                println(player2lane3)
            }
            if (number == 5) {
                player2lane3.add(player2units[4])
                player2units.removeAt(4)
                println(player2lane1)
                println(player2lane2)
                println(player2lane3)
            }
            break
        }
        var victor = victorCheck()
        if (victor == 0) {
            round += 0
            println("====================")
            println("The round is a stalemate")
            println("====================")
        }
        if (victor > 0) {
            round += 1
            println("====================")
            println("$player1name wins the round")
            println("====================")
        }
        if (victor < 0) {
            round -= 1
            println("====================")
            println("$player2name wins the round")
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
        println("NEXT ROUND")
        if (round <= 2) {
            println("$player1name's $roundName")
        }
        if (round >= 4) {
            println("$player2name's $roundName")
        }
        if (round == 3) {
            println(roundName)
        }
        println("====================")
        println("Press Enter to Continue")
        val continue3 = readln()
        firstround = false
        player1lane1.clear()
        player1lane2.clear()
        player1lane3.clear()
        player2lane1.clear()
        player2lane2.clear()
        player2lane3.clear()
        continue
    }
    if (round == 6){
        println("$player1name wins the game!")
    }
    if (round == 0){
        println("$player2name wins the game!")
    }
}
fun options1() {
        if (player1units.size >= 1) {
            println("====================")
            println("PRESS 1")
            println(player1units[0])
        }
        if (player1units.size >= 2) {
            println("====================")
            println("PRESS 2")
            println(player1units[1])
        }
        if (player1units.size >= 3) {
            println("====================")
            println("PRESS 3")
            println(player1units[2])
        }
        if (player1units.size >= 4) {
            println("====================")
            println("PRESS 4")
            println(player1units[3])
        }
        if (player1units.size >= 5) {
            println("====================")
            println("PRESS 5")
            println(player1units[4])
        }
    println("====================")
}
fun options2() {
        if (player2units.size >= 1) {
            println("====================")
            println("PRESS 1")
            println(player2units[0])
        }
        if (player2units.size >= 2) {
            println("====================")
            println("PRESS 2")
            println(player2units[1])
        }
        if (player2units.size >= 3) {
            println("====================")
            println("PRESS 3")
            println(player2units[2])
        }
        if (player2units.size >= 4) {
            println("====================")
            println("PRESS 4")
            println(player2units[3])
        }
        if (player2units.size >= 5) {
            println("====================")
            println("PRESS 5")
            println(player2units[4])
        }
    println("====================")
    }
fun victorCheck(): Int {
    var Check = 0
    if (player1lane1.contains("Riflemen")) {
        if (player2lane1.contains("Special Forces")){
            Check -= 1
            }
        if (player2lane1.contains("Bunker")){
            Check -= 1
        }
        if (player2lane1.contains("Artillery")){
            Check -= 1
        }
        if (player2lane1.contains("Scouts")){
            Check += 1
        }
        if (player2lane1.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1lane1.contains("Scouts")) {
        if (player2lane1.contains("Special Forces")){
            Check -= 1
        }
        if (player2lane1.contains("Bunker")){
            Check -= 1
        }
        if (player2lane1.contains("Artillery")){
            Check += 1
        }
        if (player2lane1.contains("Scouts")){
            Check -= 0
        }
        if (player2lane1.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1lane1.contains("Artillery")) {
        if (player2lane1.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane1.contains("Bunker")) {
            Check += 1
        }
        if (player2lane1.contains("Artillery")) {
            Check -= 0
        }
        if (player2lane1.contains("Scouts")) {
            Check -= 1
        }
        if (player2lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane1.contains("Bunker")) {
        if (player2lane1.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane1.contains("Bunker")) {
            Check -= 0
        }
        if (player2lane1.contains("Artillery")) {
            Check -= 1
        }
        if (player2lane1.contains("Scouts")) {
            Check += 1
        }
        if (player2lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane1.contains("Special Forces")) {
        if (player2lane1.contains("Special Forces")) {
            Check -= 0
        }
        if (player2lane1.contains("Bunker")) {
            Check += 1
        }
        if (player2lane1.contains("Artillery")) {
            Check += 1
        }
        if (player2lane1.contains("Scouts")) {
            Check += 1
        }
        if (player2lane1.contains("Riflemen")) {
            Check += 1
        }
    }
    //======================================================
    // check lane 2
    //======================================================
    if (player1lane2.contains("Riflemen")) {
        if (player2lane2.contains("Special Forces")){
            Check -= 1
        }
        if (player2lane2.contains("Bunker")){
            Check -= 1
        }
        if (player2lane2.contains("Artillery")){
            Check -= 1
        }
        if (player2lane2.contains("Scouts")){
            Check += 1
        }
        if (player2lane2.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1lane2.contains("Scouts")) {
        if (player2lane2.contains("Special Forces")){
            Check -= 1
        }
        if (player2lane2.contains("Bunker")){
            Check -= 1
        }
        if (player2lane2.contains("Artillery")){
            Check += 1
        }
        if (player2lane2.contains("Scouts")){
            Check -= 0
        }
        if (player2lane2.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1lane2.contains("Artillery")) {
        if (player2lane2.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane2.contains("Bunker")) {
            Check += 1
        }
        if (player2lane2.contains("Artillery")) {
            Check -= 0
        }
        if (player2lane2.contains("Scouts")) {
            Check -= 1
        }
        if (player2lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane2.contains("Bunker")) {
        if (player2lane2.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane2.contains("Bunker")) {
            Check -= 0
        }
        if (player2lane2.contains("Artillery")) {
            Check -= 1
        }
        if (player2lane2.contains("Scouts")) {
            Check += 1
        }
        if (player2lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane2.contains("Special Forces")) {
        if (player2lane2.contains("Special Forces")) {
            Check -= 0
        }
        if (player2lane2.contains("Bunker")) {
            Check += 1
        }
        if (player2lane2.contains("Artillery")) {
            Check += 1
        }
        if (player2lane2.contains("Scouts")) {
            Check += 1
        }
        if (player2lane2.contains("Riflemen")) {
            Check += 1
        }
    }
    //======================================================
    // check lane 3
    //======================================================
    if (player1lane3.contains("Riflemen")) {
        if (player2lane3.contains("Special Forces")){
            Check -= 1
        }
        if (player2lane3.contains("Bunker")){
            Check -= 1
        }
        if (player2lane3.contains("Artillery")){
            Check -= 1
        }
        if (player2lane3.contains("Scouts")){
            Check += 1
        }
        if (player2lane3.contains("Riflemen")){
            Check -= 0
        }
    }
    if (player1lane3.contains("Scouts")) {
        if (player2lane3.contains("Special Forces")){
            Check -= 1
        }
        if (player2lane3.contains("Bunker")){
            Check -= 1
        }
        if (player2lane3.contains("Artillery")){
            Check += 1
        }
        if (player2lane3.contains("Scouts")){
            Check -= 0
        }
        if (player2lane3.contains("Riflemen")){
            Check -= 1
        }
    }
    if (player1lane3.contains("Artillery")) {
        if (player2lane3.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane3.contains("Bunker")) {
            Check += 1
        }
        if (player2lane3.contains("Artillery")) {
            Check -= 0
        }
        if (player2lane3.contains("Scouts")) {
            Check -= 1
        }
        if (player2lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane3.contains("Bunker")) {
        if (player2lane3.contains("Special Forces")) {
            Check -= 1
        }
        if (player2lane3.contains("Bunker")) {
            Check -= 0
        }
        if (player2lane3.contains("Artillery")) {
            Check -= 1
        }
        if (player2lane3.contains("Scouts")) {
            Check += 1
        }
        if (player2lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    if (player1lane3.contains("Special Forces")) {
        if (player2lane3.contains("Special Forces")) {
            Check -= 0
        }
        if (player2lane3.contains("Bunker")) {
            Check += 1
        }
        if (player2lane3.contains("Artillery")) {
            Check += 1
        }
        if (player2lane3.contains("Scouts")) {
            Check += 1
        }
        if (player2lane3.contains("Riflemen")) {
            Check += 1
        }
    }
    val num = Check
    return num
}
fun playersName(): String? {
    println("====================")
    println("What is your name?")
    println("====================")
    val name = readLine()
    return name
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
    println("Riflemen when played in the same lane as Riflemen will win")
    println("==========")
    println("   ||||    ")
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
// The Function that ends the game
fun endGame() {
    //Thank the player for playing
    println("=====================================")
    println("          Thanks for playing         ")
    println("=====================================")
}
