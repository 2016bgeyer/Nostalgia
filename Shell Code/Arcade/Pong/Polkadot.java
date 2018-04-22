
   import java.awt.*;
   
    public class Polkadot
   {
      private double myX;   // x and y coordinates of center
      private double myY;
      private double myDiameter;
      private Color myColor; 
      private double myRadius;
		private double dx;       // pixels to move each time step() is called.
      private double dy;
     // constructors
       public Polkadot()     //default constructor
      {
         myX = 200;
         myY = 200;
         myDiameter = 25;
         myColor = Color.RED;
         myRadius = myDiameter/2;
      }
       public Polkadot(double x, double y, double d, Color c)
      {
         myX = x;
         myY = y;
         myDiameter = d;
         myColor = c;
         myRadius = d/2;
      }
    // accessor methods
       public double getX() 
      { 
         return myX;
      }
       public double getY()      
      { 
         return myY;
      }
       public double getDiameter() 
      { 
         return myDiameter;
      }
       public Color getColor() 
      { 
         return myColor;
      }
       public double getRadius() 
      { 
         return myRadius;
      }
   // modifier methods
       public void setX(double x)
      {
         myX = x;
      } 
       public void setY(double y)
      {
         myY = y;
      } 
       public void setColor(Color c)
      {
         myColor = c;
      }
       public void setDiameter(double d)
      {
         myDiameter = d;
         myRadius = d/2;
      }
       public void setRadius(double r)
      {
         myRadius = r;
         myDiameter = 2*r;
      }
    //	 instance methods
       public void jump(int rightEdge, int bottomEdge)
      {
         // moves location to random (x, y) within the edges
         myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
         myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
      }
       public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(myColor);
         myBuffer.fillOval((int)(myX - myRadius), (int)(myY-myRadius), (int)myDiameter, (int)myDiameter);
      }
    
	 public void move(double rightEdge, double bottomEdge)
      {
         setX(getX()+ dx);                    // x = x + dx
         setY(getY()+ dy);
        
        //check for left & right edge bounces
         if(getX() >= rightEdge - getRadius())     //hits the right edge
         {
            setX(rightEdge - getRadius());
            dx = dx * -1; 
         }
         
         
         else if (getX() <= 0 + getRadius())     //hits the left edge
         {
            setX(0 + getRadius());
            dx = dx * -1;
         }
         
         
         
         
         else if (getY() <= 0 + getRadius())     //top
         {
            setY(0 + getRadius());
            dy = dy * -1;
         }
         
         else if (getY() >= bottomEdge - getRadius())     
         {
            setY(bottomEdge - getRadius());
            dy = dy * -1;
         }
      }
	
	
	
	
	
	
	
	
	
	}