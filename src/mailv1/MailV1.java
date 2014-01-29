/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mailv1;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author mcd
 */
public class MailV1 {

   
    public static void main(String [] args) {
	Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("douiri.marwa@gmail.com","591988591988");
				}
			});
 
		try {
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText("JavaMail vous dit bonjour!");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("so_what_then@hotmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("so_what_then@hotmail.com"));
			//message.setSubject("Testing Subject");
		//	message.setText("Dear Mail Crawler," +
					//"\n\n No spam to my email, please!");
			MimeBodyPart mbp2 = new MimeBodyPart();
			String file = "/C:/Users/MARWA/Downloads/tcartagi.png";
		mbp2.attachFile(file);
		DataSource ds=new FileDataSource(file); 
		mbp2.setDataHandler(new DataHandler(ds)); 
		mbp2.setHeader("Content-ID","the-img-1");

		MimeMultipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		mp.addBodyPart(mbp2);
		message.setSubject("subject");
		message.setContent(mp);
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
