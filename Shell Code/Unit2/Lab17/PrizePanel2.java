   //Name:    Date:
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class PrizePanel2 extends JPanel
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
      public int x = 0;
      public int z= 0;
      public int a=0;
      public int b=0;
      
   	//constructor   
      public PrizePanel2()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         int xPos = (int)(Math.random()*(FRAME-100) + 50);
         int yPos = (int)(Math.random()*(FRAME-100)+ 50);
         bumper = new Bumper(FRAME - 40, 80, 20, 80, Color.green);
         bumper2 = new Bumper(30, 90,20, 80, Color.blue);
         bumper3 = new Bumper(FRAME/2, 30, 80, 20, Color.red);
         bumper4 = new Bumper(FRAME/2, FRAME - 30,80 ,20 ,Color.gray);  
      	
         ball = new Ball();
         t = new Timer(0, new Listener());
         t.start();
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
      }
   			
      public class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
               
               bumper.setmyY(bumper.getY()- 30);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               bumper.setmyY(bumper.getY()+30);
            }
         
            
         
            
         
         
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
               
               bumper2.setmyY(bumper2.getY()- 30);
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
               bumper2.setmyY(bumper2.getY()+30);
            }
         
            if(e.getKeyCode() == KeyEvent.VK_H)
            {
               bumper4.setmyX(bumper4.getX()-30 );
               
            }
            if(e.getKeyCode() == KeyEvent.VK_J)
            {
               bumper4.setmyX(bumper4.getX()+ 30 );
               
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
               ball.setdx(Math.random()*12-6);
               ball.setdy(Math.random()*12-6);
            }
            
         
         }
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.black);
            myBuffer.fillRect(0,0,FRAME,FRAME);
           
            
            
           
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
				myBuffer.setColor(Color.white);
				for(int y = 0, y >=FRAME +10, y++);
				{
				myBuffer.fillRect(FRAME/2, y, 
            repaint();
            
           
         }
      }   
      
      
      public void score1(Ball ball)
      {
         if(ball.getX() - ball.getRadius() <= 0+ 10)
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
         if(ball.getX() + ball.getRadius() >= FRAME - 10)
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
         if(ball.getY() - ball.getRadius() <= 0+ 10)
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
         if(ball.getY() + ball.getRadius() >= FRAME - 10)
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
            myBuffer.setColor(Color.red);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER: Player1 " , (FRAME/2)-200, FRAME/2);
         }
         if(z>10)
         {
            myBuffer.setColor(Color.red);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER: Player2 " , (FRAME/2)-200, FRAME/2);
         }
         if(a>10)
         {
            myBuffer.setColor(Color.red);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER: Player3 " , (FRAME/2)-200, FRAME/2);
         }
         if(b>10)
         {
            myBuffer.setColor(Color.red);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("LOSER: Player4 " , (FRAME/2) - 200, FRAME/2);
         }
      
      }
   
   }

	
    
   


