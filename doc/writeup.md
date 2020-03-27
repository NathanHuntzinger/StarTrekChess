# Chess (Star Trek Version)


**Team Members:**

- Nathan Huntzinger
- Ben Lewis


# Program Requirements

**Game Flow**
1. Every round will switch whose turn it is, starting with white
2. On a players turn they will be allowed to make one move
3. When a player clicks on a piece all possible movement locations shall be highlighted

**Board**
1. The playing field shall be composed of 3 main boards and 4 movable corner boards
2. Each main board shall be composed of a 4x4 grid (16 tiles)
    - These boards shall be positioned on top of each other and shifted two squares in one direction
    - Looking from above it should look like a single 8x4 board
4. Each corner board shall be composed of a 2x2 grid (4 tiles)
    1. These boards shall start positioned in the far corners of the top and bottom boards
    2. Each board shall be marked as belonging to the team who owns the side where the board starts.
        - This means each team will own two corner boards.
    3. They shall be movable by players as outlined below:
        - More than one piece on them: No movement is allowed
        - A single piece: Can move like a rook to a different corner (including up or down) but cannot move backward.
        - No pieces: Is movable only by the team that owns it. Can move like a rook (including up or down) to a different corner (including backwards)
    4. Moving a board shall count as a turn

**Playing Pieces**
1. The game shall have all the same pieces as a normal chess game and shall behave the same way
2. No piece shall be allowed to accompany the same square as another piece of the same color
3. When a piece moves to a square occupied by a second piece of the other color the second piece shall be "killed" and removed from the board
4. A piece shall not be allowed to move vertically without also moving horizontally
5. Pieces shall not be allowed to move outside of the board
6. When moving pieces shall not be able to move over any other pieces
    - Knights are an exception and are allowed to go directly to their square even if it goes through other pieces
7. In the case of a pawn, the movement of an attack board holding the pawn counts as a first move and that pawn can no longer move two spaces
8. When a pawn reaches the row furthest from its starting point it shall be converted into a queen
9. No movements that result with the same color king in check shall be allowed

**Game Completion**
Tests for these conditions shall run between every turn:
1. The program shall detect if a king is in check
2. The program shall detect if a king is in checkmate
3. The game shall detect a draw:
    - A player can make no further moves without putting their king in check
    - Both players do not have sufficient pieces to put the other in checkmate
    
# Project requirements
**At least 2 types JavaFX Panes organized well, to give your GUI a nice appearance and usability. (30 points)**
1. The boards in the game will be grid panes with the peices as nodes in the pane. The chat will use a VBox pane of text feilds.

**At least 6 types of JavaFX Nodes, i.e. Buttons, TextField, Labels, CheckBoxes, RadioButtons, ImageView, etc. (30 points)**
1. The chat will be Text feild nodes.
2. The Boards will have a grid of rectangle nodes to select spaces.
3. The peices will be Image View nodes.

**Animation i.e. Timeline or FadeTransition.  Or a video/audio component. (15 points)**
1. The pieces will move from one space to another is a timeline transition.

**Events (20 points)**
1. Mouse action events will be used to trigger logic when the player clicks on a piece.

**Bindings (20 points)**

**Listeners (20 points)**

**Server-Client, or Client-Client connectivity (15 points)**
1. Board
    - A server will keep track of the board state and run the logic controlling the board.
    - Players will get display data and send moves to the server as clients.
2. Chat
    - Players will be able to send messages to eachother in the game.

# Division of Labor
Ben Lewis
 - Board logic and related classes
 
 Nathan Huntzinger
