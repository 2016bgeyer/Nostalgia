package nostalgia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChallengeFriends implements ActionListener {

    String username;
    String game;
    float score;
    JTextField email, phone;

    public ChallengeFriends(String _username, String _game, float _score) {
        username = _username;
        game = _game;
        score = _score;
    }

    public void run() {
        JFrame frame = new JFrame("Challenge a Friend");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        Insets inset = new Insets(4, 4, 4, 4);
        constraints.insets = inset;

        
        JLabel emailLabel = new JLabel("Friends email: ");
        emailLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(emailLabel, constraints);

        JLabel phoneLabel = new JLabel("Friends phone: ");
        phoneLabel.setForeground(Color.green);
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(phoneLabel, constraints);

        email = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(email, constraints);

        phone = new JTextField();
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(phone, constraints);

        JButton emailButton = new JButton("Challenge via Email");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(emailButton, constraints);
        emailButton.setActionCommand("SendEmail");
        emailButton.addActionListener(this);

        JButton phoneButton = new JButton("Challenge via phone");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(phoneButton, constraints);
        phoneButton.setActionCommand("SendSMS");
        phoneButton.addActionListener(this);

        panel.setBorder(new EmptyBorder(1, 1, 1, 1));

        frame.add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SendEmail")) {
            //Send Email
            EmailSender.ChallengeFriend(username, game, score, email.getText());

        } else if (e.getActionCommand().equals("SendSMS")) {
            //Send SMS
            SmsSender.ChallengeFriend(username, game, score, phone.getText());
        }
    }

    public static void show(String username, String game, float score) {
        new ChallengeFriends(username, game, score).run();
    }

    public static void main(String[] args) {
        show("Jake", "Pong", 5);
    }
}