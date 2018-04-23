// found this code tutorial from: https://www.youtube.com/watch?v=ulbqZUnl_sk
//most of this code has been copied and modified. 

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JFrame;

public class CustomButton extends JButton implements MouseListener{
  Dimension size = new Dimension(250,100);
  
  boolean hover = false;
  boolean click = false;
  
  String text = "";

  public CustomButton(String text){
    setVisible(true);
    setFocusable(true);
    setContentAreaFilled(false);
    setBorderPainted(false);
    
    this.text = text;
    
    addMouseListener(this);
  }
  
    @Override 
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      
      //when clicked, the entire box turns white
      if(click){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,200,100);
      }
      
      //border of the box
      g.setColor(new Color(0, 230, hover ? 180 : 30));
      g.fillRect(0,0,200,7);
      g.fillRect(0,93,200,7);
      g.fillRect(0,0,7,100);
      g.fillRect(193,0,7,100);
      
      //text of the buttons
      g.setColor(Color.WHITE);
      g.setFont(Font.decode("arial-BOLD-20"));
      
      FontMetrics metrics = g.getFontMetrics();
      
      int width = metrics.stringWidth(text);
      
      g.drawString(text, 100-width/2, 56);
    }
  
    
    @Override
    public Dimension getPreferredSize(){
      return size;
    }
    
    @Override
    public Dimension getMinimumSize(){
      return size;
    }
    
    @Override
    public Dimension getMaximumSize(){
      return size;
    }
    
    public void setButtonText(String text){
      this.text = text;
    }
    
    public String getButtonText(){
      return this.text;
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
      hover = true;
    }
    
    @Override
    public void mouseExited(MouseEvent e){
      hover = false;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
      click = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
      click = false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
      if(this.text.equals("BrickBreaker")){
        JFrame frame = new JFrame("BrickBreaker");
         frame.setSize(500, 500);
         frame.setLocation(300, 325);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BrickPanel2());
         frame.setVisible(true);
      }
      else if(this.text.equals("Challenge Friends")){
        String user = JOptionPane.showInputDialog("Enter Username of Friend");
        String game = JOptionPane.showInputDialog("Game you want to challenge in?");
        int score = Integer.parseInt(JOptionPane.showInputDialog("Score you have"));
        
        //new challengeFriends().show(user, game, score);
      }
      /*else if(this.text.equals("High Score")){
        //help?
      }*/
      else if(this.text.equals("Exit")){
        System.exit(1);
      }
    }
  }