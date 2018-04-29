import org.junit.Test;
import static org.junit.Assert.assertEquals;

import arcade.*;

public class EmailSenderTest {
    @Test
    public void validEmail() {
        assertEquals(EmailSender.ChallengeFriend("Test User", "Test Game", 0, "jakettapper@gmail.com"), true);
    }

    @Test
    public void missingParametersEmail() {
        assertEquals(EmailSender.ChallengeFriend("", "Test Game", 0, "jakettapper@gmail.com"), false);
        assertEquals(EmailSender.ChallengeFriend("Test User", "", 0, "jakettapper@gmail.com"), false);
        assertEquals(EmailSender.ChallengeFriend("Test User", "Test Game", 0, ""), false);

        assertEquals(EmailSender.ChallengeFriend("", "", 0, "jakettapper@gmail.com"), false);
        assertEquals(EmailSender.ChallengeFriend("", "Test Game", 0, ""), false);
        assertEquals(EmailSender.ChallengeFriend("Test User", "", 0, ""), false);

        assertEquals(EmailSender.ChallengeFriend("", "", 0, ""), false);
    }

    @Test
    public void badEmail() {
        assertEquals(EmailSender.ChallengeFriend("Test User", "Test Game", 0, "fakeemail"), false);
    }
}