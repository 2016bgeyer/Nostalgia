   //Name:    Date:
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class Pong extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(203, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Bumper bumper;
      private Bumper bumper2;
      private Bumper bumper3;
      private Bumper bumper4;
      private Ball ball;
      private Timer t;
      private Timer r; 
      public int x = 0;
      public int z= 0;
      public int a=0;
      public int b=0;
      public int g=0;
      public int f=0;
      
   	//constructor   
      public Pong()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         int xPos = (int)(Math.random()*(FRAME-100) + 50);
         int yPos = (int)(Math.random()*(FRAME-100)+ 50);
         bumper = new Bumper(FRAME - 40, (FRAME/2)-30, 10, 80, Color.green);
         bumper2 = new Bumper(30, (FRAME/2)-30,10, 80, Color.blue);
         bumper3 = new Bumper((FRAME/2)-30, 30, 80, 10, Color.red);
         bumper4 = new Bumper((FRAME/2)-30, FRAME - 30,80 ,10 ,Color.gray);  
      	
         ball = new Ball(200, 200, 35, Color.white);
         t = new Timer(0, new Listener());
         t.start();
         r = new Timer(0, new Listener2());
         addMouseListener(new Mouse());
         addKeyListener(new Key());
         setFocusable(true);
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      public class Mouse extends MouseAdapter
      {
         public void mousePressed(MouseEvent e)
         {
            if(e.isMetaDown() && !e.isShiftDown())
            {
               bumper3.setmyX(bumper3.getX() +30);
            }
            if(!e.isMetaDown() && !e.isShiftDown())
            {
               bumper3.setmyX(bumper3.getX()- 30);
               
            }	
         	
         }
      	// public void mouseMoved(MouseEvent e)
      // 			{
      // 			if(mouseMoved())
      // 			{
      // 			e.getX();
      // 			ball.setX(0);
      // 			}
      // 			}
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
               t.stop();
               r.stop();
            }
            if(e.getKeyCode() == KeyEvent.VK_R)
            {
               t.stop();
               r.start();
            }
            if(e.getKeyCode() == KeyEvent.VK_Y)
            {
               r.stop();
               t.start();
            }
         
         
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
               
               bumper2.setmyY(bumper2.getY()- 50);
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
               bumper2.setmyY(bumper2.getY()+50);
            }
         
            if(e.getKeyCode() == KeyEvent.VK_H)
            {
               bumper4.setmyX(bumper4.getX()-50 );
               
            }
            if(e.getKeyCode() == KeyEvent.VK_J)
            {
               bumper4.setmyX(bumper4.getX()+ 50 );
               
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
               ball.setdx((Math.random()*6-3));
               ball.setdy((Math.random()*6-3));
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
            {ball.setdx(0.1);ball.setdy(0.1);
            }
         }
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.black);
            myBuffer.fillRect(0,0,FRAME,FRAME);
           
            for(int y=(FRAME)/4; y<=FRAME-(FRAME/4); y+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(FRAME-(FRAME/4), y, 5, 10);
            }
            for(int y=(FRAME)/4; y<=FRAME-(FRAME/4); y+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(FRAME/4, y, 5, 10);
            }
            for(int x=(FRAME)/4; x<=FRAME-(FRAME/4); x+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(x, FRAME-(FRAME/4), 10, 5);
            }
            for(int x=(FRAME)/4; x<=FRAME-(FRAME/4); x+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(x, (FRAME/4), 10, 5);
            }
         	
         	
            for(int y=(FRAME)/4; y<=FRAME-(FRAME/4); y+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(FRAME/2, y, 5, 10);
            }
            for(int x=(FRAME)/4; x<=FRAME-(FRAME/4); x+= 15)
            {
               myBuffer.setColor(Color.white);
               myBuffer.fillRect(x, (FRAME/2), 10, 5);
            }
            bumpersCheck(bumper, bumper2, bumper3, bumper4);
           
            bumper2.draw(myBuffer);
            bumper3.draw(myBuffer);
            bumper4.draw(myBuffer);
            bumper.draw(myBuffer);
            ball.move(FRAME, FRAME);
            ball.draw(myBuffer);
            myBuffer.setColor(Color.blue);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Deaths Player1: " + x, +10, FRAME -75);
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Deaths Player2: " + z, FRAME - 230, 65);
            myBuffer.setColor(Color.red);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Deaths Player3: " + b, 25, 20);
            myBuffer.setColor(Color.gray);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 20));
            myBuffer.drawString("Deaths Player4: " + a, FRAME -220, FRAME -50);
            BumperCollision.collide(bumper,ball);
            BumperCollision.collide(bumper2,ball);
            BumperCollision.collide(bumper3,ball);
            BumperCollision.collide(bumper4,ball);
            score1(ball);
            score2(ball);
            score3(ball);
            score4(ball);
            win(a,b,x,z);
         	 
            repaint();
            
           
         }
      	
      }   
      public void bumpersCheck(Bumper bumper1, Bumper bumper2, Bumper bumper3, Bumper bumper4)
      {
         if(bumper1.getY()> FRAME+10)
         {bumper1.setmyY((FRAME/2)-30);}
         if(bumper2.getY()> FRAME+10)
         {bumper2.setmyY((FRAME/2)-30);}
         if(bumper3.getX()> FRAME+10)
         {bumper3.setmyX((FRAME/2)-30);}
         if(bumper4.getX()> FRAME+10)
         {bumper4.setmyX((FRAME/2)-30);}
      
         if(bumper1.getY()< 0)
         {bumper1.setmyY((FRAME/2)-30);}
         if(bumper2.getY()< 0)
         {bumper2.setmyY((FRAME/2)-30);}
         if(bumper3.getX()< 0)
         {bumper3.setmyX((FRAME/2)-30);}
         if(bumper4.getX()< 0)
         {bumper4.setmyX((FRAME/2)-30);}
      }
      public void score1(Ball ball)
      {
         if(ball.getX() - ball.getRadius() <= 0+ 1)
         {
            x++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.green);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      }
      public void score2(Ball ball)
      {
         if(ball.getX() + ball.getRadius() >= FRAME - 1)
         {
            z++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.blue);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      }
      public void score3(Ball ball)
      {
         if(ball.getY() - ball.getRadius() <= 0+ 1)
         {
            b++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.gray);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      }
      public void score4(Ball ball)
      {
         if(ball.getY() + ball.getRadius() >= FRAME - 1)
         {
            a++;
            //ball = new Ball(FRAME/2, FRAME/2, 25, Color.RED);
            ball.setColor(Color.red);
            ball.setX(FRAME/2);
            ball.setY(FRAME/2);
            ball.setdx(ball.getdx() -ball.getdx());
            ball.setdy(ball.getdy() - ball.getdy());
         }
      
      }
      public void win(int a,int b,int x,int z)
      {
         if(x>10)
         {
            myBuffer.setColor(Color.cyan);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER:Player1 " , (FRAME/2)-180, FRAME/2);
            bumper.setmyX(FRAME+1000);
            bumper.setmyY(FRAME+1000);
         }
         if(z>10)
         {
            myBuffer.setColor(Color.cyan);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER:Player2 " , (FRAME/2)-180, FRAME/2);
            bumper2.setmyX(FRAME+1000);
            bumper2.setmyY(FRAME+1000);
         }
         if(a>10)
         {
            myBuffer.setColor(Color.cyan);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER:Player3 " , (FRAME/2)-180, FRAME/2);
            bumper3.setmyX(FRAME+1000);
            bumper3.setmyY(FRAME+1000);
         }
         if(b>10)
         {
            myBuffer.setColor(Color.cyan);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER:Player4 " , (FRAME/2) - 180, FRAME/2);
            bumper.setmyX(FRAME+1000);
            bumper.setmyY(FRAME+1000);
         }
      
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(0,0,FRAME,FRAME);
           
            
            bumperCheck(bumper, bumper2);
           
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
      public void bumperCheck(Bumper bumper1, Bumper bumper2)
      {
         if(bumper1.getY()> FRAME+10)
         {bumper1.setmyY(FRAME/2);}
         if(bumper2.getY()> FRAME+10)
         {bumper2.setmyY(FRAME/2);}
      
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

	
    
   


