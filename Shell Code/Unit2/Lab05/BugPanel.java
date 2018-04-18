//Ben Geyer
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class BugPanel extends JPanel
   {
      private BufferedImage myImage;
      final int N = 400;
       public BugPanel()
      {
         myImage = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
         Graphics buffer = myImage.getGraphics();
         buffer.setColor(Color.BLACK);
         buffer.fillRect(0, 0, N, N);
         buffer.setColor(Color.RED);
      Bug a = new Bug(0,0);
		Bug b = new Bug(400,0);
		Bug c = new Bug(400,400);
		Bug d = new Bug(0,400);
		
		for(int k=0; k<=50; k++)
		{
		a.getX();
		a.getY();
		a.sameSpot(b );
		a.walkTowards(b, .10);
		b.getX();
		b.getY();
		b.sameSpot(c );
		b.walkTowards(c, .10);
		c.getX();
		c.getY();
		c.sameSpot(d );
		c.walkTowards(d, .10);
		d.getX();
		d.getY();
		d.sameSpot(a );
		d.walkTowards(a, .10);
		buffer.drawLine(a.getX(),a.getY(), b.getX(),b.getY());
   	buffer.drawLine(b.getX(),b.getY(), c.getX(),c.getY());
		buffer.drawLine(c.getX(),c.getY(), d.getX(),d.getY());
   	buffer.drawLine(d.getX(),d.getY(), a.getX(),a.getY());
      }   
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
		
		
	}