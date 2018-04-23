package nostalgia;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    private static final String SID = "AC1085ed1b8f3d237ffaf892d8d5c9348f";
    private static final String TOKEN = "bf13fd4915695bf6ba95795e92d50690";
    private static final String NUMBER = "+1 202-804-1981 ";

    public static boolean SendSms(String content, String address) {
        Twilio.init(SID, TOKEN);
        Message message = Message.creator(
            new PhoneNumber(address),
            new PhoneNumber(NUMBER),
              content).create();

        message.getSid();
        return true;
    }

    public static boolean ChallengeFriend(String username, String game, float score, String address) {
        String content = String.format(
            "Your friend %s would like to challenge you to beat their highscore of %f in %s!",
            username, score, game);
        return SendSms(content, address);
    }

    public static void main(String[] args) {
        System.out.println("SmsSender - main. Hello, world!");
    }
}