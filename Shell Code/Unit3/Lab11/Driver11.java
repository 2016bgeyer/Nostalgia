

   import javax.swing.JFrame;
   public class Driver11
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Lab11");
         frame.setSize(350, 325);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Panel11());
         frame.setVisible(true);
      }
   }