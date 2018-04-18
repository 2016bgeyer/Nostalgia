// Name:Ben Geyer 				Date:

   import java.awt.*;
   
   public class Bumper
   {
    //private fields, all ints, for a Bumper
    //hint: the "location" of the bumper begins at its top left corner.      
      private Color myColor;
      private int myX;
      private int myY;
      private int myXWidth;
      private int myYWidth;
    
    
   
   
     //constructors
      public Bumper()         //default constructor
      {
         myX = 200;
         myY  = 200;
         myColor = Color.green;
         myXWidth = 50;
         myYWidth = 60;
      }
      public Bumper(int x, int y, int xWidth, int yWidth, Color c)
      {
         myX = x;
         myY  = y;
         myColor = c;
         myXWidth = xWidth;
         myYWidth = yWidth;
      }
      public Color getColor()
      {
         return myColor;
      }
      public int getX()
      {
         return myX;
      }
   	
      public int getY()
      {
         return myY;}
   	
   	
      public int getYWidth()
      {
         return myYWidth;}
   	
      public int getXWidth()
      {
         return myXWidth;}
      
     // accessor methods  (one for each field)
   public Color setColor(Color c)
      {
         myColor = c;
			return c;
      }
      public int setmyX( int x)
      {
         myX = x;
			return x;
      }
   	
      public int setmyY( int x)
      {
         myY = x;
			return x;
      }
		
		public int setmyXWidth( int x)
      {
          myXWidth = x;
			return x;
      }
		public int setmyYWidth( int x)
      {
         myYWidth = x;
			return x;
      }
     // modifier methods  (one for each field)
   
     // instance methods
	  public void jump(int rightEdge, int bottomEdge)
      {
         // moves location to random (x, y) within the edges
         myX = (int)(Math.random()* (rightEdge-myXWidth) + (myXWidth/2));
         myY = (int)(Math.random()* (bottomEdge-myYWidth) + (myYWidth/2));
      }
     // chooses a random (x,y) location.  Bumper stays entirely in the window.
         
     
      
       // draws a rectangular bumper on the buffer
      public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(getColor());
         myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
      }   
   	// returns true if any part of the polkadot is inside the bumper
      public boolean inBumper(Polkadot dot)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
                  return true;            
         return false;
      }  
      // returns distance between (x1, y1) and (x2, y2)
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }
