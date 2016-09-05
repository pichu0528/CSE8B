/**  
 * Assignment 2           P2.java                     Due Jan. 26, 2013 
 * login:  cs8bbf 
 **/ 
/** 
 * class P2  - Class header comment 
 * This program is design for TIC TAC TOE.
 * There are two players, and consist of three games.
 * At the end of the result will show who win the first, second, and third game.
 * This program will repeat by itself if you enter everything other than words that start with N or n. 
 **/


import java.util.*;                                      // Scanner for input

public class P2
{ 
  private static Scanner scan = new Scanner (System.in); // Scanner input
  private static char[][] board;                         // Private final class variable
  private static final char NUL_CHAR = '\u0000';         // Null Unicode index
  private static final int MIN = 0;                      // Minimum index
  private static final int ROW = 3;                      // Number of rows in 2-D array
  private static final int COL = 3;                      // Number of columns in 2-D array
  private static final int MAX_GAMES = 3;                // Number of games in tournament
  private static String inputStr = null;
  private static char choice;
  private static int number = 0;                         // Number to count how many Xs or Os 
  
  public static void main (String[] arg)
  {
    boolean gameOver = false;                            // A winner or draw in a game
    char [] aTournament = new char[MAX_GAMES];           // 1-D char array holding winner
    
    do
    {
      System.out.println("Start playing TIC-TAC-TOE Tournament of 3 games!"); // Prompt to start the game
      int gameNum;
      for (gameNum = 0; gameNum < MAX_GAMES; ++gameNum)        // Loop three times for the game
      {
        System.out.println ("GAME #: " + (gameNum+1));
        board = new char [ROW][COL];                     // Allocate memory for 2-D char array
        displayBoard();
        gameOver = false;                                // Clear flag showing game end
        
        do 
        {
          
          System.out.print("Enter a row(1-3) and a column(1-3):");   // Prompt to enter row and column as you wish
          
          
          //Prompt the first player
          makeAmove('X');                                // Player X chooses position
          
          displayBoard();                                // Print current status of board
          if (isAwin('X'))                               // Rest if a winner
          {
            gameOver = true;                             // Flag to start next game
            System.out.println ("X player won"); 
            aTournament[gameNum] = 'X';                  // Store winner 'X'
            continue;                                    // Start next game in tournament
          }
          else if (isAdraw('X'))                         // Rest if it's a draw
          {
            gameOver = true;                             // Flag to start next game
            System.out.println ("A draw! No Winner"); 
            aTournament[gameNum] = '-';                  // Store draw '-'
            continue;                                    // continue to the next round
          } 
            
          
          System.out.print("Enter a row(1-3) and a column(1-3):");
          
          
            // Similar to 'X' winner, except messae and hyphen character stored   
            // Prompt the second player
          makeAmove('O');                                // Player O chooses position
          
          displayBoard();                                // Print current status of board
          if (isAwin('O'))                               // Rest if a winner
          {
            gameOver = true;                             // Flag to start next game
            System.out.println ("O player won"); 
            aTournament[gameNum] = 'O';                  // Store winner 'O'
            continue;                                    // Start next game in tournament
          }
          
          else if (isAdraw('O'))                         
          {
            gameOver = true;                             // Rest if it's a draw
            System.out.println ("A draw! No Winner"); 
            aTournament[gameNum] = '-';                  // Store draw '-'
            continue;                                    // continue to the next round
          }
        }while(gameOver == false);
      }
          
          
      //Repeat program - refer to PA#2 
      System.out.println("WINNERS of the 3 games: " + aTournament[0] +aTournament[1] +aTournament[2]);
      System.out.println ("Want to play another tournament (y/n)?");
      inputStr = scan.next();                            // Read and assign to String
      choice = inputStr.charAt(0);                       // Assign to character
    }while(choice != 'n' && choice != 'N');              // Loop while NOT n nor N
    scan.close(); 
    System.exit(0);                                      // Exit the game
  }
  
  
  
