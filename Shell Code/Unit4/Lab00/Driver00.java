//Ben Geyer
   import java.util.Scanner;
   public class Driver00
   {
   	public static final int NUMITEMS = 10;
      public static void main(String [] args)
      {
         int[] array = new int[NUMITEMS];
         Scanner keyboard = new Scanner(System.in);
         for(int x = 0; x<NUMITEMS; x++)
         {
            System.out.print("#" + (x+1) + ":  ");
            array[x] = keyboard.nextInt();
         }
         System.out.println("The numbers you typed in, backwards: ");
         // for(int x = 0; x< NUMITEMS; x++)
         // {
            // System.out.println("\t" + array[NUMITEMS - x -1]);
         // }
      
      // for(int x = 0; x< 10; x++)
         // {
            // System.out.println("\t" + array[10 - x -1]);
         // }	
         
      	for(int x = 10; x> 0; x--)
         {
            System.out.println("\t" + array[0 + x -1]);
         }
         }
   }