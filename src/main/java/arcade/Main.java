// found this code tutorial from: https://www.youtube.com/watch?v=DOwT8NyV51A
//most of this code has been copied and modified. 
package arcade;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;


public class Main extends JFrame{
  
  public Main(){
    JPanel panel = new JPanel();
    
    //title of the opened panel
    setTitle("Nostalgia");
    
    //Title on main screen
    JLabel title = new JLabel("NOSTALGIA");
    title.setFont(new Font("Arial Bold",1,50));
    title.setForeground(Color.white);
    panel.add(title);

    
    //size of panel that opens up 
    setSize(500,750);
    setResizable(false); //can't change size once open

    panel.setBackground(java.awt.Color.BLACK);
    CustomButton astroids = new CustomButton("Astroids");
    panel.add(astroids);
    add(panel);

    panel.setBackground(java.awt.Color.BLACK);
    CustomButton battleship = new CustomButton("Battleship");
    panel.add(battleship);
    add(panel);
    
    panel.setBackground(java.awt.Color.BLACK);
    CustomButton brickBreaker = new CustomButton("BrickBreaker");
    panel.add(brickBreaker);
    add(panel);

    panel.setBackground(java.awt.Color.BLACK);
    CustomButton pong = new CustomButton("Pong");
    panel.add(pong);
    add(panel);
    
    //high score option 
    /*CustomButton score = new CustomButton("High Score");
    panel.add(score);
    add(panel);*/
    
    CustomButton challenge = new CustomButton("Challenge Friends");
    panel.add(challenge);
    add(panel);
    
    CustomButton exit = new CustomButton("Exit");
    panel.add(exit);
    add(panel);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public static void main(String[] args){
    new Main();
  }
}