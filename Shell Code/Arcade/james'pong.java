import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;


public class Ball extends JPanel
{
private int delay = 10;
//Create a timer with delay 1000 ms
private Timer timer = new Timer(delay, new TimerListener());
private int x = 0; private int y = 0; //current ball position
private int radius = 5; //ball radius
private int dx = 2; // increment on ball's x-coordinate
private int dy = 2; //increment on ball's y-coordinate

public Ball()
{
timer.start();
private class TimerListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
repaint();
}
protected void paintComponent(Graphics g)
{
super.paintComponent(g);
g.setColor(Color.red);
if (x < radius) 
{
dx = Math.abs(dx);
}
if (x > getWidth() - radius) 
{
dx = -Math.abs(dx);
}
if (x < radius) 
{
dy = Math.abs(dy);
} 
if (y > getHeight() - radius) {
dy = -Math.abs(dy);
}
//adjust ball position
x += dx;
y += dy;
g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
}
public void suspend()
{
timer.stop();
}
public void resume()
{
timer.start();
}
public void setDelay(int delay)
{
this.delay = delay;
timer.setDelay(delay);
}





public class BallControl extends JPanel 
{
private Ball ball = new Ball();
private JButton jbtSuspend = new JButton("Suspend");
private JButton jbtResume = new JButton("Resume");
private JScrollBar jsbDelay = new JScrollBar();
}

public BallControl()
{
//group buttons in a panel
JPanel panel = new JPanel();
panel.add(jbtSuspend);
panel.add(jbtResume);
//add ball and buttons to the panel
ball.setBorder(new javax.swing.border.LineBorder(Color.red));
ball.setDelay(jsbDelay.getMaximum());
setLayout(new BorderLayout());
add(jsbDelay, BorderLayout.NORTH);
add(ball, BorderLayout.CENTER);
add(panel, BorderLayout.SOUTH);
//register listeners
jbtSuspend.addActionListener(new ActionListener()
}



public void actionPerformed(ActionEvent e)
{
jbtResume.addActionListener(new ActionListener()
}
public void actionPerformed (ActionEvent e)
{
ball.resume();
}
}
jsbDelay.addAdjustmentListener(new AdjustmentListener() 
{
public void adjustmentValueChanged(AdjustmentEvent e)
{
ball.setDelay(jsbDelay.getMaximum() - e.getValue());
}
}
}