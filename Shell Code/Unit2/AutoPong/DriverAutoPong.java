	// Torbert, 7.20.06

   import javax.swing.JFrame;
   public class DriverAutoPong
   {
      public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Auto Pong!!!");
         frame.setSize(800, 800);    //makes the mouse location correct
         frame.setLocation(20, 20);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //          PrizePanel p = new PrizePanel();
      //          frame.setContentPane(p); 
      //         p.requestFocus();ttyyyyyty
         frame.setContentPane(new AutoPong2()); 
         frame.setVisible(true);
         
      }
   }
