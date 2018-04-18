   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   
   public class BrickPanel extends JPanel
   {
      private static final int FRAME = 900;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private static final Color BALL_COLOR = Color.BLACK;
      private static final Color PRIZE_COLOR = Color.RED;
      private static final Color BUMPER_COLOR = Color.BLUE;
      
      private static final int BUMPER_X_WIDTH = 150;
      private static final int BUMPER_Y_WIDTH = 50;
   
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Bumper bumper, shotbumper;
      private Timer main, shot;    
      public int shotdelay;
      private int x = 0;
      private int y = 0;
      private int u=0;
      public BrickPanel()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         
      
      	           
         bumper = new Bumper((FRAME/2)-(BUMPER_X_WIDTH/2), (FRAME-(BUMPER_Y_WIDTH))-10, BUMPER_X_WIDTH, BUMPER_Y_WIDTH, BUMPER_COLOR);
         shotbumper = new Bumper(bumper.getX()+(bumper.getXWidth()/2), (FRAME-(BUMPER_Y_WIDTH))-30,  8, 15, Color.red);
      	
         shot = new Timer(shotdelay, new ListenerShot());
         main = new Timer(10, new Listener());
         main.start();
         Thread t = new Thread();
         t.start();    
         addKeyListener(new Key());
         setFocusable(true);
      
      }
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
               if(bumper.getX() > 0)
                  bumper.setmyX(bumper.getX()-20);
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
               if(bumper.getX()<FRAME-BUMPER_X_WIDTH)
                  bumper.setmyX(bumper.getX()+20);
            if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
            
               shotbumper.draw(myBuffer);
               shotbumper.setmyY(shotbumper.getY());
            }         
         }
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
          
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // clear buffer and move ball
            Color sky = new Color (73, 73, 73);
            myBuffer.setColor(sky);
            myBuffer.fillRect(0,0,FRAME,FRAME);
            bumper.draw(myBuffer);
            
            repaint();
         }
      }
      public class ListenerShot implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         }
      }
      public void fall(Ball ball, double speed)
      {
      	
      
      
      }
      public void spawn(Ball ball)
      {
      
      
      
      
      }
      public void shot(Bumper bumpershot)
      {
      
      
      }
      
   
   }
