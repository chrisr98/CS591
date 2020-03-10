Chris-Emio Raymond
U20803007

How to use program:
The following will compile and execute code provided all files are in the same directory
"javac RunGame.java && java RunGame"

The board looks like this
[ _ _ _ ]
[ _ _ _ ]
[ _ _ _ ]

Here are the indices/coordinates
[ (0,0) (1,0) (2,0) ]
[ (0,1) (1,1) (2,1) ]
[ (0,2) (1,2) (2,2) ]

When you input the coordinates do it this way: 0 1
No comma or parentheses.

I chose not to include the additional rule from the wiki page in this version of order and chaos

Class Description:

RunGame.java simply runs the game and tallies the score to report at the end.
TicTacToe.java has the code to run the Tic-Tac-Toe game and how to decide if the game is over.
OrderAndChaos.java has the code to run the Order and Chaos game and how to decide if the game is over.
TokenID.java currently makes a list of players assigned. Easier to pull designated player. Can be any number of players.
positionTTT.java assigns or gets the position of a cell on the board and the state, state means which player is on that spot.
PlayerID.java will be a list of strings and integers. With preassigned token symbols. (i.e 'X','O'). If needed can be assigned a specific token.
CreateBoard.java creates a cell by cell board, initializes possible ways to win (I now realize this is only for TicTacToe and its variants). And prints the board.
