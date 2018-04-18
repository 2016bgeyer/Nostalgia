 	//Name______________________________ Date_____________
   import javax.swing.*;
   import java.awt.*;
   public class Display05 extends JPanel
   {
      private JLabel label1, label2, label3;
      private int value, total;
      public Display05()
      {
         setLayout(new GridLayout(3, 1));
         Font f = new Font("Serif", Font.BOLD, 30);
         total = value = 0;
      
         label1 = new JLabel("Value: 0");
         label1.setFont(f);
         label1.setForeground(Color.blue);
         add(label1);
      
         label2 = new JLabel("Total: 0");
         label2.setFont(f);
         label2.setForeground(Color.blue);
         add(label2);
      	
         label3 = new JLabel("High Score: 0");
         label3.setFont(f);
         label3.setForeground(Color.blue);
         add(label2);
      }
      public void update()
      {
         int value = (int)( Math.random()*10 + 1);
         if(value>2)
         {
            label1.setText("Value:" + value);
            total = total + value;
            label2.setText("Total:" + total);
         }
         if(value<= 2)
         {
            label1.setText("Value:" + value);
            total = 0;
         	label2.setText("Total:" + total);
         }
         
      }
   }