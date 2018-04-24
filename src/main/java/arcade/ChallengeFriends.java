package arcade;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
//import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChallengeFriends implements ActionListener {

    JTextField email, phone, username, game, score;

    //public ChallengeFriends() {}

    public void run() {
        JFrame frame = new JFrame("Challenge a Friend");
        frame.setSize(400, 275);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.black);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        Insets inset = new Insets(4, 4, 4, 4);
        constraints.insets = inset;

        JLabel usernameLabel = new JLabel("Your name: ");
        usernameLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        JLabel gameLabel = new JLabel("Game: ");
        gameLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(gameLabel, constraints);

        JLabel scoreLabel = new JLabel("Score: ");
        scoreLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(scoreLabel, constraints);

        panel.add(new JSeparator());
        
        JLabel emailLabel = new JLabel("Friends email: ");
        emailLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(emailLabel, constraints);

        JLabel phoneLabel = new JLabel("Friends phone: ");
        phoneLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(phoneLabel, constraints);
        
        username = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(username, constraints);
        
        game = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(game, constraints);

        score = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(score, constraints);

        email = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(email, constraints);

        phone = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(phone, constraints);
        
        JButton emailButton = new JButton("Challenge via Email");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(emailButton, constraints);
        emailButton.setActionCommand("SendEmail");
        emailButton.addActionListener(this);

        JButton phoneButton = new JButton("Challenge via phone");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(phoneButton, constraints);
        phoneButton.setActionCommand("SendSMS");
        phoneButton.addActionListener(this);

        //panel.setBorder(new EmptyBorder(1, 1, 1, 1));

        frame.add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SendEmail")) {
            //Send Email
            if (!EmailSender.ChallengeFriend(
                username.getText(),
                game.getText(), 
                Integer.parseInt(score.getText()), 
                email.getText()
            )) {
                JOptionPane.showMessageDialog(null, "Error sending your message." +
                " Check to be sure that all of your fields are filled in.");
            }

        } else if (e.getActionCommand().equals("SendSMS")) {
            //Send SMS
            if (!SmsSender.ChallengeFriend(
                username.getText(),
                game.getText(), 
                Integer.parseInt(score.getText()), 
                phone.getText()
            )) {
                {
                    JOptionPane.showMessageDialog(null, "Error sending your message." +
                    " Check to be sure that all of your fields are filled in.");
                }
            }
        }
    }
}