  // A move by a player
  public static void makeAmove(char player)  
  {
    int r;                              // r short for row to check the range within 1-3
    int c;                              // c short for column to check the range within 1-3
    boolean move = true;                // Boolean statement to continue or stop a move
    do
    {
      r = scan.nextInt();               // Scan any available spots in rows
      c = scan.nextInt();               // Scan any available spots in columns
      
      if (board[r-1][c-1]!=NUL_CHAR)    // If there is a spot open
      {
        move = true;                    // Then it is available to make a move
      } 
      else 
      {
        move = false;                   // If the spot isn't available, then the move can't place there
      }
    }while( move = false);              // Boolean statement to stop the move after
    r--;
    c--;
    
    board[r][c] = player;               //store the player into the array
    
  }
  
  
  // A layout of the 3X3 board
  public static void displayBoard()            
  {
    int r,c;                            // r short for row, c short for column
    
    System.out.println("-------------");// Start off by giving the top of the board
    for (r = 0; r < ROW; r ++)          // Start by checking each column from each row
    {
      System.out.print("|");            // Place the very first '|' for the row
      for (c = 0; c < COL; c ++)
      {
        if (board[r][c] == 'X')         // If 'X' is showing, then print 'X' in that specific spot
        {
          System.out.print(" X ");
        }
        else if (board[r][c] == 'O')    // If 'O' is showing, then print 'O' in that specific spot
        {
          System.out.print(" O ");
        }
        else if ( board[r][c] == NUL_CHAR) // If the spot is empty, leave it a blank
        {
          System.out.print("   ");
        }
        System.out.print("|");          // Close the board with the last '|' at the end
      }
      System.out.println();             // Crucial point! Leaving space everytime when you have something stored
      System.out.println("-------------");
    }   
  }     
  
  

  // Check if the who WINS the game 
  public static boolean isAwin(char ch) 
  {
    int r,c;                            // r short for row, c short for column
    
    // Checking column by column
    for( r = 0 ; r < 3 ; r++)           // Start by checking each column from each row
    {
      for( c = 0 ; c < 3 ; c++)
      {
        if(board[r][c] == ch)           // If the spot is the same as the pass-in ch
        {
          number++;                     // Then the number goes up by one
        }
        if(number == 3)                 // To check if the number equals 3
        {
          return true;                  // Then the check returns true to show who wins
        }
      }
     number=0;                          // Retore number back to zero to start over a new check
    }
    
    // Checking row by row
    for( c = 0 ; c < 3 ; c++)           // Start by checking each row from each column
    {
      for( r = 0 ; r < 3 ; r++)
      {
        if(board[r][c] == ch)           // If the spot is the same as the pass-in ch
        {
          number++;                     // Then the number goes up by one
        }
        if(number == 3)                 // To check if the number equals 3
        {
          return true;                  // Then the check returns true to show who wins
        }
      }
      number = 0;                       // Retore number back to zero to start over a new check
    }

    
    //checking diagonal
    if(board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) // Chekcing the first diagonal, /.
    {
      return true;                                                  // Returns true if there's a winner that spots these three points
    }
    if(board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) // Checking the second diagonal, \.
    {
      return true;                                                  // Returns true if there's a winner that spots these three points
    }
    return false;                                                   // Returns false if there's no one satisfies the two conditions
  }
  
      
      
      
// Check if the game is a DRAW or not
  public static boolean isAdraw(char ch)
  {
    char EMPTY = '\u0000';                // Insert empty spot
    int r, c;                             // r short for row, c short for column
    for( r = 0; r < 3; r++ )              // Start by checking each column from each row
    {
      for( c = 0; c < 3; c++ )
        if( board[ r ][ c ] == EMPTY )    // If there are any empty spots
      {
        return false;                     // Then return false to show there is no draw
      }
    }
    return true;                          // Return true when the board is full, then the game is a DRAW
  }
}







