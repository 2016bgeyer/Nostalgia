   //Name______________________________ Date_____________
   import javax.swing.JOptionPane;
   public class Driver13
   {
      public static void main(String[] args)
      {
         while(true)
         {
            int ff = Integer.parseInt(
                       JOptionPane.showInputDialog(
                                    "First digit?(-1 to quit)"));
            while(ff>9)
            {
               ff = Integer.parseInt(
                       JOptionPane.showInputDialog(
                                    "First digit?(-1 to quit)"));
            }
            if(ff == -1)
            {
               System.out.println("Bye-bye!");
               System.exit(0);
            }       
            int fs = Integer.parseInt(JOptionPane.showInputDialog("Second digit?"));
            while(fs>9)
            {
               fs=Integer.parseInt(JOptionPane.showInputDialog("Second digit?"));
            }
         
            necklace(ff, fs);
            System.out.println(" ");
         }
      }
      public static void necklace(int ff, int fs)
      {
         int tf=ff;
         int ts=fs;
         int tt=0;
         int count = 0;
         System.out.print(" "+ff);
         System.out.print(" "+fs);
      
         do
         {
            tt=(ts+tf)%10;
            tf=ts;
            ts=tt;
            count++;
            System.out.print(" "+ts);
         }   while(ff!=tf||fs!=ts);
         System.out.println(" ");
         System.out.print(""+count);
      }
   }