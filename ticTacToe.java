/* 
 * Param Patel
 * Data dictionary:
 * 
 * String start - Will run the program when string is start and will end the program when the string equals stop
 * int counter - holds count of amount of turns and if odd its player ones turn if even its player 2's turn
 * int row - row that the marker will be placed in
 * int colum - column that the marker will be placed in
 * char options - the options of what mode the user wants to play
 * String input - holds the input that the user wants to place their marker in
 * char[][]board - the Tic Tac Toe board/also a variable used in method parameters
 * String TwoStart -  Will run selected option of the program when string is start and will end the program when the string equals exit
 * String x - a Variable used in method parameters
 * String valids - holds all the valid letters a user can input
 * int i,k - variables used in for loops
 * 
 */
class ticTacToe
{
  public static void main(String[]args)
  {
    int counter = 0; 
    char[][]board = new char[3][3]; // row column
    String input = ""; 
    int row = 0; 
    int colum = 0; 
    String start = "";
    char options = ' ';
    String TwoStart = ""; 
    
    do
    {
      
      System.out.println("Welcome to Tic Tac Toe"); 
      System.out.println("Tic Tac Toe game is played on a 3x3 grid.. First player to get 3 in a row up,down,diagonal"); 
      System.out.println("will be the winner if all rows are filled and no one has got 3 in a row no one wins hence a draw"); 
      System.out.println("Please enter Start to continue or enter Stop to exit"); 
      start = In.getString(); 
      start = start.toLowerCase(); //changes all chars to lowercase so the user can type start or stop any way they want
      
      if(start.equals("start") == false && start.equals("stop")==false ) // looping until user enters a proper string
      {
        System.out.println("Invalid input"); //if user does not enter start or stop it will print an invalid 
        System.out.println();  
      }
      if(start.equals("start"))
      {
        System.out.println("Which mode will you like to play?"); 
        System.out.println("If you would like to play against 2 player Enter X");
        System.out.println("If you would like to play against 1 player mode Easy Enter E"); 
        System.out.println("If you would like to play against 1 player mode Hard Enter H"); 
        options = In.getChar();
        
        while(!(options == 'X'|| options == 'x'|| options == 'E'|| options == 'e' || options == 'H' || options == 'h')) // looping until user enters a proper char
        {
          System.out.println("Please enter a valid letter"); 
          options = In.getChar(); // changing options to new input
        }
        switch (options)
        {
          case 'x': // 2 player
          case 'X':
            do
          {
            
            System.out.println(); 
            resetBoard(board);  // resetting board to be blank
            counter = 0; 
            System.out.println("Welcome to Tic Tac Toe 2 player mode");
            System.out.println("Player 1 will be X and player 2 will be O");
            System.out.println("First player to get 3 in a row wins"); 
            System.out.println("If no one gets 3 in a row the game will end on a draw");
            System.out.println("Enter a row first from 0-2 and than a colum from 0-2 to place your marker"); 
            System.out.println("Please put a space between the row and colum and make sure to not have more than one space"); 
            System.out.println("Enter Start to continue or Enter exit to leave");
            TwoStart = In.getString(); 
            TwoStart = TwoStart.toLowerCase(); // changing string to lowercase 
            while(TwoStart.equals("start") == false && TwoStart.equals("exit")==false )
            {
              System.out.println("Invalid input"); //if user does not enter start or stop it will print an invalid input
              TwoStart = In.getString(); 
              TwoStart = TwoStart.toLowerCase();
              System.out.println();  
            }
            if(TwoStart.equals("start") == true)
            {
              System.out.println();
              printBoard(board);  // printing the board
              do
              {
                counter ++; // increasing the turns 
                if(counter%2 == 0) // if even that its player 2's turn 
                {
                  System.out.println("Player 2: Enter row and colum 0,1,2");
                  input = In.getString(); 
                }
                else // else its player 1's turn 
                {
                  System.out.println("Player 1: Enter row and colum 0,1,2");
                  input = In.getString(); 
                }
                
                while(properFormat(input) == false) //until user enters only 0,1 and 2
                {
                  System.out.println("Incorrect Input, only enter numbers 0 1 2");
                  input = In.getString(); // changes string to new input
                }
                
                while(spaceCheck(input) == false) // until the user single spaces everything
                {
                  System.out.println("Incorrect Input, Make sure to only put one space  value");
                  input = In.getString(); // changes string to new input
                }
                
                row = Integer.parseInt(input.substring(0,1)); //changing string input to a number
                colum = Integer.parseInt(input.substring(2)); //changing string input to a number
                
                while (board[row][colum] == 'X' || board[row][colum] == 'O') // checking if board is already occupied or not
                {
                  System.out.println("This spot is occupied please retry");
                  input = In.getString(); // changing input to new input
                  row = Integer.parseInt(input.substring(0,1)); // changing new input to a number
                  colum = Integer.parseInt(input.substring(2)); // changing new input to a number
                }
                
                if(counter%2 == 0) // if counter%2 = 0 its player 2's turn 
                {
                  board[row][colum] = 'O'; // will change the board and put the marker where player 2 wants
                }
                else
                {
                  board[row][colum] = 'X'; // will change the board and put the marker where player 1 wants
                }
                
                printBoard(board); // printing board after each turn 
                
              }
              while(counter<9 && winner(board) == false); // will run until turns are 9 or no one has won 
              
              if(counter == 9 && winner(board) == false)
              {
                System.out.println("Draw"); 
              }
              else if(counter%2 == 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is player 2!!!!!");   
                System.out.println(); 
              }
              else if(counter%2 != 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is player 1!!!!!");
                System.out.println(); 
              }
              
              System.out.println("Do you wish to replay if not enter exit if you wish to replay enter replay"); 
              TwoStart = In.getString(); // will ask to replay 
              TwoStart = TwoStart.toLowerCase();
              while(TwoStart.equals("replay") == false && TwoStart.equals("exit")==false )
              {
                System.out.println("Invalid input"); //if user does not enter 1 or stop it will print an invalid input
                TwoStart = In.getString(); // will ask to replay 
                TwoStart = TwoStart.toLowerCase();
              } 
            } 
          }
            while(TwoStart.equals("exit")== false ); 
            
            break; 
            
          case 'e':
          case 'E':
            do
          {
            System.out.println(); 
            resetBoard(board); // resetting board to be blank
            counter = 0; 
            System.out.println("Welcome to Tic Tac Toe 1 player easy mode");
            System.out.println("You will be versing the easy computer");
            System.out.println("First player to get 3 in a row wins"); 
            System.out.println("If no one gets 3 in a row the game will end on a draw");
            System.out.println("Enter a row first from 0-2 and than a colum from 0-2 to place your marker"); 
            System.out.println("Please put a space between the row and colum and make sure to not have more than one space"); 
            System.out.println("Enter Start to continue or Enter exit to leave");
            TwoStart = In.getString(); 
            TwoStart = TwoStart.toLowerCase();
            while(TwoStart.equals("start") == false && TwoStart.equals("exit")==false )
            {
              System.out.println("Invalid input"); //if user does not enter 1 or stop it will print an invalid input
              TwoStart = In.getString(); 
              TwoStart = TwoStart.toLowerCase();
            }
            if(TwoStart.equals("start") == true)
            {
              System.out.println();
              printBoard(board);  // printing the board
              do
              {
                counter ++;  // increasing the turns 
                System.out.println("Player Turn : Enter row and colum 0,1,2");
                input = In.getString(); 
                
                while(properFormat(input) == false) //until user enters only 0,1 and 2
                {
                  System.out.println("Incorrect Input, only enter numbers 0 1 2");
                  input = In.getString(); // changes string to new input
                }
                
                while(spaceCheck(input) == false) // until the user single spaces everything
                {
                  System.out.println("Incorrect Input, Make sure to only put one space  value");
                  input = In.getString(); // changes string to new input
                }
                
                row = Integer.parseInt(input.substring(0,1)); //changing string input to a number
                colum = Integer.parseInt(input.substring(2)); //changing string input to a number
                
                while (board[row][colum] == 'X' || board[row][colum] == 'O') // checking if board is already occupied
                {
                  System.out.println("This spot is occupied please retry");
                  input = In.getString(); // changing input to new int
                  row = Integer.parseInt(input.substring(0,1)); // changing new input to a number
                  colum = Integer.parseInt(input.substring(2)); // changing new input to a number
                }
                board[row][colum] = 'X'; // will change board to where the user wants move
                if(winner(board) == false && counter < 8)
                {
                  counter++; 
                  board = computerMove(board); // will change board to where the Computer wants move
                }
                printBoard(board); // printing board
              }
              while(counter<9 && winner(board) == false); // will run until turns are 9 or no one has won
              
              if(counter == 9 && winner(board) == false)
              {
                System.out.println("Draw"); 
              }
              else if(counter%2 == 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is the computer!!!!!");   
                System.out.println(); 
              }
              else if(counter%2 != 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is player 1!!!!!");
                System.out.println(); 
              }
              
              System.out.println("Do you wish to replay if not enter exit if you wish to replay enter replay"); 
              TwoStart = In.getString(); // will ask to replay 
              TwoStart = TwoStart.toLowerCase();
              while(TwoStart.equals("replay") == false && TwoStart.equals("exit")==false )
              {
                System.out.println("Invalid input"); //if user does not enter replay or exit it will print an invalid input
                TwoStart = In.getString();
                TwoStart = TwoStart.toLowerCase();
              } 
            }
            
          }
            while(TwoStart.equals("exit")== false ); 
            
            break;
            
          case 'h':
          case 'H': 
            do
          {
            System.out.println(); 
            resetBoard(board); // resetting board to be blank
            counter = 0; 
            System.out.println("Welcome to Tic Tac Toe 1 player hard mode");
            System.out.println("Player 1 will be X The computer will be O");
            System.out.println("First player to get 3 in a row wins"); 
            System.out.println("If no one gets 3 in a row the game will end on a draw");
            System.out.println("Enter a row first from 0-2 and than a colum from 0-2 to place your marker"); 
            System.out.println("Please put a space between the row and colum and make sure to not have more than one space"); 
            System.out.println("Enter Start to continue or Enter exit to leave");
            TwoStart = In.getString(); 
            TwoStart = TwoStart.toLowerCase(); // changing string to lowercase
            while(TwoStart.equals("start") == false && TwoStart.equals("exit")==false )
            {
              System.out.println("Invalid input"); //if user does not enter 1 or stop it will print an invalid input
              TwoStart = In.getString(); 
              TwoStart = TwoStart.toLowerCase();
              System.out.println();  
            }
            if(TwoStart.equals("start") == true)
            {
              System.out.println();
              printBoard(board);   // printing the board
              do
              {
                counter ++; // increasing the turn
                System.out.println("Enter row and colum 0,1,2");
                input = In.getString(); 
                
                while(properFormat(input) == false) //until user enters only 0,1 and 2
                {
                  System.out.println("Incorrect Input, only enter numbers 0 1 2");
                  input = In.getString(); // changes string to new input
                }
                
                while(spaceCheck(input) == false) // until the user single spaces everything
                {
                  System.out.println("Incorrect Input, Make sure to only put one space  value");
                  input = In.getString(); // changes string to new input
                }
                
                row = Integer.parseInt(input.substring(0,1)); //changing string input to a number
                colum = Integer.parseInt(input.substring(2)); //changing string input to a 
                
                while (board[row][colum] == 'X' || board[row][colum] == 'O') // checking if board is already occupied or not
                {
                  System.out.println("This spot is occupied please retry");
                  input = In.getString(); // changing input to new input
                  row = Integer.parseInt(input.substring(0,1)); // changing new input to a number
                  colum = Integer.parseInt(input.substring(2)); // changing new input to a number
                }
                board[row][colum] = 'X';  // will the board and put the marker where player wants
                if(winner(board) == false && counter <8)
                {
                  counter++; 
                  board = computerMove2(board); // will change board to where the Computer wants move
                }
                printBoard(board); 
                
              }
              while(counter<9 && winner(board) == false); // will run until turns are 9 or no one has won
              
              if(counter == 9 && winner(board) == false)
              {
                System.out.println("Draw"); 
              }
              else if(counter%2 == 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is the computer!!!!!");   
                System.out.println(); 
              }
              else if(counter%2 != 0) // checking at what turn did the counter end to decide who the winner is
              {
                System.out.println("Winner is player 1!!!!!");
                System.out.println(); 
              }
              
              System.out.println("Do you wish to replay if not enter exit if you wish to replay enter replay"); 
              TwoStart = In.getString(); // will ask to replay 
              TwoStart = TwoStart.toLowerCase();
              
              while(TwoStart.equals("replay") == false && TwoStart.equals("exit")==false )
              {
                System.out.println("Invalid input"); //if user does not enter 1 or stop it will print an invalid input
                TwoStart = In.getString(); 
                TwoStart = TwoStart.toLowerCase();
              }
            }
          }
            while(TwoStart.equals("exit")== false ); 
            
            break;
            
        }
      }
    }
    while(start.equals("stop")==false);
    System.out.println("Goodbye");
    
  }
  
  
  public static char[][] resetBoard(char[][]board) // resets every board place to a space
  {
    for(int i = 0; i<3; i++)
    {
      for(int k = 0; k<3; k++)
      {
        board[i][k] = ' '; // will change each value to a space
      }
    }
    return board; 
  }
  
