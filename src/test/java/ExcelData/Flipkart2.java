//package ExcelData;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.net.Authenticator;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Properties;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//import javax.activation.DataHandler;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Transport;
//
//import org.apache.hc.core5.http.Message;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import com.mysql.cj.Session;
//
//import atu.testrecorder.ATUTestRecorder;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
package ExcelData;

//public class Flipkart2 {
//	public static void main(String[] args) {
//		//Start recording
//				SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
//		        Date dt=new Date();
//		        String vp="target\\"+sf.format(dt); //".mov" is default extension
//		        ATUTestRecorder recorder=new ATUTestRecorder(vp,false); //false means no audio
//		        recorder.start();
//				//Open Chrome browser
//				WebDriverManager.chromedriver().setup();
//				RemoteWebDriver driver=new ChromeDriver();
//				driver.manage().window().maximize();
//				//Launch site
//				driver.get("https://www.flipkart.com");
//				Thread.sleep(5000);
//				//close banner if exists
//				try
//				{
//					driver.findElement(By.xpath(
//							"(//span[text()='Login'])[1]/preceding::button[1]")).click();
//					Thread.sleep(5000);
//				}
//				catch(Exception ex)
//				{
//					System.out.println("No banner for this time");
//				}
//				//click on "mobiles" link
//				driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
//				Thread.sleep(5000);
//				//click on "Shop Now" for 1st product
//				driver.findElement(By.xpath("(//p[text()='Shop Now'])[1]")).click();
//				Thread.sleep(5000);
//				//collect and display name and price of each model via pagination
//				int total=0;
//				List<String> names=new ArrayList<String>();
//				List<Integer> prices=new ArrayList<Integer>();
//				while(true)
//				{
//					//Step-1:collect all models in current page
//					List<WebElement> models=driver.findElements(By.xpath(
//							                   "//div[starts-with(@data-id,'MOB')]"));
//					total=total+models.size();
//					//Step-2:goto each model to get name and price
//					for(WebElement model:models)
//					{
//						//get name and add to names list
//						String name=model.findElement(By.xpath(
//								"(child::div/a/div[2]/div/div)[1]")).getText();
//						names.add(name);
//						//get price and add to prices list
//						String price=model.findElement(By.xpath(
//								"child::div/a/div[2]/div[2]/div[1]/div[1]/div[1]")).getText();
//						price=price.substring(1); //remove currency symbol at index=0
//						price=price.replace(",",""); //remove ","
//						int p=Integer.parseInt(price);
//						prices.add(p);
//					}
//					//Step-3:goto next page if exists
//					try
//					{
//						driver.findElement(By.xpath("//span[text()='Next']")).click();
//						Thread.sleep(3000);
//					}
//					catch(Exception e)
//					{
//						break; //terminate from loop
//					}
//				}
//				System.out.println("Total models are "+total);
//				//Find highest price and corresponding model name
//				String maxmodel=names.get(0);
//				int maxprice=prices.get(0);
//				for(int i=1;i<prices.size();i++) //compare from 2nd item to last item
//				{
//					if(prices.get(i)>maxprice)
//					{
//						maxprice=prices.get(i);
//						maxmodel=names.get(i);
//					}
//				}
//				System.out.println("Maximum price "+maxprice+" model is "+maxmodel);
//				//Find lowest price and corresponding model name
//				String minmodel=names.get(0);
//				int minprice=prices.get(0);
//				for(int i=1;i<prices.size();i++) //compare from 2nd item to last item
//				{
//					if(prices.get(i)<minprice)
//					{
//						minprice=prices.get(i);
//						minmodel=names.get(i);
//					}
//				}
//				System.out.println("Minimum price "+minprice+" model is "+minmodel);
//				//close
//				driver.close();
//				//stop recording
//				recorder.stop();
//				//convert video file into zip file
//				File fileToZip=new File(vp+".mov");
//		        FileInputStream fis=new FileInputStream(fileToZip);
//				File zipfile=new File(vp+".zip");
//				FileOutputStream fos=new FileOutputStream(zipfile);
//		        ZipOutputStream zipOut=new ZipOutputStream(fos);
//		        ZipEntry zipEntry=new ZipEntry(fileToZip.getName());
//		        zipOut.putNextEntry(zipEntry);
//		        byte[] bytes=new byte[1024];
//		        int length;
//		        while((length=fis.read(bytes))>=0) 
//		        {
//		            zipOut.write(bytes, 0, length);
//		        }
//		        zipOut.close();
//		        fis.close();
//		        fos.close();
//				//forward that zip file to management via email
//				//Create object to Properties class and set "host" values
//				Properties props=new Properties();
//				props.put("mail.smtp.host","smtp.gmail.com");
//				props.put("mail.smtp.socketFactory.port","465");
//				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//				props.put("mail.smtp.auth","true");
//				props.put("mail.smtp.port","465");
//				// This will handle the complete authentication
//				Authenticator auth=new Authenticator()
//				{
//					protected java.net.PasswordAuthentication getPasswordAuthentication() 
//					{
//						return new PasswordAuthentication("magnitiait","iufdfrvdfeehpepw");
//					}
//				};
//				//Create object of Session class by using properties and authentication info
//				Session session=Session.getDefaultInstance(props,auth);
//				//Create object of Message class and set details
//				javax.mail.Message msg=new MimeMessage(session);
//				msg.setFrom(new InternetAddress("magnitiait@gmail.com"));
//				msg.setRecipients(Message.RecipientType.TO,
//						          InternetAddress.parse("magnitiait@gmail.com"));
//				msg.setSubject("Testing Subject");
//				// Create object to add multimedia type content
//				BodyPart bodymsg1=new MimeBodyPart();
//				bodymsg1.setText("This is message body");
//				BodyPart bodymsg2=new MimeBodyPart();
//				String filename=zipfile.getAbsolutePath();
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
