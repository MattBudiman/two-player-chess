# two-player-chess
This program is a two-player chess game that can be played through a command-line interface.

`ChessGame` is the driver class and is located in the `ChessGame.java` file.

The game is played according to the standard rules of chess. The white pieces are denoted by uppercase letters, while the black pieces are
denoted by lowercase letters.

Below are the steps to making a chess move:
1. Type the alegbraic coordinates (eg. `a1`) of the piece that you wish to move.
2. Type a dash.
3. Type the alegbraic coordinates of the square to which you want to move the piece.
Here is an example of what a legal move may look like: `a2-a3`

Each time a player makes a move, the board flips orientation.

This program automatically checks for invalid inputs. If a player makes and illegal move or does not format the move 
correctly according to the three steps above, the program will alert the player that he or she made an invalid input and will prompt that 
player to re-enter a move.

This program automatically detects stalemate and checkmate. If a player is stalemated (i.e the player's king is not in check, but the
player does not have any legal moves) the program will declare the game a draw. If a player delivers checkmate, the game will declare that
player the winner.

Enjoy!
