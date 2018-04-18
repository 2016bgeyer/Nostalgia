import java.awt.*;
   public class PaddleRight extends Bumper
   {
      private int myX;
      private int myY;
      private int myxWidth;
      private int myyWidth;
      private Color k;
   
   
      public PaddleRight()
      {
         k = Color.RED;
         myX = 30;
         myY = 50;
         myxWidth = 30;
         myyWidth = 40;
      }
      public PaddleRight(int x, int y, int xWidth, int yWidth, Color c)
      {
         k = c;
         myX = x;
         myY = y;
         myxWidth = xWidth;
         myyWidth = yWidth;
      
      }
   }