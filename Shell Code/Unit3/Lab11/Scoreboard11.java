   import javax.swing.*;
   import java.awt.*;
   public class Scoreboard11 extends JPanel
   {
      private JLabel label1,label2,label3;
      private int count1,count2;
      public Scoreboard11()
      {
         setLayout(new GridLayout(1, 5));
      
         label1 = new JLabel("One:0");
         label1.setOpaque(true);
         label1.setBackground(Color.yellow);
         label1.setHorizontalAlignment(SwingConstants.CENTER);
         add(label1);
         label2 = new JLabel("Nim");
         label2.setHorizontalAlignment(SwingConstants.CENTER);
         add(label2);
         label3 = new JLabel("Two:0");
         label3.setOpaque(true);
         label3.setBackground(Color.gray);
         label3.setHorizontalAlignment(SwingConstants.CENTER);
         add(label3);
      }
      public void update(boolean arg)
      {
         if(arg==true)
         {
            if(label3.getBackground() == Color.yellow)
            {
               count2++;
               label3.setText("Two:"+count2);
            }
            else
            {
               count1++;
               label1.setText("One:"+count1);
            }
         }
         else
         {
            if(label3.getBackground()==Color.yellow)
            {
               label1.setBackground(Color.yellow);
               label3.setBackground(Color.gray);
            }
            else
            {
               label3.setBackground(Color.yellow);
               label1.setBackground(Color.gray);
            }
         }
      }
   }