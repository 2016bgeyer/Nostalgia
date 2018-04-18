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
      private static final double BALL_DIAM = 50;
      private static final double PRIZE_DIAM = 25;
      private static final int BUMPER_X_WIDTH = 150;
      private static final int BUMPER_Y_WIDTH = 50;
      private int bricklength = 20;
      private int brickwidth = 100;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball;
      private Bumper bumper;
      private Timer timer;    
      private Bumper[] myBrickarray;
      private int x = 0;
      private int y = 0;
      private int u=0;
      public BrickPanel()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         
         ball = new Ball(FRAME-BUMPER_X_WIDTH, FRAME-BUMPER_Y_WIDTH, BALL_DIAM, BALL_COLOR);
      	           
         bumper = new Bumper(FRAME-BUMPER_X_WIDTH, FRAME-BUMPER_Y_WIDTH, BUMPER_X_WIDTH, BUMPER_Y_WIDTH, BUMPER_COLOR);
         myBrickarray= new Bumper[51];
         for(int k = 0; k<myBrickarray.length; k++)
         {
            
            if(u>10)
               u=0;
            
            x= 0+(brickwidth*u);
            if(k%10==0)
               y = y+bricklength;
            u++;
            myBrickarray[k] = new Bumper(x,y,brickwidth,bricklength,Color.RED);
         }     	
      
         timer = new Timer(10, new Listener());
         timer.start();
         Thread t = new Thread();
         t.start();    
         addKeyListener(new Key());
         setFocusable(true);
      
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
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0,0,FRAME,FRAME); 
            ball.move(FRAME, FRAME, 0, 0);
            BrickCollision.collide2( myBrickarray, ball);
            for(int u = 0; u<51; u++)
               myBrickarray[u].draw(myBuffer);
         
           
            ball.draw(myBuffer);
          
            bumper.draw(myBuffer);
            myBuffer.setColor(Color.black);
          
            BumperCollision.collide(bumper, ball);
            bumper.draw(myBuffer);
         
         
         
            repaint();
         }
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
                   
         }
      }
   
   }
