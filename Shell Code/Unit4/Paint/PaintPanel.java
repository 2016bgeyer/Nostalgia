   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.awt.Graphics;
   import java.io.*;
   import javax.swing.JOptionPane;
   public class PaintPanel extends JPanel
   {
      
      private Timer cursor;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private DisplayPaint display;
      private static final int FRAME = 400;
      public JLabel label;
      public PaintPanel()
      {
         setLayout(new BorderLayout());
         
         JPanel subpanel =  new JPanel();
         subpanel.setLayout(new FlowLayout());
         add(subpanel, BorderLayout.NORTH);
         
      	
      	drawCircle(15);
      	label = new JLabel("none selected");
      	add(label);
      	
      	
         display = new DisplayPaint();
         add(display, BorderLayout.WEST);
      	
      	
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(Color.white);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
      
         addKeyListener(new Key());
         setFocusable(true);
         addMouseListener(new Mouse());
         addMouseMotionListener(new Mouse());
         
         cursor = new Timer(0, new Listener2());
         cursor.start();
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      public void circle(int radius, int pointx,int pointy)
      {
         myBuffer.fillOval(pointx, pointy, radius, radius);
      }
      public class Mouse implements MouseListener, MouseMotionListener
      {
         public void mouseDragged(MouseEvent e)
         {
         // while()
         
         }
         public void mouseClicked(MouseEvent e)
         {
         
         }
         public void mousePressed(MouseEvent e)
         {
            
         }
         
         public void mouseMoved(MouseEvent e)
         {
            
         }
         public void mouseReleased(MouseEvent e)
         {
         
         }
         public void mouseEntered(MouseEvent e)
         {
         
         }
      	
         public void mouseExited(MouseEvent e)
         {
         
         }
      }
      public void drawCircle(int x)
      {
         myBuffer.setColor(Color.red);
         myBuffer.fillOval(25,35,15,23);
      }
      
      public class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
            
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               
            }
            
            
         	
         }
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.white);
            myBuffer.fillRect(0,0,FRAME,FRAME);
         
            
            
            
             
            
            
            
            
            
            
            repaint();
         }
      }
   }