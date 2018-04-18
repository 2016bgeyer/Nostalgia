//Ben Geyer

   import edu.fcps.karel2.Display;
   import edu.fcps.karel2.Robot;

   public class Democrat extends MazeEscaper
   {
      public void walkDownCurrentSegment()
      {
         while(frontIsClear() && !leftIsClear())
            move();
      }
      public void turnToTheNextSegment()
      {
         while(!nextToABeeper())
         {
            if(leftIsClear()&& !nextToABeeper())
            {
               turnLeft();
               move();
            
            }
            else
               turnRight();
         }
      }
   }
         	
         

