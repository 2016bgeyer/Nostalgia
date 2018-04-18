   import java.util.Scanner;
   import java.text.DecimalFormat;
   public class Driver02
   {
      public static final int NUMITEMS = 15;
      public static void main(String[] args)
      {
      
         double[] Farray = new double[NUMITEMS];
         double[] Carray = new double[NUMITEMS];
         Scanner keyboard = new Scanner(System.in);
         for(int x = 0; x<NUMITEMS-5; x++)
         {
            System.out.print("#"+(x+1)+": ");
            Farray[x] = keyboard.nextDouble();
         }
         for(int x = 0; x<5; x++)
         {
            double l = (int)(Math.random()*1000);
            Farray[x+10]=l/10;
            System.out.print("#"+(x+10)+": "+Farray[x+10]);
            System.out.println();
         }
         System.out.println();
         System.out.println("Fahrenheit"+"\t Celsius");
         for(int x = 0; x<34;x++)
            System.out.print("-");
         System.out.println("");
         for(int x = 0; x<NUMITEMS;x++)
         {
            Carray[x] = 5.0/9*(Farray[x]-32);
            Carray[x]= (int)(Carray[x]*100)/100.0;
            System.out.println(""+Farray[x]+"\t\t|"+Carray[x]);
         }
      }
   }