  public static void printBoard(char[][]board) // prints board 
  {
    for(int i = 0; i<board.length; i++) //goes through rows 
    {
      for(int k = 0; k<board[i].length; k++) //goes through columns
      {
        if (i == board[k].length)  //condition for the last box of the row
        {
          System.out.print(board[i][k]); //print the last box without any separator
        }
        else
        {
          System.out.print( board[i][k] +" | " ); //prints the box followed by a "|" separator
        }  
      }
      System.out.println(); // new line after each row
      System.out.println("- - - - - -"); // line of dashes as a separator between rows 
    }
  }
  
  
  public static boolean spaceCheck(String x) // checking is user has extra spaces
  {
    if(x.indexOf(' ') == -1) // if there are no spaces
    {
      return false; // will return false if there are no spaces
    }
    else if(x.charAt(0) == ' ' || x.charAt(1+1) == ' ' || x.length()>3) // if there are multiple spaces and if the length can only be 3 
    {
      return false; // will return false if there are multiple spaces and if the length is greater than 3 
    }
    return true; //if the letter is a space the method will return true
  }
  
  
  
  public static boolean winner(char[][]board)
  { 
    for(int i = 0; i<3; i++) // hecking all possibilities of columns
    {
      if (board[0][i] == 'X' && board[0][i] == board[1][i] && board[0][i] == board[2][i] || board[0][i] == 'O' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
      {
        return true; 
      }
    }
    
    for(int i = 0; i<3; i++) // checking all possibilities of rows
    {
      if (board[i][0] == 'X'  && board[i][0] == board[i][1] && board[i][0] == board[i][2] || board[i][0] == 'O'  && board[i][0] == board[i][1] && board[i][0] == board[i][2])
      {
        return true; 
      }
    }
    
    // check both possibilities of diagonals
    if(board [0][0] == 'X'  && board [0][0] == board [1][1] && board [0][0] == board[2][2] || board [0][0] == 'O'  && board [0][0] == board [1][1] && board [0][0] == board[2][2])
    {
      return true; 
    }
    
    if(board [0][2] == 'X' && board [0][2] == board [1][1] && board [0][2] == board[2][0] || board [0][2] == 'O' && board [0][2] == board [1][1] && board [0][2] == board[2][0])
    {
      return true;
    }
    return false; 
    
  }
  public static boolean properFormat(String x)
  {
    String valids = "012 "; // all the valid numbers
    for(int i = 0; i<x.length()-1; i++) // goes through every number in the inputted string
    {
      if(valids.indexOf(x.charAt(i)) == -1)
      {
        return false;  // if their are incorrect values the method will return false  
      }
    }
    return true;// if their are no incorrect values the method will return true
  }
  
  private static char[][] computerMove(char[][] board)
  { 
    int row = 0; 
    int col = 0;
    do
    {
      row = (int)(Math.random() * 3); // generating move
      col = (int)(Math.random() * 3); // generating move
    } 
    
    while (board[row][col] != ' ');// will run until the random space it choses is not a space
    {   
      board[row][col] = 'O';
    }
    
    return board;
    
  }
  
  
  
  private static char[][] computerMove2(char[][] board)
  {
    // check if computer can win by placing a marker in an empty spot in a winning row
    for (int i = 0; i < 3; i++) 
    {
      if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == ' ') 
      {
        board[i][2] = 'O';
        return board;
      }
      if (board[i][0] == 'O' && board[i][2] == 'O' && board[i][1] == ' ')
      {
        board[i][1] = 'O';
        return board;
      }
      if (board[i][1] == 'O' && board[i][2] == 'O' && board[i][0] == ' ') 
      {
        board[i][0] = 'O';
        return board;
      }
    }
    
    // check if computer can win by placing a marker in an empty spot in a winning column
    for (int i = 0; i < 3; i++) 
    {
      if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == ' ') 
      {
        board[2][i] = 'O';
        return board;
      }
      if (board[0][i] == 'O' && board[2][i] == 'O' && board[1][i] == ' ') 
      {
        board[1][i] = 'O';
        return board;
      }
      if (board[1][i] == 'O' && board[2][i] == 'O' && board[0][i] == ' ') 
      {
        board[0][i] = 'O';
        return board;
      }
    }
    
