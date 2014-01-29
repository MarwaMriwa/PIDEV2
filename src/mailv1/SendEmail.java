/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mailv1;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Envoyer un email
 */
public class SendEmail {

    private Session session = null;
    private Transport transport = null;

    /**
     * Fixer les propriétés
     */
    public void connect(String host, String user, String password) throws NoSuchProviderException, MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "true");
        //   properties.setProperty("mail.smtp.port", "587");  
        this.session = Session.getDefaultInstance(properties, null);
        this.transport = this.session.getTransport();
        this.transport.connect(host, user, password);
    }

    public void send(String from, String to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(this.session);
        message.setSubject(subject);
        message.setContent(body, "text/plain");
        message.addRecipient(Message.RecipientType.TO,  new InternetAddress(to));
        message.setFrom(new InternetAddress(from));
        this.transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        this.transport.close();
    }
    public boolean  Envoi(String server, String from, String to, String subject, String body){
boolean test=false;
//      specifier les prop de la session
      Properties props;
      props=System.getProperties();
      props.put("mail.smtp.host", server);

      //        creer une connection avec le serveur
      Session session;
      session=Session.getDefaultInstance(props);

//      creation des messages
      Message msg= new MimeMessage(session);
      try {
//      preciser les info de notre message
          msg.setFrom(new InternetAddress(from));
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
          msg.setSubject(subject);
          msg.setText(body);
          Transport.send(msg);
          System.out.println("message envoye");
          test=true;

      } catch (MessagingException ex) {
          Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
      }

return test;
    }

    /**
     * Exemple pour envoyer un email avec SMTP
     */
    public static void main(String args[]) throws MessagingException {
        SendEmail email = new SendEmail();
        // email.connect("smtp.planet.tn", "so_what_then@hotmail.com", "so_what_then@hotmail.com");
         // email.send("so_what_then@hotmail.com", "so_what_then@hotmail.com", "Envoyer un email avec JAVA", "Je suis le corps du message");

        
        boolean test=email.Envoi("smtp.planet.tn","so_what_then@hotmail.com", "douiri.marwa@gmail.com", "musubject", "votre pass");
System.out.println(test);
    }
}
