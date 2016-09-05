/**  
 * Assignment 7           P7.java                     Due Mar. 9, 2013 
 * login:  cs8bbf 
 **/ 
/** 
 * class P7  - Class header comment 
 * In this program I have to declare the checked exception IOException,
 * which excludes NumberFormatException, ArrayIndexOutOfBoundsException,
 * and Exception.This program allows to have 5 quizzes to get entered. 
 * And it will find the LARGEST input to be calculated as the maximum 
 * throughout the 5 quizzes that have passed in.
 **/

import java.io.*;
  
class P7
{
  private static final int ASIZE = 5;           // Array size
  private static int []qz = new int [ASIZE];    // 5 element array
  
  public static void main(String [] args) throws IOException
  {
    String inputStr;                            // Input line 
    String []s;                                 // Array of String from input
    
    
    // Contains readLine(). Create new instance for stdin System.in
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

    System.out.print("ENTER 5 QUIZES (range 0-10) : ");
    System.out.flush();
    
    while((inputStr = in.readLine()) != null)
    {    
      s = inputStr.split(" ");                 // Parse into tokens
      
      try
      { 
        // If the size of the array is less than 5
        if(s.length < ASIZE)         
        {
          System.out.println(inputStr);        // Print out the inputs
       // Error message that tells there are less than 5 scores are entered
          System.err.println(
                          "\tERROR! Entered less than 5 quizzes. Enter again.");
        }
        else
        {
          for(int i = 0; i < s.length; i++)    // For loop to check the array
          {
            qz[i] = Integer.parseInt(s[i]);    // Assign string to int array
            /*If the entered values is less than 0 or greater than 10, then 
               throw an exception*/
            if(qz[i] > 10 || qz[i] < 0)        
            {
              throw new Exception();
            }
          }
          
          System.out.print("Input: "+ inputStr);  // Print out the inputs
          System.out.print("\n");                 // Insert a blank line
          max(); 
        }
      }
      
      // NumberFormatException catches invalid entries that aren't int
      catch( NumberFormatException e )
      {
        System.out.print("Input: "+ inputStr +" are not valid quiz scores.");
        // Insert a blank line
        System.out.print("\n");                   
        // Print stack trace to spot the error
        e.printStackTrace();                      
      }
      
      /* ArrayIndexOutOfBoundsException catches arrays that have over 5 scores
        entered. But the calculation of max() still works for the first 
        5 scores*/
      catch( ArrayIndexOutOfBoundsException e )
      { 
        System.out.println("Input: " + inputStr);
        System.out.println("       Enter more than 5 quizzes.");
        System.out.println("       First 5 scores accepted.  Continuing...");
        max();        // max() implements on the first 5 scores that are entered
      }
      
      // An exception to spot if the array is out of range
      catch( Exception e )
      {
        System.out.println( inputStr );
        System.out.println("       Error! Out of range 0-10. Enter again.");
      }
      
      // Finally
      System.out.print("\n");
      System.out.print("\nEnter 5 Quizzes (range 0-10) : ");
      // System that clears everything
      System.out.flush();                       
    }
  }
  
  public static void max()
  {
    int max = qz[0];                  // Set max to the first input       
    for(int i = 0; i < qz.length; i++)// Check is the array is in the length,5
    {
      if ( qz[i] > max )              // If one of the input is greater than max
      {
        max = qz[i];                  // Assign the greater input to max 
      }
    }
    System.out.print("Largest value of the 5 quizzes is: "+ max);
  }
}