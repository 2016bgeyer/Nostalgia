   //Name_Ben GEyer_____________________________ Date_____________
   import javax.swing.JOptionPane;
   public class Driver12
   {
      public static void main(String[] args)
      {
         while(true)
         {
            int n = Integer.parseInt(
                       JOptionPane.showInputDialog(
                                    "How many rows? (-1 to quit)"));
            if(n == -1)
            {
               System.out.println("Bye-bye!");
               System.exit(0);
            }
            String message = "What type? (1-5)";
            message = message + "\n1. Standard";
            message = message + "\n2. Backward";
            message = message + "\n3. Pyramid";
            message = message + "\n4. Box with X";
            message = message + "\n5. Example";
            int type = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch(type)
            {
               case 1: standard(n);
                  break;
               case 2: backward(n);
                  break;
               case 3: pyramid(n);
                  break;
               case 4: box(n);
                  break;
               case 5: example(n);
                  break;
               default: System.out.println("Not a valid type.");
                  break;
            }
            System.out.println();
         }
      }
      public static void standard(int n)
      {
         for(int row = 1; row<=n;row++)
         {
            for(int col = 1; col<= row; col++)
            {
               System.out.print("*");
            }
            System.out.println();
          
         }
      }
      public static void backward(int n)
      {
         for(int row = 1; row<=n;row++)
         {
            for(int col = n-row; col>=1; col--)
            {
               System.out.print(" ");
            
            }
               
            for(int col = 1; col<= row; col++)
            {
               System.out.print("*");
            }
            System.out.println();
          
         }
      }
      public static void pyramid(int n)
      {
         System.out.println("");
      }
      public static void box(int n)
      {
         System.out.println("");
      }
      public static void example(int n)
      {
         for(int row = 1; row<= n; row++)
         {
            for(int c = 1; c<=n; c++)
            {
               if((row + c) % 2 == 0)
                  System.out.print("*");
               else
                  System.out.print(" ");
            }
            System.out.println();
         }
      }
   }