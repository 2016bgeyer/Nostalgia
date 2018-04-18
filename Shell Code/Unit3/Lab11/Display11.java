   import javax.swing.*;
   import java.awt.*;
   public class Display11 extends JPanel
   {
      private JLabel label1;
      private int x=12;
      public Display11()
      {
   
         label1 = new JLabel();
         label1.setIcon(new ImageIcon("stones12.jpg"));
         label1.setOpaque(true);
         label1.setBackground(Color.BLACK);
         add(label1);
      
      }
      public boolean pickUp(int arg)
      {
        
         x = x-arg;
         if(x<=0)
         {
            x=12;
            label1.setIcon(new ImageIcon("stones12.jpg"));
         
         }
         else
            label1.setIcon(new ImageIcon("stones"+x+".jpg"));
         return x==12;
      }
   }