package Loggers;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class LoggerError {

    public void sendError(String subject, String messageBody) {
        // Властивості для SMTP-сервера
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Аутентифікація
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("viktorluka2525@gmail.com", "mptg irwc egdq cazm");
            }
        });

        try {
            // Створити повідомлення
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("viktorluka2525@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lv418153@gmail.com"));
            message.setSubject(subject);
            message.setText(messageBody);

            // Відправляємо повідомлення
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}