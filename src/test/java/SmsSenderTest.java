import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.twilio.exception.ApiException;

import arcade.*;

public class SmsSenderTest {

    @Test
    public void validSMS() {
        //Should send an SMS to google voice account
        assertEquals(SmsSender.ChallengeFriend("Test User", "Test Game", 0, "(202) 417-8201"), true);
    }

    @Test
    public void emptyParameterSms() {
        assertEquals(SmsSender.ChallengeFriend("", "Test Game", 0, "(202) 417-8201"), false);
        assertEquals(SmsSender.ChallengeFriend("Test User", "", 0, "(202) 417-8201"), false);
        assertEquals(SmsSender.ChallengeFriend("Test User", "Test Game", 0, ""), false);

        assertEquals(SmsSender.ChallengeFriend("", "", 0, "(202) 417-8201"), false);
        assertEquals(SmsSender.ChallengeFriend("", "Test Game", 0, ""), false);
        assertEquals(SmsSender.ChallengeFriend("Test User", "", 0, ""), false);

        assertEquals(SmsSender.ChallengeFriend("", "", 0, ""), false);
    }

    @Test(expected = ApiException.class)
    public void badNumberSmS() {
        SmsSender.ChallengeFriend("Test User", "Test Game", 0, "111");
    }
}