    // check if computer can win by placing a marker in an empty spot in a winning diagonal
    if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == ' ') 
    {
      board[2][2] = 'O';
      return board;
    }
    if (board[0][0] == 'O' && board[2][2] == 'O' && board[1][1] == ' ')
    {
      board[1][1] = 'O';
      return board;
    }
    if (board[1][1] == 'O' && board[2][2] == 'O' && board[0][0] == ' ') 
    {
      board[0][0] = 'O';
      return board;
    }
    if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == ' ') 
    {
      board[2][0] = 'O';
      return board;
    }
    if (board[0][2] == 'O' && board[2][0] == 'O' && board[1][1] == ' ')
    {
      board [1][1] = '0'; 
      return board;
    }
    if (board[1][1] == 'O' && board[2][0] == 'O' && board[0][2] == ' ') 
    {
      board[0][2] = 'O';
      return board;
    }
    
    // check if player is about to win by placing a marker in an empty spot in a winning row
    for (int i = 0; i < 3; i++) 
    {
      if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == ' ') 
      {
        board[i][2] = 'O';
        return board;
      }
      
      if (board[i][0] == 'X' && board[i][2] == 'X' && board[i][1] == ' ') 
      {
        board[i][1] = 'O';
        return board;
      }
      
      if (board[i][1] == 'X' && board[i][2] == 'X' && board[i][0] == ' ') 
      {
        board[i][0] = 'O';
        return board;
      }
    }
    
    // check if player is about to win by placing a marker in an empty spot in a winning column
    for (int i = 0; i < 3; i++) 
    {
      if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == ' ') 
      {
        board[2][i] = 'O';
        return board;
      }
      if (board[0][i] == 'X' && board[2][i] == 'X' && board[1][i] == ' ') 
      {
        board[1][i] = 'O';
        return board;
      }
      if (board[1][i] == 'X' && board[2][i] == 'X' && board[0][i] == ' ')
      {
        board[0][i] = 'O';
        return board;
      }
    }
    // check if player is about to win by placing a marker in an empty spot in a winning diagonal
    if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == ' ') 
    {
      board[2][2] = 'O';
      return board;
    }
    if (board[0][0] == 'X' && board[2][2] == 'X' && board[1][1] == ' ') 
    {
      board[1][1] = 'O';
      return board;
    }
    if (board[1][1] == 'X' && board[2][2] == 'X' && board[0][0] == ' ') 
    {
      board[0][0] = 'O';
      return board;
    }
    if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == ' ') 
    {
      board[2][0] = 'O';
      return board;
    }
    if (board[0][2] == 'X' && board[2][0] == 'X' && board[1][1] == ' ')
    {
      board[1][1] = '0';
      return board; 
    }
    if (board[1][1] == 'X' && board[2][0] == 'X' && board[0][2] == ' ') 
    {
      board[0][2] = 'O';
      return board;
    }
    int row = 0; 
    int col = 0;
    do
    {
      row = (int)(Math.random() * 3); // generating move
      col = (int)(Math.random() * 3); // generating move
    } 
    
    while (board[row][col] != ' '); // will run until the random space it choses is not a space
    {
      board[row][col] = 'O'; // changes the board to computer move
    }
    return board;
  }
}
