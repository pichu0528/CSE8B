/**  
 * Assignment 6           P6.java                     Due Mar. 2, 2013 
 * login:  cs8bbf 
 **/ 
/** 
 * class P6  - Class header comment 
 * init()             - Initialize applet
 * paint()            - Displays colored shape
 * itemStateChanged() - Called when user selects item from JComboBox, calls 
 *                      repaint()
 * actionPerformed()  - Called when user clicks on the Radio Buttons, calls 
 *                      repaint()
 * 
 **/

/**
 * @see javax.swing.JApplet;
 * @see javax.swing.ButtonGroup;
 * @see javax.swing.JRadioButton;
 * @see javax.swing.JComboBox;
 * @see java.awt.Color;
 * @see java.awt.FlowLayout;
 * @see java.awt.event.ItemListener;
 * @see java.awt.event.ActionListener;
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class P6 extends JApplet implements ItemListener, ActionListener
{
  private int x1 = 20,  y1 = 100;               // Upper left coord
  private int x2 = 500, y2 = 500;               // Lower right coord
  
  private String [] shapeNames = {"Arc","Line","Oval", "Round_Rect", "Polygon"};
  static int shape;
  
  // JRadioButton references
  private JRadioButton jrbRed, jrbYellow, jrbBlue, jrbGreen;
  private JComboBox<String> shapeComboBox;      // Shape combo box reference
  private Color color;                          // Color reference
  private int[] x3 = {x1,x2,x1+((x2-x1)/2),x1,x2};
  private int[] y3 = {y1,y1,y1+(y2-y1)/2,y2,y2};
  
  public void init()
  {
    // Insert code for JComboBox and JRadioButtons 
    String [] shapeNames = {"Arc","Line","Oval","Polygon"};
    JComboBox<String> shapeComboBox;
    shapeComboBox = new JComboBox<String>(shapeNames);//Instantiate JComboBox reference
    shapeComboBox.addItemListener(this);      // Register listener to JComboBox
    
    ButtonGroup bGroup = new ButtonGroup();   // Radio button manager
    JRadioButton jrbRed,jrbYellow,jrbBlue,jrbGreen; // JRadioButton references
    
    jrbRed = new JRadioButton("Red");         // Instantiate Red radio button
    jrbRed.setForeground( Color.red );        // Red colored text label
    jrbRed.setBackground( Color.black );      // Black button 
    
    jrbYellow = new JRadioButton("Yellow");   // Instantiate Yellow radio button
    jrbYellow.setForeground( Color.yellow );  // Yellow colored text label
    jrbYellow.setBackground( Color.black );   // Black button 
    
    jrbBlue = new JRadioButton("Blue");       // Instantiate Blue radio button
    jrbBlue.setForeground( Color.blue );      // Blue colored text label
    jrbBlue.setBackground( Color.black );     // Black button 
    
    jrbGreen = new JRadioButton("Green");     // Instantiate Green radio button
    jrbGreen.setForeground( Color.green );    // Green colored text label
    jrbGreen.setBackground( Color.black );    // Black button 
    
    bGroup.add(jrbRed);                       // Group for Radio Button
    bGroup.add(jrbYellow);                    // Group for Radio Button
    bGroup.add(jrbBlue);                      // Group for Radio Button
    bGroup.add(jrbGreen);                     // Group for Radio Button
    
    setLayout( new FlowLayout());             // Set FlowLayout manager
    add(jrbRed);                              // Place radio button on applet
    add(jrbYellow);
    add(jrbBlue);
    add(jrbGreen);
    add(shapeComboBox);
    //setBackground( Color.white );             // Applet background white
    
    jrbRed.setSelected(true);                 // Default color for shape
    jrbRed.addActionListener(this);           // Register listerner...
    jrbYellow.setSelected(true);              // Default color for shape
    jrbYellow.addActionListener(this);        // Register listerner...
    jrbBlue.setSelected(true);                // Default color for shape
    jrbBlue.addActionListener(this);          // Register listerner...
    jrbGreen.setSelected(true);               // Default color for shape
    jrbGreen.addActionListener(this);         // Register listerner...
  }
  
  public void paint( Graphics g )
  {
    super.paint(g);
    g.drawRect( x1, y1, x2-x1, y2-y1);        // Bounding rectangle
    if (shape == 0)                           // Acr
    {
      g.fillArc(x1, y1, x2-x1, y2-y1, 0, 40);
      g.fillArc(x1, y1, x2-x1, y2-y1, 90, 40);
      g.fillArc(x1, y1, x2-x1, y2-y1, 180, 40);
      g.fillArc(x1, y1, x2-x1, y2-y1, 270, 40);
    }
    else if(shape == 1)                       // Line
    {
      g.drawLine(x1, y1, x2, y2);
  
    }
    else if(shape == 2)                       // Oval 
    {
      g.fillOval( x1, y1, x2-x1, y2-y1);
    }
    else if(shape == 3)                       // Polygon
    {
      g.fillPolygon(x3,y3,5);
    }
    //g.setColor(color);                      // Radio button choice
    // Display selected shape
  }
  
  public void itemStateChanged( ItemEvent e)
  {
    shape = shapeComboBox.getSelectedIndex();
    repaint();
  }
  
  
  public void actionPerformed( ActionEvent e)
  {
    if (e.getSource() == jrbRed)
    {
      color = Color.red;
    }
    else if (e.getSource() == jrbYellow)
    {
     color = Color.yellow;
    }
    else if (e.getSource() == jrbBlue)
    {
      color = Color.blue;
    }
    else if (e.getSource() == jrbGreen)
    {
      color = Color.green;
    }
    repaint();
    validate();
  }
}
      