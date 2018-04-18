   public class Triangle extends Shape
   {
      private double myBase;
      public Triangle(double x)
      {
         myBase = x;
      }
      public double getBase()
      {
         return myBase;
      }
      public void setBase(double x)
      {
         myBase = x;
      }
      public double findArea()
      {
         double A = (Math.sqrt(3)/4)*Math.pow(myBase,2);
         return A;
      }
      public double findPerimeter()
   	{
   	double P = myBase*3;
   	return P;
   	}
   }