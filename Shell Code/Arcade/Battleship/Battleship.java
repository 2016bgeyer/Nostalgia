	//Name______________________________ Date_____________
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   public class Battleship extends JPanel
   {
      private JButton[][] board;
      private int[][] matrix;
      private int hits, torpedoes;
      private JLabel label;
      private JButton reset;
      public Battleship()
      {
         setLayout(new BorderLayout());
         hits = 0;
         torpedoes = 20;
      
         JPanel north = new JPanel();
         north.setLayout(new FlowLayout());
         add(north, BorderLayout.NORTH);
         label = new JLabel("Welcome to Battleship -- You have 20 torpedoes.");
         north.add(label);
      
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(10,10));
         add(center, BorderLayout.CENTER);
      
         board = new JButton[10][10];
         matrix = new int[10][10];
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board[r][c] = new JButton();
               board[r][c].setBackground(Color.blue);
               board[r][c].addActionListener( new Handler1(r, c) );
               center.add(board[r][c]);
            }
      
         reset = new JButton("Reset");
         reset.addActionListener( new Handler2() );
         reset.setEnabled(false);
         add(reset, BorderLayout.SOUTH);
      
         placeShip();
      }
      private void placeShip()
      {
         int coin = (int)(Math.random()*2);
         if(coin==1)
         {
            int x =(int)(Math.random()*11);
            int y =(int)(Math.random()*11);
            while(x>matrix.length-6)
               x=(int)(Math.random()*11);
            for(int k=0;k<4;k++)
               matrix[x+k][y]=1;
         }
         else
         {
            int x =(int)(Math.random()*11);
            int y =(int)(Math.random()*11);
            while(y>matrix[0].length-6)
               y=(int)(Math.random()*11);
            for(int k=0;k<4;k++)
               matrix[x][y+k]=1;
         }
      }
      private class Handler1 implements ActionListener
      {
         private int myRow, myCol;
         public Handler1(int r, int c)
         {
            myRow = r;
            myCol = c;
         }
         public void actionPerformed(ActionEvent e)
         {
            if(matrix[myRow][myCol]==1)
            {
               board[myRow][myCol].setBackground(Color.red);
               hits++;
               board[myRow][myCol].setEnabled(false);
               label.setText("You hit my battleship! torpedoes left:"+torpedoes);
            }
            else
            {
               board[myRow][myCol].setBackground(Color.white);
               label.setText("You missed my battleship! torpedoes left:"+torpedoes);
               board[myRow][myCol].setEnabled(false);
            
            }
            torpedoes--;
            if(hits==4)
            {
               label.setText("You sunk my battleship!");
               for(int k = 0; k<matrix.length;k++)
                  for(int x = 0 ;x<matrix[0].length;x++)
                     board[k][x].setEnabled(false);
            }
            else if(torpedoes<=0)
            {
               label.setText("You Lost!");
               for(int k = 0; k<matrix.length;k++)
                  for(int x = 0 ;x<matrix[0].length;x++)
                     board[k][x].setEnabled(false);
            }
            else
            {
               reset.setEnabled(true);
               label.setText("Welcome to Battleship -- You have "+torpedoes+" torpedoes.");
            
            
            }
         }
      }
      private class Handler2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            for(int k = 0; k<matrix.length;k++)
               for(int x = 0 ;x<matrix[0].length;x++)
                  board[k][x].setEnabled(true);
            hits = 0;
            torpedoes = 20;
            placeShip();
            for(int x = 0; x<matrix.length;x++)
               for(int k = 0; k<matrix.length;k++)
                  board[x][k].setBackground(Color.blue);
            label.setText("Welcome to Battleship -- You have "+torpedoes+" torpedoes.");
         
         }
      }
   }