package arcade.FinishedBrickBreaker;

   import javax.swing.JFrame;
   public class BrickDriver
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("BrickBreaker");
         frame.setSize(500, 500);
         frame.setLocation(300, 325);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BrickPanelnew());
         frame.setVisible(true);
      }
   }