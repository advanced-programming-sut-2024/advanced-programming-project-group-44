package com.ap.gwentgame.server;

import com.ap.gwentgame.client.controller.ControllerUtilities;
import com.ap.gwentgame.client.controller.VerificationController;
import com.ap.gwentgame.client.model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    private final String username = "gwentgame316@gmail.com";
    private final String password = "ydab ctrc gwbu zxah";

    private Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return props;
    }

    public void sendEmail(String to, String subject, String body) {
        Session session = Session.getInstance(getProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void createEmailStructure(String email, User user, int verifyInt) {
        String subject = "Welcome to GwentGame!";
        String body = "Dear " + user.getName() + ",\n\n" +
                "Thank you for signing up for GwentGame! We hope you enjoy our game.\n\n" +
                "This is your verification code: " + verifyInt + "\n" +
                "Best regards,\n" +
                "The GwentGame Team";
        sendEmail(email, subject, body);
    }
}
