   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class PlayerPong extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(203, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Bumper bumper;
      private Bumper bumper2;
     
      private Ball ball;
      private Timer t;
      private Timer r; 
      public int x = 0;
      public int z= 0;
      public int a=0;
      public int b=0;
      public int g=0;
      public int f=0;
      public Timer y, u;
      
   	//constructor   
      public PlayerPong()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         int xPos = (int)(Math.random()*(FRAME-100) + 50);
         int yPos = (int)(Math.random()*(FRAME-100)+ 50);
         bumper = new Bumper(FRAME - 40, (FRAME/2)-30, 10, 80, Color.green);
         bumper2 = new Bumper(30, (FRAME/2)-30,10, 80, Color.blue);
         
      	
         ball = new Ball(200, 200, 35, Color.white);
         
         y = new Timer(0, new Listener3());
         y.start();
      	
         u = new Timer(0, new Listener4());
         u.start();
      	
         r = new Timer(0, new Listener2());
         r.start();
      
         addKeyListener(new Key());
         setFocusable(true);
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      
   			
      public class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
               
               bumper.setmyY(bumper.getY()- 50);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               bumper.setmyY(bumper.getY()+50);
            }
         
            if(e.getKeyCode() == KeyEvent.VK_T&& e.getKeyCode() != KeyEvent.VK_R)
            {
               myBuffer.setColor(Color.red);
               myBuffer.fillRect(0,0, 400, 400);
            
               myBuffer.setColor(Color.black);
               myBuffer.drawString("4 Player PONG EXTREME!!!!!!!!!!", (FRAME/2)-100, (FRAME/2)-50);
               repaint();
               t.stop();
               r.stop();
            }
            if(e.getKeyCode() == KeyEvent.VK_G)
            {
               myBuffer.setColor(Color.black);
               myBuffer.fillRect(0,0, 400, 400);
            
               myBuffer.setColor(Color.white);
               myBuffer.drawString("2 Player Pong!!!!!!!!", (FRAME/2)-150, (FRAME/2)-100);
               repaint();
               
               r.stop();
            }
            
            
         
         
         
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
               
               bumper2.setmyY(bumper2.getY()- 50);
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
               bumper2.setmyY(bumper2.getY()+50);
            }
         
            if(e.getKeyCode() == KeyEvent.VK_M)
            {
               ball.setdx(ball.getdx() + (ball.getdx()/5));
               ball.setdy(ball.getdy() + (ball.getdy()/5));
            } 
            if(e.getKeyCode() == KeyEvent.VK_N)
            {
               ball.setdx(ball.getdx() - (ball.getdx()/5));
               ball.setdy(ball.getdy() - (ball.getdy()/5));
            } 
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
               ball.setdx((int)(Math.random()*6-3));
               ball.setdy((int)(Math.random()*6-3));
            }
            if(e.getKeyCode() == KeyEvent.VK_P)
            {
               ball.setdx(0);
               ball.setdy(0);
            }
            if(e.getKeyCode() == KeyEvent.VK_Q)
            {
               System.exit(0);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
               System.exit(0);
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
               ball.setdx(Math.random()*6-3);
               ball.setdy(Math.random()*6-3);
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {ball.setdx(0.1);
               ball.setdy(0.1);
            }
         }
      }
      
   	//y
      private class Listener3 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            auto(ball, bumper);
         }
      }
      
   	//u
      private class Listener4 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            auto(ball, bumper2); 
         }
      }  
   
      
      
   	//the method of moving bumpers
      public void auto(Ball ball, Bumper bumper2)
      {
      
         double y = ball.getY();
         int x = (int)y;
         if(ball.getY() > bumper2.getY())
            bumper2.setmyY(x + 1);
         else
            bumper2.setmyY(x - 1);
      
      }
      
   	//bumpers dont move out of screen
      public void bumperCheck(Bumper bumper1, Bumper bumper2)
      {
         if(bumper1.getY()> FRAME+10)
         {
            bumper1.setmyY(FRAME/2);
         }
         if(bumper2.getY()> FRAME+10)
         {
            bumper2.setmyY(FRAME/2);
         }
      
      }
      
   	//when the are up and down it won't tp into the ball
      public void bumpervert(Ball ball, Bumper bumper, Bumper bumper2, Timer i)
      {
         while(ball.getX() == bumper2.getX())
            i.stop();
      
         while(ball.getX() == bumper.getX())
            i.stop();
      }//works!!!!!!!!!
      
      public void ballX(Ball ball, Timer i, Timer p)
      {
         
         if(ball.getX() > (FRAME/2))
         {
            p.stop();
            i.start();
         }
         
         if(ball.getX() < (FRAME/2))
         {
            i.stop();
            p.start();
         }
      }
   	
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(0,0,FRAME,FRAME);
            
         	
            u.start();
            u.setDelay(100);
         		
            y.start();
            y.setDelay(100);
         	//timers and stuff
           
            bumpervert(ball, bumper, bumper2, y);
            bumpervert(ball, bumper, bumper2, u);
            bumperCheck(bumper, bumper2);
          
            ballX(ball, y, u);
            
         	
         	//autobumpercheck(ball, bumper2, bumper);
            
            //drawing stuff
            bumper2.draw(myBuffer);
            bumper.draw(myBuffer);
            ball.move(FRAME, FRAME);
            ball.draw(myBuffer);
            myBuffer.setColor(Color.blue);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Score 1: " + g, (FRAME - FRAME)+20, 65);
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Score 2: " + f, FRAME - 150, 65);
            BumperCollision.collide(bumper,ball);
            BumperCollision.collide(bumper2,ball);
         	 
            oldscore1(ball);
            oldscore2(ball);
            
         	
         	//rect's
            for(int y=0; y<=FRAME; y+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect((FRAME/2), y, 5, 10);
            }
         	
            repaint();
         }
      }
      
      public void oldscore1(Ball ball)
      {
         if(ball.getX() - ball.getRadius() <= 0+ 1)
         {
            f++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.green);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      }
      public void oldscore2(Ball ball)
      {
         if(ball.getX() + ball.getRadius() >= FRAME - 1)
         {
            g++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.blue);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      }
   }