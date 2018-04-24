package arcade;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    //Twilio connection information
    private static final String SID = "AC1085ed1b8f3d237ffaf892d8d5c9348f";
    private static final String TOKEN = "bf13fd4915695bf6ba95795e92d50690";
    private static final String NUMBER = "+1 202-804-1981 ";

    private static boolean SendSms(String content, String address) {
        //Connect to the Twilio service
        Twilio.init(SID, TOKEN);
        Message message = Message.creator(
            new PhoneNumber(address),
            new PhoneNumber(NUMBER),
              content).create();

        //Send the message
        message.getSid();
        return true;
    }

    public static boolean ChallengeFriend(String username, String game, int score, String address) {
        //If data is missing, return
        if (username.equals("") || game.equals("") || address.equals("")) { return false; }
        
        //Format the contents of the SMS
        String content = String.format(
            "Your friend %s would like to challenge you to beat their highscore of %d in %s!",
            username, score, game);
        return SendSms(content, address);
    }
}