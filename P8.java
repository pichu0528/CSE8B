/**  
 * Assignment 8           P8.java            Due Mar. 16, 2013 
 * login:  cs8bbf 
 **/ 
/**
 * This program is for fundamental File (I/O) using command line arguments.
 * It is made to read simple JAVA source code files. This program will 
 * perform two phases of a compiler, lexical analysis and parser.
 * The lexical analyzer separates characters of the source language into tokens. 
 * These tokens will be the primitive data types and simple identifiers. Later,
 * the tokens are passed in to the parser. The parser gather tokens into 
 * syntactic structure. 
 * At the end, the result will show errors and warnings that are made in those
 * simple JAVA source code files and will show what type of error it is and 
 * what line it is.
 * 
 * @see java.io
 * @see.java.lang
 * @see.java.text
 **/
import java.io.*;
import java.lang.*;
import java.text.*;
public class P8
{
  LineNumberReader in = null; // A call to read lines
  
  public static void main(String args[]) throws Exception
  {
    LineNumberReader in;
       
    String token[]; // String array to store tokens
    int semi; // The index of the last semicolon
    int error = 0; // Error 
    int warning = 0; // Warning 
    
    // Read the file passed in
    in = new LineNumberReader(new FileReader(new File(args[0])));
    FileInputStream inFstream;
    
    // DecimalFormat to show two digits
    DecimalFormat df = new DecimalFormat("00"); 
    
    
    try
    {
      // Get the passed in file
      File file = new File (args[0]);
      inFstream =new FileInputStream(file);
      
      // Store the string
      String line;
      
      while((line=in.readLine())!=null)
      {
        // To check if the line ends with a semicolon
        if(line.endsWith(";")) 
        {
          semi = line.lastIndexOf(';'); // Get the index of the last semicolon 
          line = line.substring(0,semi); // Delete the last ";"
          line = line.trim(); // Get rid of the spaces 
          token = line.split(" "); // Tokenize the line 
          
          // To check if it is a public access modifier
          if(isPublicVar(token[0]) == true)
          {
            System.out.println(file + ":" + df.format(in.getLineNumber()) +
                               ": warning \"public\" access instance var");
           
            line = line.substring(6);
            line = line.trim();
            token = line.split(" "); //tokenize into string
            warning++;
          }
          
          // To check if the data type is valid or invalid
          if(isDataType(token[0]) == false)
          {
            System.out.println(file + ":" + df.format(in.getLineNumber()) +
                               ": \"" + token[0] + "\" , data type unknown"); 
            error++;
          }
          else
          {
            // Get rid off data type from line
            line = line.substring(token[0].length());
            line = line.trim();
            
            /* To check if line has no identifier class which means the 
            identifier is missing*/            
            if( line.length() < 1 || line.indexOf(",") == 0 )
            {System.out.println(file + ":" + df.format(in.getLineNumber()) +
                                ": no identifier specified");
              error++;
            }
            // Else there is an identifier
            else
            {
              String idArray[];          // Identifier array
              idArray = line.split(","); // Tokenize the identifier
              
              for(int i = 0 ; i < idArray.length; i++)
              {
                // Once again, check if there is any identifiers
                if (idArray[i].indexOf(" ") == 0)
                {
                  System.out.println(file + ":" + df.format(in.getLineNumber())+
                                     ": no identifier specified"); 
                  error++;
                }
                else
                {
                  // To check if identifier starts with legal characters
                  if( isStartID(idArray[i]) == false)
                  {
                    System.out.println(file + ":" +
                     df.format(in.getLineNumber()) + ": \'" +
                     idArray[i].charAt(0) +
                     "\': invalid first character of identifier, "+ idArray[i]);
                   error++;
                  }
                  else 
                  {
                    // To check if the identifier name is available
                    if( isID(idArray[i]) != -1)
                    {
                      System.out.println(file +
                                         ":" + df.format(in.getLineNumber()) +
                                         ": \'" + line.charAt(isID(idArray[i]))+
                                       "\': invalid character in identifier, "
                                           + idArray[i]);
                      error++;
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      System.out.println( warning + " warning");
      System.out.println( error + " errors");
    }
    //@exception if there is no files turned in
    catch(FileNotFoundException e)
    {
      System.out.println("ERR: "+args[0]+" not found!");
    }
  }
  

  
///////////////////////// M E T H O D S //////////////////////////////  
  
 // A method to check if the parameter is a legal primitive data type. 
  public static boolean isDataType(String type)
  {
String data[] ={"byte","boolean","char","int","double","float","short","long"};
    boolean fine = false;
    for (int i=0 ; i < data.length; ++i)
    { 
      if ( data[i].equals(type))
      {
        fine = true;
      }
    }
    return fine;
  }
  
  // A method to check if the parameter starts with a legal letter
  public static boolean isStartID(String a)
  {
    if (Character.isJavaIdentifierStart(a.charAt(0)))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  
  //A method to check if the parameter is a legal name.  
  //@return -1 if it is a valid identifier
  public static int isID(String a)
  {
    
    for(int i = 0 ; i < a.length(); i++)
    {
      if (Character.isJavaIdentifierPart(a.charAt(i)))
      {}
      else
      {
        return i;
      }
    }
    return -1;
  }
  
  // A method to check if the parameter is public
  public static boolean isPublicVar(String access)
  {
    if(access.equals("public"))
      return true;
    else
      return false;
  }
  
}