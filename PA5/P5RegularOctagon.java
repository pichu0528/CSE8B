/**  
 * Assignment 5            P5RegularOctagon.java            Due Feb. 23, 2013 
 * login:  cs8bbf 
 **/ 
/**
  * P5RegularOctagon()   - No argument constructor
  * P5RegularOctagon(s)  - Overloaded constructor, pass the side parameter to 
  * P5Polygon(s)
  * toString()       - Implement toString, format dimensions of an octagon
  * perimeter()      - Override and implement super class perimeter     
  * area()           - Implement super class area, calculate area of an octagon
  **/

import static java.lang.Math.*;   // Mathematical symbols


public class P5RegularOctagon extends P5Polygon
{
  
//No argument constructor
  public P5RegularOctagon(){}
  
//Overloaded constructor
  public P5RegularOctagon(double s) 
  {
    super(s); 
  }
  
//Override, return a String
  public String toString()          
  {
    return(this.getName() + side + "side");
  }
  
//Override, Calculate the perimeter of regular octagon
  public double perimeter()         
  {
    double perimeter = this.side*8;
    return perimeter;
  }
  
//Override super class area
  public double area()              
  {
    double L = side;
    double area = (2*(1+sqrt(2)))*(L*L);
    return area;
  }
  
//Return any values for the unused volume
  public double volume()            
  {
    return 1;
  }
  public void setDim(double s, double h){}
}
