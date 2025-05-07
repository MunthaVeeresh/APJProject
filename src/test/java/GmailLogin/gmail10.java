//package GmailLogin;
//
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//import org.apache.hc.core5.http.Message;
//
//public class gmail10 {
//	public static void main(String[] args) {
//		//Create object to "Properties" class and set "mailing server" values
//				Properties props=new Properties();
//				props.put("mail.smtp.host","smtp.gmail.com");
//				props.put("mail.smtp.socketFactory.port","465");
//				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//				props.put("mail.smtp.auth","true");
//				props.put("mail.smtp.port","465");
//				// This will handle the complete authentication(credentials)
//				Authenticator auth=new Authenticator()
//				{
//					protected PasswordAuthentication getPasswordAuthentication() 
//					{
//						return new PasswordAuthentication("magnitiait","iufdfrvdfeehpepw");
//					}
//				};
//				//Create object of Session class by using properties and authentication info
//				Session s=Session.getDefaultInstance(props,auth);
//				//Create object of Message class and set details
//				Message msg=new MimeMessage(s);
//				msg.setFrom(new InternetAddress("magnitiait@gmail.com"));
//				msg.setRecipients(Message.RecipientType.TO,
//						          InternetAddress.parse("magnitiait@gmail.com"));
//				msg.setSubject("Testing Subject");
//				// Create object to add multimedia type content for body and attachment
//				BodyPart bodymsg1=new MimeBodyPart();
//				bodymsg1.setText("Hi manager\n please refer atached test results");
//				BodyPart bodymsg2=new MimeBodyPart();
//				String filename="E:\\Model Resume Exp.doc";
//				DataSource source=new FileDataSource(filename);
//				bodymsg2.setDataHandler(new DataHandler(source));
//				bodymsg2.setFileName(filename);
//				// Create object of MimeMultipart class
//				Multipart mpart=new MimeMultipart();
//				mpart.addBodyPart(bodymsg1);
//				mpart.addBodyPart(bodymsg2);
//				msg.setContent(mpart);
//				// Finally send the email
//				Transport.send(msg);
//				System.out.println("=====Email Sent=====");
//	}
//
//}
