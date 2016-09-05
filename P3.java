/**  
 * Assignment 3           P3.java                     Due Feb. 2, 2013 
 * login:  cs8bbf 
 */

/** 
 * class P3  - Class header comment 
 * File: P3.java 
 * Program P3 consists of 2 classes: P3BDay and P3
 *    P3BDay: data members and methods for month and day
 *    P3: public application driver class to display a day of the week
 */

import java.util.Scanner;                   // Read keyboard input
import java.text.DecimalFormat;             // Floating point format


/**
 * class P3BDay           - Package access
 * public P3BDay()        - No argument constructor
 * public P3BDay(int,int) - Overloaded ctor
 * 
 * getMon()               - Return month 
 * getDay()               - Return day
 * isValid()              - Test range of all inputs: month (1-12), day (1-31)
 * setBday()              - Assign inputs to month, day ( calls isValid() )
 * toString()             - Format month/day into string
 * 
 * isLeapBaby()           - Test if a leap year birthday, February 29th
 * dayOfYear()            - Calculate number of the day in the year e.g. 3 (1/3/13)
 * dayOfWeek()            - Calculate name of the day in the week   e.g. "Tuesday"
 */
class P3BDay
{
  static final int YEAR = 2013;                  // Package access to P3 driver
  static final int TOTAL_MONTHS = 12;            // 12 months a year
  static final int LESS_DAYS = 30;               // Some months have 30 days
  static final int MORE_DAYS = 31;               // Some months have 31 days
  static final int NORMAL_FEB = 28;              // A normal February 
  static final int LEAP = 29;                    // February in a leap year 
  /////Fields/////
  private int month = 0, day = 0;                // Data members
  /////Constructors/////
  public P3BDay()                                // No argument constructor init to 1/08/2013
  {
   month = 1;
   day = 8;
  }
  public P3BDay ( int m, int d )                 // Overloaded ctor init to parameters
  {
   this.month = m;
   this.day = d;
  }
    
  public int getMon()                            // Return month
  {
    return this.month;
  }
  public int getDay()                            // Return day
  {
    return this.day;
  }
  
  // Check the validity of day and month for a birthday
  private boolean isValid ( int m, int d )
  {
   boolean check = true;                         // a boolean check
     
     //check the range if it is between 1 and 12, if not print the statement
     if( m > TOTAL_MONTHS || m < 1)
     {
       System.out.println("ERROR - Month legal range 1-12!");
       check = false;
     }
     
     // if month is one of 1,3,5,7,8,10, and 12, the month will have 31 days (1-31)
     if( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 )
     {
       if(d < 1 || d > MORE_DAYS )
       {
         check = false;
       }
     }
     
     // for february, it has 29 days. check if the entered days are in the range (1-29)
     else if( m == 2 )
     {
       if( d < 1 || d > LEAP )
       {
         check = false;
       }
     }
     
     // if month is one of 4, 6, 9, and 11, the month will have 30 days (1-30)
     else
     {
       if( d < 1 || d > LESS_DAYS )
       {
         check = false;
       }
     }
     
     // if recieved check == false, then will print the statement
     if( check == false )
     {
       System.out.println("ERROR - Birthday NOT in legal range!");
       return false;
     }
     return true;
     
  }
  
  // Set day and month into desired variables
  public  boolean setBday ( int m, int d )
  { 
    if(isValid(m,d))
    {
      month = m;
      day = d;
      return true;
    }
    else
    {
      return false;
    }
  }
  
  // Return formatted date values
  public  String  toString()                     
  {
    int m = month;
    int d = day;
    DecimalFormat df = new DecimalFormat("00");  // 2 digits wide, zero filled
    return  (df.format(m) + "/" + df.format(d) + "/" + YEAR);
  }
  
