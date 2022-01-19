# LDTS_04_05 - Cross the Map

Our game consists in a text-based version of the Crossy Road game with some SuperMario combinations and some new characters.

The main character is Jack the Sparrow who is trying to free his Princess, and for that he needs to avoid the Pirates and all explosions from the bombs and collect the special key.

For the player to win the game with the highest score, it needs to catch all the biscuits, which represents the score, and the special key to open the prison door where the Princess is being kept.

After rescuing the Princess is opened and Jack needs to leave the map through that door.

Each biscuit that Jack catches makes his score go up, but these are not necessary to release the Princess and finish the game.

This project was developed by _André Costa_ (https://github.com/AndreCosta201905916) (up201905016@fe.up.pt) and _Francisco Serra_ (https://github.com/kiko-serra) (up202007723@fe.up.pt) and _Válter Castro_ (https://github.com/ValterCastro) (up201706546@fe.up.pt) for LDTS 2021⁄22.

## Index
* [GamePlay Demo](#gameplay-demo)
* [Implemented Features](#implemented-features)
  * [Jack the Sparrow](#jack-the-sparrow)
  * [Pirates](#pirates)
  * [Princess](#princess)
* [Planned Features](#planned-features)
* [Design](#design)
  * [Characters](#characters)
    * [Problem in Context](#problem-in-context)
    * [The Pattern](#the-pattern)
    * [Implementation](#implementation)
    * [Consequences](#consequences)
  * [Music](#music)
    * [Problem in Context](#problem-in-context-2)
    * [The Pattern](#the-pattern-2)
    * [Implementation](#implementation-2)
    * [Consequences](#consequences-2)
  * [Input](#input)
    * [Problem in Context](#problem-in-context-4)
    * [The Pattern](#the-pattern-4)
    * [Implementation](#implementation-4)
    * [Consequences](#consequences-4)
* [Code Smells and Possible Refactorings](#code-smells-and-possible-refactorings)
  * [Large Class](#large-class)
* [Testing](#testing)
  * [Coverage Report](#coverage-report)
* [Self-Evaluation](self-evaluation)

## GamePlay Demo
<p align="center">
    <img width="550" src="images/gameplayDemo.gif">
</p>

## Implemented Features

### Jack the Sparrow

- **Movement** - The game character will move according to the direction of the arrow key pressed, and he can´t walk through the borders.
<p align="center">
    <img width="550" src="images/jackMoves.gif">
</p>

- **Getting biscuits** - When Jack hits a biscuit his score goes up by one biscuit until he reaches the maximum score.
<p align="center">
    <img width=550 src="images/catchCoockie.gif">
</p>

- **Catching key** - For Jack to release his beloved Princess he needs to catch the key to open the prison door.
<p align="center">
    <img width=550 src="images/collectKey.gif">
</p>

<p align="center">
    <img width=550 src="images/rescuePrincess.gif">
</p>

- **Lives** - Collisions are implemented so that each time Jack gets hit by one of the pirates he loses a life. When the game starts Jack has 3 lives, and if he loses them all he dies.
<p align="center">
    <img width=550 src="images/losingLivesAndTheGame.gif">
</p>

### Pirates

- **Movement** - Each pirate moves independently horizontally and when they hit a border their direction changes.
<p align="center">
    <img width=550 src="images/enemiesMoves.gif">
</p>

- **Removing lives** - Any Pirate that hits Jack removes one of the three lives he has.

### Princess

- **Following Jack** - When Jack enters the prison, the Princess will start following until they leave the map.
<p align="center">
    <img width=550 src="images/rescuePrincess.gif">
</p>

## Planned Features

- **Different Pirates** - We will make three kinds of Pirates, each one with different speeds and the bigger one will leave bombs behind.
- **Menu** - There will be a menu when you open the game with some buttons.
- **Personalized Font** - We'll create a new font to have our characters and some objects printed on the game.
- **Game Over** - After you die there will be a message on the screen saying that you've died and if you want to restart playing.
- **Lives and score** - On the lower portion of the game will have the amount of lives remaining and how many biscuits you have caught.
- **Sounds and music** - There will be background music and each time Jack catches anything a sound will be played.

## Design

### Characters

#### Problem in Context

#### Pattern

#### Implementation

#### Consequences

### Music

#### Problem in Context

#### Pattern

#### Implementation

#### Consequences

### Input

#### Problem in Context

#### Pattern

#### Implementation

#### Consequences



## Code Smells and Possible Refactorings
### Large Class

Our classes Game and Map contain many fields and methods.
In both cases, we find it justifiable as the classes require these fields,
in one hand the Game class is the main class of the program and it needs to store a considerable amount of data,
on the other hand various methods are needed for the interface and it wouldn't make sense to split it into two separate ones (extract method).

## Testing

### Coverage Report
<p align="center">
    <img width=550 src="images/intermediateReportCoverage.png">
</p>


## Self-Evaluation

- André Costa: 
- Francisco Serra: 
- Válter Castro:
