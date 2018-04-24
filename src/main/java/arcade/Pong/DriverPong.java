package arcade.Pong;

   import javax.swing.*;
   import javax.swing.JFrame;
   public class DriverPong
   {
      public static void main(String[] args)
      { int q = Integer.parseInt(JOptionPane.showInputDialog("How Hard?\n1. Easy\n2. Medium\n3. Hard\n4. Insane"));
         JFrame frame = new JFrame("1 Player!!!");
         frame.setSize(800, 800);    //makes the mouse location correct
         frame.setLocation(20, 20);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         frame.setContentPane(new Player1Pong(q)); 
         frame.setVisible(true);
         
      }
   }
