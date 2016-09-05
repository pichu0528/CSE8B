/**
 * Assignment 1                          P1.java                         Due: Jan, 19, 2013
 * Login in: cs8bbf
 **/
 
/**
 * Class P1 - Class header comment
 * This program takes in number(s) of student(s) with grades, and categorizes their grades in A,B,C,D,E.
 * At the end, it gives you the average from the grades of the student(s) and shows you how many people 
 * are below or above average.
 * This program will repeat and calculate as many times as we want with different number(s) of student(s),
 * grades, and average.
 **/

import java.util.*;  // Scanner for input

public class P1
{
  public static void main ( String args[] )
  {
    final int MIN = 0;                      // Minimum
    final double A_PERCENT = .90;           // 90% letter grade A
    final double B_PERCENT = .80;           // 80% letter grade B
    final double C_PERCENT = .70;           // 70% letter grade C
    final double D_PERCENT = .60;           // 60% letter grade D
    final int MAX_STUDENTS = 10;
    boolean errFlag = false;                // Error flag input scores range check
    char choice;                            // Repeat loop
    double tmp;                             // Temporary unput for scores
    double []scores;                        // Array of scores
    Scanner scan = new Scanner (System.in); // Read input from keyboard
    String inputStr = null;                 // Input string reference
    int numStudents = 1;                    // initialized the number of student
    int numLetters[];                       // an array that stores letters of the grade

    
    do
    {
      do                                                                       // Do-while loop to pass in number(s) of student(s)
      {
        System.out.print ( "Enter number of students(");                        
        System.out.println ((MIN + 1) + "-" + MAX_STUDENTS + ") : ");           
        numStudents = scan.nextInt();                                          // Assign to integer
        if (numStudents > MAX_STUDENTS || numStudents <= 0)                    // If statement: check the number(s) of student(s) is/are in the range 1-10
        {
          System.out.println ("ERROR: Enter an integer in the range of 1-10!");
        }
      } while(numStudents > MAX_STUDENTS || numStudents<=0 );                  // Status that exits out this loop and carry on
    
    
    
      System.out.println(" Enter " + numStudents + " scores (0-100):");        
      errFlag = true;                                                          // errflag to execute the while loop
      while ( errFlag )
      {
        scores = new double [numStudents];                                     // Allocate array scores according to the number(s) of student(s)        
        for (int i = 0 ; i < scores.length; i++ )
        {
          tmp = scan.nextDouble();                                             // Read input into temporary variable
          scores[i] = tmp;
        
          if ( 0 > scores[i] || scores[i] > 100)
          {
            errFlag = true;                                                    // Invalid scores
            System.out.println ("ERROR: Enter number(s) in the range of 0-100!");
            System.out.println (" Enter all " + numStudents + " scores again:");
            i = -1;
            scan.nextLine();
          }
          else                                                                 // Valid scores
          {
            errFlag = false;
          }
        }
      
        
        
        
        
        
        char letterGrade[]=new char[numStudents];                              //char array for student letter grade
        double maxScore = 0.0;                                                 
        
        for (int i=0; i < scores.length;i++)                                   // Find maxScore 
        {
          if (scores[i] > maxScore)
          {
            maxScore = scores[i];
          }
        }
        
        for ( int i = 0; i < numStudents ; i++)                                // Categorize grades by Letters with for loop
        {
          double score = scores[i];
          double percent = score / maxScore;
          if ( percent >= A_PERCENT )                                              
          {
            letterGrade[i] = 'A';
            System.out.println ("Student # " + (i+1) + " score is " + scores[i] + " and grade is A");
          }
          else if (B_PERCENT <= percent )
          {
            letterGrade[i] = 'B';
            System.out.println ("Student # " + (i+1) + " score is " + scores[i] + " and grade is B");
          }
          else if (C_PERCENT <= percent )
          {
            letterGrade[i] = 'C';
            System.out.println ("Student # " + (i+1) + " score is " + scores[i] + " and grade is C");
          }
          else if (D_PERCENT <= percent )
          {
            letterGrade[i] = 'D';
            System.out.println ("Student # " + (i+1) + " score is " + scores[i] + " and grade is D");
          }
          else if (percent < D_PERCENT )
          {
            letterGrade[i] = 'F';
            System.out.println ("Student # " + (i+1) + " score is " + scores[i] + " and grade is F");
          }
          
        }
        
        
        
        numLetters = new int[5];                                               // Array that assigns five letters of grades
        for (int i=0;i<numStudents;i++)                                        // Count number of each letter
        {
          switch (letterGrade[i]) 
          {
            case 'A':numLetters[0]++; 
            break;
            case 'B':numLetters[1]++; 
            break;
            case 'C':numLetters[2]++; 
            break;
            case 'D':numLetters[3]++; 
            break;
            case 'F':numLetters[4]++;
          }
        }
        
        System.out.println ("Number of a: " + numLetters[0]);
        System.out.println ("Number of b: " + numLetters[1]);
        System.out.println ("Number of c: " + numLetters[2]);
        System.out.println ("Number of d: " + numLetters[3]);
        System.out.println ("Number of f: " + numLetters[4]);
        
        
        
        double avg = avg(scores);                                              // Execute average method
        System.out.println ("Average is: " + avg);
        
        
        
        
        int y = 0; 
        int z = 0;
        for (int i = 0; i < scores.length; i++)                                // Count numbers of grades that are over and not over average
        {
          if (scores[i] >= avg )
          {
            y++;
          }
          else 
          {
            z++;
          }
          
        }
        System.out.println ("Number of scores >= average: " + y);
        System.out.println ("Number of scores < average: " + z);
      }
      
      
      
      
      System.out.print ("Want to calculate grades(y/n)?");
      inputStr = scan.next();                                                 // Read and assign to String
      choice = inputStr.charAt(0);                                            // Assign to character
    }while(choice != 'n' && choice != 'N');                                   // Loop while NOT n nor N
    
    scan.close();                                                             // Close Scanner
    System.exit(0);                                                           // Terminate with successful exit
  }
  
  
  
  
  public static double avg(double[] a)                                        // Average method
  { 
    double total = 0.0;
    for(int i = 0 ; i < a.length; i++)
    {
      total = total + a[i];
    }
    return total/a.length;                                                    // Return the result 
  }
}




      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
     
      
       