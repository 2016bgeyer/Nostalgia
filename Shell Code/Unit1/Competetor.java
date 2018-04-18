// Ben Geyer
   import edu.fcps.karel2.Display;

   public abstract class Competetor extends Athlete
   {
      public Competetor(int y)
      {
         super(1, y, Display.EAST, 0);
      }
      public abstract int runcurrentsegment();
      public abstract int turndowncorridor(Competetor arg);
      public abstract void moveAppropriately(int beepers);
   
         
      
   }