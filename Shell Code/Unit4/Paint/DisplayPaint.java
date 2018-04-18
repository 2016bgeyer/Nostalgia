   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 7.14.2003

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.io.*;
   import javax.swing.JOptionPane;
   public class DisplayPaint extends JPanel
   {
      public JLabel type;
      private int numsides;
      public DisplayPaint()
      {
         setLayout(new GridLayout(6, 1));
      
         JButton line = new JButton("Line");
         JButton rect	= new JButton("Rectangle");
         JButton circle	= new JButton("Circle");
         JButton triangle	= new JButton("Triangle");
         JButton polygon	= new JButton("Polygon");
         
      	
         type = new JLabel("No type selected");
         add(type);
         add(line);
         add(triangle);
         add(circle);
         add(rect);
         add(polygon);

      	
      	returntype(type);
         line.addActionListener(new Listener1());
         rect.addActionListener(new Listener2());
         circle.addActionListener(new Listener3());
         triangle.addActionListener(new Listener4());
         polygon.addActionListener(new Listener5());
      }
      public int  returntype(JLabel label)
      {
         int typenumber = 0;
         String s = new String(""+label.getText());
         if(s.equals("Line"))
         {
            typenumber = 1;
         }
         if(s.equals("Recangle"))
         {
            typenumber = 2;
         }
         if(s.equals("Circle"))
         {
            typenumber = 3;
         }
         if(s.equals("Triangle"))
         {
            typenumber = 4;
         }
         if(s.equals("Polygon"))
         {
            typenumber = 5;
         }
         return typenumber;
      }
      private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
             
            type.setText("Line");
         }
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
             
            type.setText("Rectangle");
         }
      }
      private class Listener3 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
             
            type.setText("Circle");
         }
      }
      private class Listener4 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
             
            type.setText("Triangle");
         }
      }
      private class Listener5 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
             
            type.setText("Polygon");
            String num = JOptionPane.showInputDialog("How many sides?");
            int numsides = Integer.parseInt(num);
         }
      }
      
   }