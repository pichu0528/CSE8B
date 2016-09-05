/**  
 * Assignment 5           P5OctagonalPrism.java           Due Feb. 23, 2013 
 * login:  cs8bbf 
 **/ 
/**  
  * P55OctagonalPrism()   - No argument constructor, initialize height to one
  * P55OctagonalPrism(s,h)- Overloaded  constructor, initialize height to 
  * parameter
  * toString()     - Override, return a String with formatted dimensions of an 
  * octagonal prism 
  * setDim(s,h)   - Override, assign dimensions of an octagonal prism  
  * area()     - Override super class area, calculate area of an octagonal prism
  * volume()    - Override - Calculate volume  of an octagonal prism
  **/

public class P5OctagonalPrism extends P5RegularOctagon
{
  protected double height;
  
// No argument constructor
  public P5OctagonalPrism()         
  {
    super();
    height = (int) 1;
  }
 
//Overloaded constructor
  public P5OctagonalPrism(double s, double h) 
  {
    super(s);
    height = h;
  }
  
//Override, return a String
  public String toString()          
  {
    return(this.getName() + side + "x" + height);  
  }
  
//Override, assign dimensions 
  public void setDim(double s, double h) 
  {
    side = s;
    height = h;
  }

//Override, Calculate area for octagon bases
  public double area()
  {
    double area = (2*super.area()) + height*super.perimeter();
    return area;
  }
  
//Override-Calculate volume
  public double volume()                 
  {
    double volume = height*super.area();
    return volume;
  }
}