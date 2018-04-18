	//NameBEn Geyer______ Date_____________
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class Panel05ext extends JPanel
   {
      private Display05ext display;
      private Timer t;
      private JButton button, button2;
      public Panel05ext()
      {
         setLayout(new FlowLayout());
      
         display = new Display05ext();
         add(display);
      	
         t = new Timer(5, new Listener());
      
         button = new JButton("Press Your Luck");
         button.addActionListener(new Listener());
         add(button);
      	
         button2 = new JButton("Start Run");
         button2.addActionListener(new Listener2());
         add(button2);
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.update();
         	
         
         }
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            if(t.isRunning())
            {
               t.stop();
               button2.setLabel("Re-Run");
            }
            else 
            t.start();
            button2.setLabel("Pause");
         }
      }
   }