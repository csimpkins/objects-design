===========================
CS 2340 Summer 2013 Project
===========================


Problem Description
===================

You will write a game that is inspired by the classic board game Risk_.  I encourage you to come up with a creative variation on the Risk_ theme, but you may also implement Risk_ itself.  If you implement Risk_, it is your responsibility to either get permission from Hasbro, or make your repository private.

The Rules of Risk
-----------------

For your reference, here's a rough outline of the rules of Risk_.

Risk_ is a turn-based strategy game played by 2 - 6 players controlling armies on a board containing 42 territorries.  The object of the game is to conquer every territory on the board.

Setup
~~~~~

Each player chooses a "color" and gets an initial allotment of armies of that color according to the number of players:

- With 3 players, each player gets 35 armies.
- With 4 players, each player gets 30 armies.
- With 5 players, each player gets 25 armies
- With 6 players, each player gets 20 armies.

Gameplay
~~~~~~~~

On each turn a player does three things:

1. Receives additional armies based on the number of territories and continents the player controls
2. Attacks other players' territories (optional).
3. Fortifies a territory (optional).

Receiving Additional Armies
```````````````````````````

At the beginning of a player's turn the player receives:

- 1 army for every 3 territories the player occupies, or 3 armies if the player occupies less than 9 territories,
- some number of armies for each continent the player occupies according to the following schedule:

  - Africa: 3
  - Asia: 7
  - Australia: 2
  - Europe: 5
  - North America: 5
  - South America: 2

(There are also cards in Risk_, but we'll ignore them to simplify the game for our purposes.)


Attacking
`````````
A player can choose to attack a neighboring territory occupied by another player.  To attack a territory, the attacking territory must have at least one more army than the defending territory, and the territories must be adjacent.  The attack proceeds as follows:

- The attacker rolls up to 3 red dice.  The attacker must have at least one more army than dice being rolled (can't risk every last army).
- The defender rols up to 2 white dice.  The defender must have at least as many armies as dice being rolled (can risk every last army).
- Both attacker an defender sort their rolled dice in descending order.

  - The first die for the atttacker is compared to the first die of the defender, second die is compared to second die, and so on.
  - Ties go to defender.
  - For both attacker and defender, each die comparison loss results in the loss of one army.

- The attacker may continue the attack as long as enough armies remain, and may attack form any territory to any adjacent territory.
- When all the defenders armies are vanquished, the attacker must move at least as many armies as dice were rolled into the newly conquered territory to occupy it.

Fortifying
``````````

At the end of a player's turn, the player may move armies from one territory to an adjacent territory, leaving behind at least one army (each territory must be occupied by at least one army).

Winning!
--------

A player loses by having every army vanquished, thus occupying no territorries on the board.  A player wins by occupying every territory on the board.

Software Requirements
=====================


Definitions, Acronyms, and Abgreviations
----------------------------------------

- Player: a single user who is participating in a game.
- Game: an episode that starts with players registering as participants in the game, proceeds through initial game setup, and as many rounds of turns as is necessary for one player to win according to the rules of the game.
- Army: an discrete unit of measure of attacking or defending force.  A metaphor meant to invoke physical armies in human militaries.
- Territory: a geographical or metaphorical region distinct from other regions.
- Occupy: have at least one army on a territory.
- Attack: apply force with some number of armies against some number of opposing armies resulting in the loss of some number of attacking and/or defendig armies.


Overall Description
-------------------

The software will implement the (simplified) game of Risk_ described above in a web-based system.  Each user of the software will control one or more players, and each user will use the same computer in a single browser window.  Players are individually identified.  Users are not individually identified.


User Characteristics
~~~~~~~~~~~~~~~~~~~~

Users of the system will be comfortable using interactive browser-based software, be able to read English language text, and understand simple diagrams and pictures as might be found in popular magazines or newspapers.


Constraints
~~~~~~~~~~~

- The user interface must run in a web browser.
- The game logic must be implemented in Java servlets running in a Tomcat 7.x servlet container.

Specific Requirements
---------------------

Note that these requirements are not comprehensive and are written using terminology from Risk_.  You may add your own requirements and substitute your own game concepts and rules as long as the game has the following characteristics:

- 3- 6 players.
- Turn-based strategy game.
- A concept of "territories."
- A concept of "armies" that occupy territories.
- "Attacks" whose outcomes are decided by a combination of chance and number or strength of "armies" involved in the attack and defense.
- A concept of loss by attrition.
- A concept of victory by expanding occupation of territories.

Functional Requirements
~~~~~~~~~~~~~~~~~~~~~~~

Setup
`````

- R1: The software shall provide a means for 3-6 players to join a game by entering their names.
- R2: The software shall randomly select an order for turns among the players in a game and display this order to the users.  This turn order will remain in effect throughout the game.
- R3: The software shall assign to each player some number of "armies" at the beginning of the game.
- R4: The software shall display to the users all the territories on the "board" throughout the game.
- R5: The software shall display to the users all the armies on all the territories on the board throughout the game.
- R6: The software shall provide a means for each player to choose, or be assigned initial territories occupied by the armies given in the player's initial allottment (R3).


Play
````

- R7: The software shall provide notification of each player's turn according to the order determined in setup (R2).  

  For each player's turn:

  - R8: At the beginning of a player's turn, the software shall calculate the number of armies to be added to the player's total and display this number to 
the player.
  - R9: The software shall provide a means for the player to place the armies received on a turn on territories of the player's choosing, provided the player already occupies the territories.
  - R10: The software shall require the player to place all of the newly received armies before proceeding with the turn.
  - R11: The software shall provide a means for the player to choose to attack.

    If the player chooses to attack:  

    - R12: The software shall provide a means for the player to choose which territory to attack from, and which territory to attack.
    - R13: The software shall provide a means for the attacking player to choose how many dice to roll in the attack, up to 3.  The software should not allow the player to choose to roll a number of dice that is more than one less than the number of armies on the attacking territory.
    - R14: The software shall provide a means for the defending player to choose how many dice to roll, up to 2.  The software should not allow the defending player to choose to roll a number of dice greater thatn the number of armies on the defending territory.
    - R15: After the attacking and defending players have both chosen their numbers of dice to roll, the software shall "roll" the dice, show the results to the users, calculate the resulting numbers of armies on each territory, and display the resulting numbers of armies on the respective territories.
    - R16: The software shall provide a means for the attacking player to choose to continue to attack.

  - R17: The software shall provide a means for the player to fortify a territory with armies from an adjacent territory.  At least one army must remain on all territories.

  - R18: If the last attack resulted in the attacking player occupying every territory on the board, the software shall recognize that the gae is over, report the attacking player as the winner, and offer to start a new game.

Milestones
==========

- M1: Game Initialization, R1 - R3
- M2: Board Setup, R4 - R6
- M3: Turn Setup, R7 - R10
- M4: Attacks, R11 - R16
- M5: Turn/Game Closeout, R17 - R18


.. _Risk: http://en.wikipedia.org/wiki/Risk_%28game%29
