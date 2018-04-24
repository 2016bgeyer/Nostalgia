package arcade.FinishedBrickBreaker;
   
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import javax.swing.JOptionPane;
   
   public class BrickPanelnew extends JPanel
   {
      private static final int FRAME = 900, BUTTON1=1, BUTTON3=3;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private static final Color BALL_COLOR = Color.BLUE;
      private static final Color PRIZE_COLOR = Color.RED;
      private static final Color BUMPER_COLOR = Color.gray;
      private static final double BALL_DIAM = 50;
      private static final double PRIZE_DIAM = 25;
      private static final int BUMPER_X_WIDTH = 175;
      private static final int BUMPER_Y_WIDTH = 50;
      private int bricklength = 50;
      private int brickwidth = 81;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball;
      public Bumper bumper;
      private Timer timer;    
      private Bumper[][] myBrickarray;
      private int x = 0;
      private int y = 0;
      private int u=0;
      public  double pausex, pausey;
      private boolean start;
      public int life = 3, score = 0;
      public String playagain;
      public Color brickcolor;
      public BrickPanelnew()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         
         ball = new Ball(FRAME/2-BUMPER_X_WIDTH, FRAME/2-BUMPER_Y_WIDTH, BALL_DIAM, BALL_COLOR);
         addMouseListener(new Mouse());
         addMouseMotionListener(new Mouse());    
         bumper = new Bumper(FRAME-BUMPER_X_WIDTH, FRAME-BUMPER_Y_WIDTH, BUMPER_X_WIDTH, BUMPER_Y_WIDTH, BUMPER_COLOR);
         myBrickarray= new Bumper[5][9];
         for(int row = 0; row<myBrickarray.length; row++)
         {
            for(int col = 0; col<myBrickarray[0].length;col++)
            {
               x=col*15+col*brickwidth+25;
               y=row*10+row*bricklength+40;
               int blahint = generaterandom();
               Color brickcolor = chooseColor(blahint);
               
               if(col==0&&row==0)
               {
                  myBrickarray[0][0] = new Bumper(25+brickwidth,40+bricklength,brickwidth,bricklength,brickcolor);
               }
               myBrickarray[row][col] = new Bumper(x,y,brickwidth,bricklength,brickcolor);
            }
         }
         timer = new Timer(10, new Listener());
         timer.start();
         Thread t = new Thread();
         t.start();    
         addKeyListener(new Key());
         setFocusable(true);
         start = true;
      
      }
      public int generaterandom()
      {
         int randomnumber = (int)(Math.random()*12+1);
      
         return randomnumber;
      }
      public Color chooseColor(int brickint)
      {
         if(brickint==1)
            brickcolor=Color.white;
         if(brickint==2)
            brickcolor=Color.cyan;
         if(brickint==3)
            brickcolor=Color.pink;
         if(brickint==4)
            brickcolor=Color.green;
         if(brickint==5)
            brickcolor=Color.yellow;
         if(brickint==6)
            brickcolor=Color.orange;
         if(brickint==7)
            brickcolor=Color.magenta;
         if(brickint==8)
            brickcolor=Color.blue;
         if(brickint==9)
            brickcolor=Color.gray;
         if(brickint==10)
            brickcolor=Color.darkGray;
         if(brickint==11)
            brickcolor=Color.red;
        
         return brickcolor;
      
      }
      public class Mouse implements MouseListener, MouseMotionListener
      {
         public void mouseDragged(MouseEvent e)
         {
         
         
         }
         public void mouseClicked(MouseEvent e)
         {
            if(start)
            {
               ball.setdx((int)(Math.random()*14-7));
               ball.setdy((int)(Math.random()*14-7));
               start = false;
            }
         }
         public void mousePressed(MouseEvent e)
         {
            if(start)
            {
               ball.setdx((int)(Math.random()*14-7));
               ball.setdy((int)(Math.random()*14-7));
               start = false;
            }
            
         }
         public void mouseMoved(MouseEvent e)
         {
            bumper.setmyX(e.getX()*2);
         }
         public void mouseReleased(MouseEvent e)
         {
         
         }
         public void mouseExited(MouseEvent e)
         {
            pause(ball);
            
         }
         public void mouseEntered(MouseEvent e)
         {
            resume(ball);
            
         }
      	
        
      }
      public void resetBall(Ball ball, boolean start)
      {
         if(start)
         {
            ball.setX(bumper.getX()+bumper.getXWidth()/2);
            ball.setY(bumper.getY()-(ball.getDiameter()));
         }
      }
      public void pause(Ball ball)
      {
         pausex = ball.getdx();
         pausey = ball.getdy();
         ball.setdx(0);
         ball.setdy(0);
      }
      public void resume(Ball ball)
      {
         ball.setdx(pausex);
         ball.setdy(pausey);
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      public void loseLife(Ball ball)
      {
         if(ball.getY()>FRAME)
         {
            life--;
            start = true;
            ball.setX(FRAME/2);
            ball.setY(FRAME-ball.getRadius());
         }
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // clear buffer and move ball
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(0,0,FRAME,FRAME); 
            ball.move(FRAME, FRAME, 0, 0);
            
            BrickCollisionnew.collide2(myBrickarray, ball);
            
            for(int k = 0; k<myBrickarray.length; k++)
               for(int r = 0; r<myBrickarray[0].length; r++)
                  myBrickarray[k][r].draw(myBuffer);
               
            loseLife(ball);
            lifeCheck(life);
            resetBall(ball,start);
            brickCheck(myBrickarray);
            ball.draw(myBuffer);
            checkBumper(bumper,ball);
            bumper.draw(myBuffer);
            
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("Score: " + score, 40,30);
            
            myBuffer.setColor(Color.green);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 40));
            myBuffer.drawString("Lives: " + life, (FRAME-250),30);
            
            BumperCollision.collide(bumper, ball);
            bumper.draw(myBuffer);
         
         
         
            repaint();
         }
      }
      public void checkBumper(Bumper bumper,Ball ball)
      {
         if(bumper.getX()>FRAME-bumper.getXWidth())
         {
            bumper.setmyX(FRAME-bumper.getXWidth());
         }
         if(start)
         {
            if(bumper.getX()>FRAME-bumper.getXWidth())
            {
               bumper.setmyX(FRAME-bumper.getXWidth());
               ball.setX(FRAME-ball.getDiameter());
            }
         }
      
      }
      public void resetBricks(Bumper[][] array)
      {
         score=0;
         start=true;
         for(int row = 0; row<myBrickarray.length; row++)
         {
            for(int col = 0; col<myBrickarray[0].length;col++)
            {
               x=col*15+col*brickwidth+25;
               y=row*10+row*bricklength+40;
               int blahint = generaterandom();
               Color brickcolor = chooseColor(blahint);
               if(col==0&&row==0)
               {
                  myBrickarray[0][0] = new Bumper(25+brickwidth,40+bricklength,brickwidth,bricklength,brickcolor);
               }
               
            	
               myBrickarray[row][col] = new Bumper(x,y,brickwidth,bricklength,brickcolor);
            }
         }
      }
      public void win(Bumper[][] array)
      {
         for(int row = 0; row<array.length; row++)
         {
            for(int col = 0; col<array[0].length;col++)
            {
               array[row][col].setmyX(1010);
            }
         }
      }
      public void brickCheck(Bumper[][] array)
      {
         score = 0;
         for(int row = 0; row<array.length; row++)
         {
            for(int col = 0; col<array[0].length;col++)
            {
               if(array[row][col].getX()>1000)
               {
                  score++;
               
               }
            }
         }
         if(score>=45)
         {
            JOptionPane.showMessageDialog(null, "Congratulations!\nYou won!");
            System.exit(0);
         }
      }
      public void wintime(String playorno)
      {
         pause(ball);
         
         
         if(playorno.compareTo("Yes")==0||playorno.compareTo("yes")==0)
         {     
            score = 0;
            life = 3;
            resetBricks(myBrickarray);
            JOptionPane.showMessageDialog(null,"Great!");
         }
         if(playorno.compareTo("No")==0||playorno.compareTo("no")==0)
         {  
            JOptionPane.showMessageDialog(null,"Ok");
            System.exit(0);
         }
      
      
      
      
      }
      public void gameover()
      {
         pause(ball);
         playagain =JOptionPane.showInputDialog("You lost!\n Do you want play again?");
         if(playagain.compareTo("Yes")==0||playagain.compareTo("yes")==0)
         {     
            score = 0;
            life = 3;
            resetBricks(myBrickarray);
            JOptionPane.showMessageDialog(null,"Great!");
         }
         if(playagain.compareTo("No")==0||playagain.compareTo("no")==0)
         {  
            JOptionPane.showMessageDialog(null,"Ok");
            System.exit(0);
         }
      }
      
      public void lifeCheck(int life2)
      {
         if(life2<1)
            gameover();
      
      }
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
               if(bumper.getX() > 0)
                  bumper.setmyX(bumper.getX()-30);
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
               if(bumper.getX()<FRAME-BUMPER_X_WIDTH)
                  bumper.setmyX(bumper.getX()+30);
            if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
               ball.setdx((int)(Math.random()*14-7));
               ball.setdy((int)(Math.random()*14-7));
            }
            if(e.getKeyCode()==KeyEvent.VK_P)
            {
               if(timer.isRunning())
               {
                  pause(ball);
                  timer.stop();
               }
               else if(timer.isRunning()==false)
               {
                  resume(ball);
                  timer.start();
               }
            }
            if(e.getKeyCode()==KeyEvent.VK_P)
            {
               score++;
            }
            if(e.getKeyCode()==KeyEvent.VK_O)
            {
               life++;
            }
            if(e.getKeyCode()==KeyEvent.VK_M)
            {
               ball.setdy(ball.getdy()*1.1);
               ball.setdx(ball.getdx()*1.1);
            }
            if(e.getKeyCode()==KeyEvent.VK_N)
            {
               ball.setdy(ball.getdy()*.9);
               ball.setdx(ball.getdx()*.9);
            }
         }
      }
   
   }
