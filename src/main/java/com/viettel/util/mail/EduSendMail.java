package com.viettel.util.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EduSendMail {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void main(String args[]) throws AddressException, MessagingException {
//		generateAndSendEmail();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}

//	public void sendMail(String username, String[] chapters, Integer totalNumQuestion, Integer numEasy,
//			Integer numMedium, Integer numDiff, Integer numVeryDiff, String subject) {
//		
//			try {
//				sendEmail(username, chapters, totalNumQuestion, numEasy,
//						numMedium, numDiff, numVeryDiff, subject);
//			} catch (AddressException e) {
//				e.printStackTrace();
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}
//		
//	}

	/*public static void generateAndSendEmail() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("docaohuynh.cse@gmail.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("docaohuynh0601@gmail.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = ContentMail.content();
		generateMailMessage.setContent(emailBody, "text/html; charset=utf-8");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "docaohuynh1@gmail.com", "huynh0601do");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}*/

	public void sendEmail(ContentMail contentMail) throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(contentMail.getEmail()));
//		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("docaohuynh0601@gmail.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
//		ContentMail contentMail = new ContentMail(username, chapters, totalNumQuestion, numEasy, numMedium, numDiff, numVeryDiff, subject);
		String emailBody = contentMail.content();
//		generateMailMessage.setContent(emailBody, "text/html; charset=utf-8");
		
		// Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();
     // Now set the actual message
        messageBodyPart.setContent(emailBody, "text/html; charset=utf-8");

        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "C:\\Users\\docaohuynh\\Desktop\\New Text Document.txt";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        
        messageBodyPart = new MimeBodyPart();
        String filename1 = "C:\\Users\\docaohuynh\\Desktop\\New Text Document.txt";
        DataSource source1 = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source1));
        messageBodyPart.setFileName(filename1);
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        generateMailMessage.setContent(multipart);

		
		
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "docaohuynh1@gmail.com", "huynh0601do");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
