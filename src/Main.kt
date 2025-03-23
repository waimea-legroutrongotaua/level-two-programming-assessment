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



fun main() {
}
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
// Game Name:
//  
//
// idea for game:
//
// 1 base for each player (2 players)
// 3 lanes with 3 different options for the player to put in each lane
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
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------

