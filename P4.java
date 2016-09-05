/**  
 * Assignment 4           P4.java                     Due Feb. 9, 2013 
 * login:  cs8bbf 
 **/ 
/** 
 * class P4  - Class header comment 
 * Use 1D array to organize the alphabetical order of the words that I enter according to the 
 * prefixes. And then using 2D array to sort how many words have the same prefixes, and how many
 * different prefixes.
 * 
 **/

import java.util.Scanner;                                       // Read sentence from keyboard

public class P4
{ 
  public static void main(String [] args)
  {
    String sentence;                                              // Read line
    Scanner scan = new Scanner (System.in);                       // Read input from keyboard
    
    System.out.print("Enter your words to be sorted (exit ^D): ");
    do
    {
      sentence = scan.nextLine();                                 // Read entire line
      String words[] = sentence.split(" ");                       // Allocate words input
      
      sort1D(words);                                              // Sort 1-D array of Strings
      
      System.out.print("1-D Sorted: ");
      for(int i = 0; i < words.length ; ++i)                      // Place into array
        System.out.print(words[i] + "  ");
      System.out.println();
      
      sort2D(words);                                              // Sort 1-D array of Strings
      
      System.out.print("Enter your words to be sorted (exit ^D): ");
    }while(scan.hasNext());                                       // Loop until no more input lines
    System.exit(0);                                               // Terminates current JVM
  }
  
  // Sort all the alphabets in 1D array from A-Z or a-z 
  public static void sort1D(String [] w)
  {
    String tmp;                                                   
    //Change from this Bubble sort to Selection sort
    for(int i = 0; (i < w.length-1) && (w[i] != null); ++i)
    {
      for (int j = w.length-1; i < j && (w[j] != null); --j)
      {
        if ( w[j-1].compareToIgnoreCase(w[j]) > 0)                 // Sort words - case insensitive
        {
          tmp = w[j-1];
          w[j-1] = w[j];
          w[j] = tmp;
        }
      }
    }
  }
  public static void sort2D(String [] sw)
  {
    final int ALPHA = 26;                                      // 26 letters in the alphabet - # of rows
    
    boolean nextAlpha = false;                                 // Sequence to next alpha letter
    char A = 'A';                                              // 1st letter of alphabet uppercase
    char a = 'a';                                              // 1st letter of alphabet lowercase
    int i, j;                                                  // instance variables
    int col=0;                                                   // Number of words start with letter
    String a2D[][] = new String[ALPHA][];                      // Allocate 26 rows for each alpha letter
    
    // Initialize a2D with nulls
    
    for ( i = j = 0; j <= a2D.length; ++j )                    // Alloc 26 elements for alphabet
    {
      if ( col > 0 )
        a2D[j-1] = new String[col];                            // Alloc row with # words start with letter
      
      nextAlpha = false;
      for( col = 0; ( i < sw.length) && !nextAlpha ; ++i)
      {
        if(sw[i] == null)                                      // No words start with letter, skip to next alpha
        {
          nextAlpha = true;
          break;
        }
        
        // If 1st letter of sw[i] matches 'A' or 'a' then increment col counter
        else if (sw[i].charAt(0) == A || sw[i].charAt(0) == a )
        {
          nextAlpha = false;
          col++;
        }
        // Else the alphabet goes to B and b, C and c, and so on.
        else
        {
          A++;
          a++;
          break;
        }
      }
    }
    
    // additional variable, counter, to keep track of the position in the 1D array  
    int counter = 0;
    // Nested for loop to assign from sw[] into a2D delimited by length of each row
    for (i = 0; i < a2D.length; i++)    // Check the rows, they have to be less than 26 
    {
      if (a2D[i] != null)                                       // If there is a word sorted in the array, then continue to for loop
        for ( j = 0; j < a2D[i].length; counter++,j++)          
      {
        a2D[i][j] = sw[counter];
        System.out.println("a2D" + "[" + i + "]" + "[" + j + "]" + ": " + sw[counter]);
      }
      
    }
    
  }
}

      
 