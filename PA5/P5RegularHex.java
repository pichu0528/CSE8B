/**  
 * Assignment 5           P5RegularHex.java           Due Feb. 23, 2013 
 * login:  cs8bbf 
 **/ 
/**
  * P5RegularHex()  -No argument constructor
  * P5RegularHex(s) -Overloaded constructor, pass the side parameter to P5Polygon(s)
  * toString()      -Implement toString, format dimensions of a hexagon
  * perimeter()     -Override and implement super class perimeter     
  * area()          -Implement super class area, calculate area of a hexagon
  **/
import static java.lang.Math.*;   // Mathematical symbols

public class P5RegularHex extends P5Polygon
{  
  protected double L = this.side;
  protected double COEFFICIENT = ((3*((sqrt(3))))/2);
  protected double Area_of_regular_hexagon;
  
//No argument constructor
  public P5RegularHex(){}
  
//Overloaded constructor
  public P5RegularHex(double s)  
  {
    super(s); 
  }
  
//Implement toString, format dimensions of a hexagon
    public String toString() 
  {
    return(this.getName() + side + "side"); 
  }
  
//Override and implment super class perimeter
  public double perimeter() 
  {   
    return(6*L); 
  }
  
//calculate area of a hexagon
  public double area()      
  {
    Area_of_regular_hexagon = COEFFICIENT*(L*L);
    return(Area_of_regular_hexagon);
  }
  
//Return any value for the unused volume 
  public double volume()    
  {
    return 1;
  }
  
  public void setDim(double s, double h){}
}
