//Ben Geyer
   import edu.fcps.karel2.Display;
   import edu.fcps.karel2.Robot;
  
   public class Republican extends MazeEscaper
   {
      public void walkdowncurrentsegment()
      {
         while(frontIsClear())
            move();
      }
      public void turnToTheNextSegment()
      {
         while(!nextToABeeper())
         {
            while(rightIsClear())
            {
               turnRight();
               move();
            }
         }
         if(frontIsClear()&&!rightIsClear())
            move();
         else
            turnLeft();
      }
   }