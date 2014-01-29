/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mailv1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

// Send a simple, single part, text/plain e-mail
public class TestEmail {

    public static void main(String[] args) {
      	Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
        String h="15:30:00";
        String t=sdf.format(cal.getTime()) ;
        
   String str2 = "08:03:10 pm";
 DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
// Date date = (Date)formatter.parse(str2);   
      String str3 = "08:04:10 pm";

 //Date date2 = (Date)formatter.parse(str3);              
        // DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//String date=format.format(new Date());
//System.out.println( date);
      
      Time t1=java.sql.Time.valueOf("08:04:10");
            Time t2=java.sql.Time.valueOf("08:05:10");
               
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        String to =   "so_what_then@hotmail.com";
        String from = "chaoukiayachi@gmail.com";
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        String host = "smtp.orange.tn";

        // Create properties, get Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host", host);
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
       //Session session = Session.getInstance(props);

		
		
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("douiri.marwa@gmail.com","591988591988");
				}
			});
        try {
            // Instantiatee a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");
            msg.setSentDate(new Date());

            // Set message content
            msg.setText("This is a test of sending a " +
                        "plain text e-mail through Java.\n" +
                        "Here is line 2.");

            //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
    }
}//End of class

