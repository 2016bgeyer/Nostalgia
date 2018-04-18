   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 4.4.2003

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class Panel11 extends JPanel
   {
      private Display11 display;
      private Scoreboard11 scoreboard;
      public Panel11()
      {
         setLayout(new BorderLayout());
      
         scoreboard = new Scoreboard11();
         add(scoreboard, BorderLayout.NORTH);
      	
         display = new Display11();
         add(display, BorderLayout.CENTER);
      	JPanel panel = new JPanel();
      	panel.setLayout(new GridLayout(0,3));
      	addButton(panel, "One", 1);
      	addButton(panel, "Two", 2);
      	addButton(panel, "Three", 3);
      	add(panel, BorderLayout.SOUTH);
      }
      private void addButton(JPanel panel, String s, int x)
      {
         JButton button = new JButton(s);
         button.addActionListener(new Listener(x));
         panel.add(button);
           
      }
   
      private class Listener implements ActionListener
      {
      private int y;
         public Listener(int x)
         {
           y = x;
         }
         public void actionPerformed(ActionEvent e)
         {
            scoreboard.update(display.pickUp(y));
         }
      }

   }