   import java.io.*;
   import java.util.*;
   import javax.swing.JOptionPane;
   public class Driver04
   {
      public static Scanner infile;
   	
      public static int NUMITEMS;
      private static double sum=0,avg=0,min,max;
   
      public static void main(String[] args)
      {
         boolean k = true;
         while(k)
         {
            try
            {
               System.out.println("Enter file name");
               Scanner s = new Scanner(System.in);
               String d = s.next();
               infile = new Scanner(new File(d));
               k=false;
            }
               catch(FileNotFoundException e)
               {
                  System.out.println("Error: File not found.");
               
               }
         }
         double[] array = new double[infile.nextInt()];
      	   	min=array[0];
					max=array[0];
         for(int x = 0; x<array.length;x++)
            array[x]=infile.nextDouble();
         for(int x = 0; x<array.length;x++)
         {
            sum=sum+array[x];
            min=Math.min(min,array[x]);
            max=Math.max(max,array[x]);
         }
         System.out.println("Sum: "+sum);
         System.out.println("Avg: "+sum/array.length);
         System.out.println("Min: "+min);
         System.out.println("Max: "+max);
      }
   }
      
