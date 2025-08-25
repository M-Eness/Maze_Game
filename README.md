# 🎮 Maze Game

This project is a console-based maze game developed in **Java**. The objective is for the player to navigate a dynamically changing 15x15 maze from a starting point to an exit, collecting bonuses and overcoming obstacles along the way.

***

## 🕹️ Gameplay Mechanics

The game is played in the console using keyboard input for movement and actions.

-   **Movement**: Use the following keys to move:
    -   `W`: Move up
    -   `A`: Move left
    -   `S`: Move down
    -   `D`: Move right
-   **Bonus Usage**: Press `+` to use a collected bonus.
-   **Dynamic Maze**: The maze is randomly regenerated every **5 steps**, adding an element of unpredictability to the game.

***

## 🗺️ Maze Elements

The game board is a 15x15 grid containing various characters with special meanings:

-   `B`: **Beginning** - The player's starting point.
-   `E`: **Exit** - The destination the player must reach to win the game.
-   `#`: **Wall** - An impassable obstacle.
-   `!`: **Mine** - A dangerous obstacle that penalizes the player.
-   `.`: **Path** - An empty, safe path for the player to move on.
-   `R`, `F`, `T`, `H`: **Bonus Items** - Collectible items that provide special abilities.

***

## ✨ Bonus Items

Collecting bonus items gives the player advantages that can help them navigate the maze and avoid penalties. Once a bonus is collected, the tile it was on becomes an empty path (`.`).

| Bonus | Symbol | Name | Description |
| :---: | :---: | :---: | :--- |
| `R` | `R` | **R-Bonus** | Allows the player to break and pass through a wall (`#`). One `R` bonus is consumed per wall. |
| `F` | `F` | **F-Bonus** | Allows the player to safely disarm and pass through a mine (`!`). One `F` bonus is consumed per mine. |
| `T` | `T` | **Teleport Bonus** | Allows the player to instantly teleport to any valid coordinates on the board. |
| `H` | `H` | **Health Bonus** | Reduces the player's total step count by 2. |

### 🚨 Obstacle Interactions

-   **Hitting a Wall (`#`)**: Without an `R` bonus, the player is blocked and cannot move in that direction.
-   **Hitting a Mine (`!`)**: Without an `F` bonus, the player is penalized by adding 5 steps to their total step count, and the maze is randomly changed.

***

## 🚀 How to Run the Game

1.  **Compile the code**: Save the code as `Main.java` and compile it using a Java compiler.
2.  **Run the application**: Execute the compiled class file.
3.  **Start playing**: Follow the on-screen instructions to enter your moves.
4.  **Winning Condition**: The game ends when the player reaches the exit point `E`. A final step count will be displayed. You can also type `exit` at any time to quit the game.
