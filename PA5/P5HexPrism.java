/**  
 * Assignment 5            P5HexPrism.java            Due Feb. 23, 2013 
 * login:  cs8bbf 
 **/ 
/**
 * P5HexPrism()    - No argument constructor, initialize height to one
 * P5HexPrism(s,h) - Overloaded  constructor, initialize height to parameter
 * toString()      - Override, return a String with formatted dimensions of a 
 * hexagonal prism 
 * setDim(s,h)     - Override, assign dimensions of a hexagonal prism  
 * area()    - Override super class area, calculate area of a hexagonal prism
 * volume()  - Override - Calculate volume  of a hexagonal prism
 **/

public class P5HexPrism extends P5RegularHex
{
  protected double height;
  
//No argument constructor
  public P5HexPrism()                  
  {
    super();
    height =(int) 1; 
  }
 
//Overloaded constructor
  public P5HexPrism(double s, double h)
  {
    super(s);  
    height = h;
  }
  
//Override, return a String
  public String toString()              
  {
    return(this.getName() + side + "x" + height); 
  }
  
//Override, assign dimensions of hexPrism
  public void setDim(double s,double h)
  {
    side = s;
    height = h;
  }
  
//Override super class area
  public double area()                 
  {
    double area = (2*super.area())+(height*super.perimeter());
    return area;
  }
  
//Override-Calculate volume of a hexPrism
  public double volume()               
  {
    double volume = height*super.area();
    return volume;
  }
}