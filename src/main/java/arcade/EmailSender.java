package arcade;

import java.util.Properties;
//import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import com.google.api.services.gmail.GmailScopes;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class EmailSender {

    private static final String APPLICATION_NAME = "Gmail API Nostalgia";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials";

    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_SEND);
    private static final String apiString = "{\"installed\":{\"client_id\":\"344256445001-4vbhsgb9n47nlm3ogs0vcu2vide9s1r2.apps.googleusercontent.com\",\"project_id\":\"dominica-202404\",\"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\"token_uri\":\"https://accounts.google.com/o/oauth2/token\",\"auth_provider_x509_cert_url\":\"https://www.googleapis.com/oauth2/v1/certs\",\"client_secret\":\"xAo2GAgaqgqcxveZ9o5UStoZ\",\"redirect_uris\":[\"urn:ietf:wg:oauth:2.0:oob\",\"http://localhost\"]}}";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = new ByteArrayInputStream(apiString.getBytes(StandardCharsets.UTF_8));
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }


    private static boolean SendEmail(String content, String subject, String address) {
        //Set up the connection properties
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);
        
        //Try to send the message
        try {
            javax.mail.Message m = new MimeMessage(session);

            m.setText(content);
            m.setSubject(subject);
            m.setFrom(new InternetAddress("nostalgiachallengeservice@gmail.com"));
            m.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(address));

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            m.writeTo(buffer);
            byte[] bytes = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
            Message message = new Message();
            message.setRaw(encodedEmail);

            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

            message = service.users().messages().send("nostalgiachallengeservice@gmail.com", message).execute();

            return true;
        } catch (GoogleJsonResponseException e){
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean ChallengeFriend(String username, String game, int score, String address) {
        //If data is missing, return
        if (username.equals("") || game.equals("") || address.equals("")) { return false; }
        
        //Create the contents of the email and send it
        String content = String.format(
            "Your friend %s would like to challenge you to beat their highscore of %d in %s!",
            username, score, game);
        return SendEmail(content, "Nostalgia Challenge", address);
    }

}