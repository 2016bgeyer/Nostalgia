   import javax.swing.JFrame;

   public class Driver01
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Lab02");
         frame.setSize(1000, 1000);
         frame.setLocation(100,50);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new SkyBackground());
         frame.setVisible(true);
      }
   }