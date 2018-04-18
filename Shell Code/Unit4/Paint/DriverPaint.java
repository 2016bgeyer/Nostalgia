   import javax.swing.*;
   import javax.swing.JFrame;
   public class DriverPaint
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("My Paint");
         frame.setSize(800, 800);    //makes the mouse location correct
         frame.setLocation(20, 20);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         frame.setContentPane(new PaintPanel()); 
         frame.setVisible(true);
         
      }
   }