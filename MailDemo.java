import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class MailDemo
{
	public static void main(String args[]) throws AddressException,
			
	MessagingException {
		
		String host="smtp.gmail.com";
		String port="465";
		final String userName = "testproject.kasnet@gmail.com";
		final String password = "kasnet12345";
		String toAddress = "anjali.kasnet@outlook.com";
		String subject="kuch bhi"; String message="kuch bhi naaa";
		int a=0;
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		//msg.setContent(message);
		msg.setContent(message,"text/html");

		// sends the e-mail
		Transport.send(msg);
		a=1;
		System.out.println("Mailed");
		

	}
}