 	/*****************************************************************
	* A Rectangle is a Shape that maintains information about its height and base. A Rectangle
	* knows how to return its height, return its base, set its base, set its height calculate 
	* and return its area, calculate and return its perimeter, and calculate and return its diagonal
	 
	* @author Brian Chuang
	* @version 2.7.2013
	****************************************************************/
   public class Rectangle extends Shape 
   {
      private double myHeight, myBase;
      /************************************************************
   	* Constructs a Rectangle with an initial specified height by x
   	* and an initial specified base by y.
   	*@ param x	initial height
   	*@ param y	initial base
   	************************************************************/
      public Rectangle(double x, double y)
      {
         myHeight=x;
         myBase=y;
      }
      /************************************************************
   	* Returns the height.
   	*@ return	height
   	*************************************************************/    
      public double getHeight()
      {
         return myHeight;
      }
      /************************************************************
   	* Returns the base.
   	*@ return	base
   	************************************************************/
      public double getBase()
      {
         return myBase;
      }
      /************************************************************
   	* Sets the height to input number
   	*@ param x	assigns x to myRadius
   	************************************************************/
      public void setHeight(double x)
      {
         myHeight = x;
      }
      /************************************************************
   	* Sets the base to input number
   	*@ param x	assigns x to myBase
   	************************************************************/
      public void setBase(double x)
      {
         myBase= x;
      }
      /************************************************************
   	* Calculates and returns area
   	*@ returns	area
   	************************************************************/
      public double findArea()
      {
         double A=myHeight*myBase;
         return A;
      }
      /************************************************************
   	* Calculates and returns perimeter
   	*@ returns	perimeter
   	************************************************************/
      public double findPerimeter()
      {
         double P = 2*myHeight+2*myBase;
         return P;
      }
      /************************************************************
   	* Calculates and returns diagonal
   	*@ returns	diagonal
   	************************************************************/
      public double findDiagonal()
      {
         double d = Math.sqrt( Math.pow(myHeight,2)+Math.pow(myBase,2));
         return d;
      }

   }