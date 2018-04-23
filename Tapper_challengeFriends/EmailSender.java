package nostalgia;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static boolean SendEmail(String content, String subject, String address) {
        final String user = "e983e32b5cdfe6b4ad3cb27c9162156a";
        final String pass = "1dd96e65d3fee97b231b7dbe9206b218";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "in-v3.mailjet.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                }
                );
        try {
            Message m = new MimeMessage(session);

            m.setText(content);
            m.setSubject(subject);
            m.setFrom(new InternetAddress("nostalgiachallengeservice@gmail.com"));
            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));

            Transport.send(m);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean ChallengeFriend(String username, String game, float score, String address) {
        String content = String.format(
            "Your friend %s would like to challenge you to beat their highscore of %f in %s!",
            username, score, game);
        return SendEmail(content, "Nostalgia Challenge", address);
    }

    public static void main(String[] args) {
        System.out.println("EmailSender - main. Hello, world!");
    }

}
//mvn clean package
//mvn exec:java -D exec.mainClass=nostalgia.EmailSender