  // Check if the day and month that entered are on the leap day
  public boolean isLeapBaby()                    // Return true if 2/29
  {
    int m = month;
    int d = day;
    if ( m == 2 && d == 29 )
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  // Calculate how many days from January first to the date and month that entered
  public int dayOfYear()                         // Return day of the year (1-365)
  {
    int m = month;
    int d = day;
    int count = 0;
    
    // Switch statement to calculate the days
    switch(m)
    {
      case 1: return count = d; 
      case 2: return count = MORE_DAYS + d; 
      case 3:return count = MORE_DAYS + NORMAL_FEB + d; 
      case 4:return count = 2*MORE_DAYS + NORMAL_FEB + d;
      case 5:return count = 2*MORE_DAYS + LESS_DAYS + NORMAL_FEB + d; 
      case 6:return count = 3*MORE_DAYS + LESS_DAYS + NORMAL_FEB + d;
      case 7:return count = 3*MORE_DAYS + 2*LESS_DAYS + NORMAL_FEB + d;
      case 8:return count = 4*MORE_DAYS + 2*LESS_DAYS + NORMAL_FEB + d; 
      case 9:return count = 5*MORE_DAYS + 2*LESS_DAYS + NORMAL_FEB + d;
      case 10:return count = 5*MORE_DAYS + 3*LESS_DAYS + NORMAL_FEB + d;
      case 11:return count = 6*MORE_DAYS + 3*LESS_DAYS + NORMAL_FEB + d;
      case 12:return count = 6*MORE_DAYS + 4*LESS_DAYS + NORMAL_FEB + d;
    }
    return count;
  }
  
  // Categorize the day and month that entered from "Monday" till "Sunday"
  public String dayOfWeek()                     // Return day of the e.g. "Sunday"
  {
    int d = day;
    String day = "";
    
    // Leap year occurs on a "fun day"
    if(isLeapBaby())
    {
      return day = "*****FUN day****!";
    }
    
 
    d = dayOfYear();
    switch(d % 7)
    {
      case 1: return day = "Tuesday"; 
      case 2: return day = "Wednesday";  
      case 3: return day = "Thursday"; 
      case 4: return day = "Friday";
      case 5: return day = "Saturday";  
      case 6: return day = "Sunday"; 
      case 0: return day = "Monday";  
    }
    return day;
  }
  
}

/**
 * public class P3
 * This is the application driver class to first state the due date of this PA
 * and then state the date of the first lecture for CSE8B. Later we enter 
 * the birthday date, and the program will run to see its validity, its number of
 * days in a year, and its day of a week.
 *
 */
public class P3
{
  /**
   * Instantiates 2 P3BDay objects representing a day in the year.
   * Allows input of a month and day to calculate its occurrence of the day 
   * of the week. Displays the day of the week.
   */
  public static void main (String[] args)
  {
    final int DUE_MONTH = 2;                     // February 
    final int DUE_DAY   = 2;                     // 02/2 is PA#3 due date
    
    boolean validDay;                            // Boolean for error input
    char    choice;                              // Repeat program
    int     m, d;                                // Temporaries for input
    
    Scanner scan = new Scanner (System.in);      // Read input from keyboard
    String inputStr;                             // Repeat input
    
    P3BDay firstDay = new P3BDay();              // No arg ctor, init to 01/08/2013
    P3BDay bday = new P3BDay(DUE_MONTH,DUE_DAY); // Overloaded 2 int ctor
    
    System.out.print("PA#3 is due on " + bday);
    System.out.println(" which occurs on a " + bday.dayOfWeek());
    
    System.out.print("The first day of lecture is " + firstDay);
    System.out.println(" which occurs on a " + firstDay.dayOfWeek());
    
    do
    {
      do
      {
        System.out.print("Enter your birthday month and day (1 22): ");
        m = scan.nextInt();                      // Assign to int for month 
        d = scan.nextInt();                      // Assign to int for day
        if ( validDay = bday.setBday(m,d))       // Assign if legal
          System.out.println( bday + " occurs on a " + bday.dayOfWeek());
        else
        {
          System.out.printf("%02d/%02d/%d is an", m, d, P3BDay.YEAR);
          System.out.println(" INVALID birthday - enter AGAIN");
        }
      }while(!validDay);                         // Repeat program
      
      System.out.print("\nWant another birth date (y/n)? ");
      inputStr = scan.next();                    // Read and assign to String
      choice = inputStr.charAt(0);               // Assign to character
      
    }while( choice != 'n' && choice != 'N');     // Loop not 'n' nor 'N'
    
    scan.close();                                // Close this scanner
    System.exit(0);                              // Close connections
  }
}
