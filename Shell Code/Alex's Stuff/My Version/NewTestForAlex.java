   import javax.swing.JFrame; 
   public class NewTestForAlex
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Asteroid Attack");
         frame.setSize(900, 900);
         frame.setLocation(400, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BrickPanel());
         frame.setVisible(true);
      }
   }