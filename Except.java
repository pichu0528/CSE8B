import java.io.*;

public class Except
{
  public static void main(String args[]) throws IOException
  {
    int num;
    int smallest = Integer.MAX_VALUE;
    String str = null;
    
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    System.out.print("enter a number to find the minimum: ");
    System.out.flush();
    
    while((str = in.readLine()) != null)
    {
      try 
      {
        num = Integer.parseInt(str);
        if(num < smallest)
          smallest = num;
      }
      catch (NumberFormatException e )
      {
        System.err.println("Error: " + str + " is an invalid integer!");
      }
      System.out.print("enter a number to find the minimum: ");
      System.out.flush();
      
    }
    System.out.println("\nThe smallest number is: " + smallest);
  }
}