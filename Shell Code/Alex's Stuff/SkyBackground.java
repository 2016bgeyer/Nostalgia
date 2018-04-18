   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class SkyBackground extends JPanel
   {
      private static final int FRAME = 1000;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Bumper bumper;
		private Polkadot city, city1, city2, city3;
		private Ball aster1, aster2, aster3;
      public Timer timer;
   
      public SkyBackground()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
			
         Color sky = new Color (73, 73, 73);
         Color ground = new Color (174, 107, 26);
			Color Truck = new Color (56, 106, 33);
			Color Town = new Color (175, 175, 175);
			Color Aster = new Color (104, 104, 104);
			
         myBuffer.setColor(sky);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         myBuffer.setColor(ground);
         myBuffer.fillRect (0, 801, 999, 999);
      	
         addKeyListener(new Key());
         setFocusable(true);
         addMouseListener(new Mouse());
         addMouseMotionListener(new Mouse());
			
         bumper = new Bumper(FRAME/2-40, FRAME-40, 100, 30, Truck);
      	city = new Polkadot(100.00, 900.00, 50.00, Town);
      	city1 = new Polkadot(350.00, 900.00, 50.00,  Town);
			city2 = new Polkadot(650, 900.00, 50.00,  Town);
			city3 = new Polkadot(900, 900.00, 50.00,  Town);
			aster1 = new Ball (275, 20, 15, Aster);
			aster2 = new Ball (550, 20, 15, Aster);
			aster3 = new Ball (825, 20, 15, Aster);
			
         timer = new Timer(0, new Listener2());
         timer.start();
      	
      
      
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
				aster1.move (1000, 1000);
			   aster2.move (1000, 1000);
			   aster3.move (1000, 1000);
			
            bumper.draw(myBuffer);
				city.draw (myBuffer);
				city1.draw (myBuffer);
				city2.draw (myBuffer);
				city3.draw (myBuffer);
				aster1.draw (myBuffer);
				aster2.draw (myBuffer);
				aster3.draw (myBuffer);
            repaint();
         }
      }
      public void paintComponent (Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
        
      	repaint();
      }
      public class Mouse implements MouseListener, MouseMotionListener
      {
         public void mouseDragged(MouseEvent e)
         {
         
         
         }
         public void mouseClicked(MouseEvent e)
         {
         
         }
         public void mousePressed(MouseEvent e)
         {
            
         }
         
         public void mouseMoved(MouseEvent e)
         {
            bumper.setX(e.getX());
				
         }
         public void mouseReleased(MouseEvent e)
         {
         
         }
         public void mouseExited(MouseEvent e)
         {
            
            
         }
         public void mouseEntered(MouseEvent e)
         {
            
            
         }
      	
        
      }
      		
      public class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
         
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
               bumper.setX(bumper.getX()- 25);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               bumper.setX(bumper.getX()+25);
            }
         }
      }
   }