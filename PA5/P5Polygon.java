/**  
 * Assignment 5           P5Polygon.java           Due Feb. 23, 2013 
 * login:  cs8bbf 
 **/ 
/**
 * P5Polygon()       - No argument constructor, initialize side to one
 * P5Polygon(double) - Overloaded constructor,  initialize side to parameter
 * toString()        - Format and return class name 
 * getName()    - Generates name of this class object and return as a String 
 * setDim(double)          - Assign 1 dimension  of a 2-D polygon  (side)
 * setDim(double,double)   - Assign 2 dimensions of a 3-D polygion(side, height)
 * perimeter()             - Calculate perimeter of a polygon
 * area()                  - Calculate area      of a polygion
 * volume()                - Calculate volume    of a polygion
 **/

//The abstract parent class(superclass), which its subclasses will inherit from 
public abstract class P5Polygon
{
  double side, height;
    
//No argument constructor
  public P5Polygon()                         
  {
    side = 1;
  }
  
//No argument constructor
  public P5Polygon(double s)         
  {
    side = s;
  }
  
//Format and return class name
  public String toString()                   
  { 
    return this.getName(); 
  }
  
//Generates name of this class obj
  public String getName()                    
  {
    return(this.getClass().getName() + ":  ");
  }
  
//Assign 1 dimension of a 2-D polygon
  public void setDim(double s)          
  {
    side = s;
  }
  
  //////////Abstract Methods/////////////
  //Assign 2 dimensions of a 3-D polygon
  public abstract void setDim(double s,double h); 
  //Calculate perimeter of a polygon
  abstract double perimeter();      
  //Calculate area of a polygon
  abstract double area();              
  //Calculate volume of a polygon
  abstract double volume();             
}