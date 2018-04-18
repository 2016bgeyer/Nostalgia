   import java.io.*;      //the File class
   import java.util.*;    //the Scanner class
   import javax.swing.JOptionPane;  // JOptionPane
   
   public class Driver03
   {
      public static final int NUMITEMS = 20;
   	
      public static void main(String[] args) throws Exception
      {
        
         String first = JOptionPane.showInputDialog("What file?");
      
       
         Scanner infile = new Scanner( new File(first) );
         double[] array = new double[NUMITEMS];
         
         
         for(int x = 0; x<NUMITEMS; x++)
            array[x] = infile.nextDouble();
            
         System.out.println("Fahrenheit"+"\t|Celsius");
         
      	
         for(int x = 0; x<34;x++)
            System.out.print("-");
            
         System.out.println("");
         
      	
         for(int x = 0; x<NUMITEMS;x++)
         {
            double c = 5.0/9*(array[x]-32);
            c = (int)(c*100)/100.0;
            System.out.println(""+array[x]+"\t\t|"+c);
         }
       
      
      }  
   		     	
      	
      
   }
