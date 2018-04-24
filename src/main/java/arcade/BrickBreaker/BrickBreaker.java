package arcade.BrickBreaker;
   
   import javax.swing.JFrame;
   public class BrickBreaker
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("lab12");
         frame.setSize(400, 325);
         frame.setLocation(400, 325);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BrickPanel());
         frame.setVisible(true);
      }
   }