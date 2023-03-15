# TicTacToe
*****IMPORTANT***** This program uses In.get not a scanner to get user input.

Using a variety of different methods, I have created a Tic Tac Toe game with 3 modes: Easy, Hard, 2player.
Firstly it's the do loop that starts the code when the user has inputted start case insensitive
because it puts the string to lowercase as soon as the user inputs it. Once the string is started
the code will take you to a switch statement asking the user what mode they would like to play
the options are X for 2 players, E for one player easy mode and H for one player hard mode.
X: In the 2 player option the user will be first shown how to play the game and instructions on
how to play than when the user enters start they will be taken to the game code if they enter exit
they will be taken to the first page, when the user enters start the the method resetBoard starts
and resetBoard changes all the values in the 2d array to a space so it turns blank again. Once
they enter a turn the counter goes up, the counter counts all the turns the user has taken and it
also checks who has won, if the counter is odd then player 1 has one because all player 1’s
moves would be odd numbers and all player 2’s moves would be even numbers. Once the user
has entered their move the method properFormat would be called and if the value is false it
goes into a while loop and keeps asking until the user enters proper numbers. Once the user
has made their move the method printboard would be called and the board gets printed the
board gets reprinted after every turn. If someone has gotten 3 in a row the method winner will
return true and the loop will end and ask if the user wants to replay if they want to replay they
enter replay and the loop restarts and if they enter exit they get taken back to the first page.

Case H and E have the same concepts but instead of a user going method computer would go
for easy mode and method h would go for hard mode, the methods would run when winner is
false and when counter is less than 8
