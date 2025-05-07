package AutomationPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class YahooMail6 {
	public static void main(String[] args) throws InterruptedException {
		//Open browser and Launch yahoo site
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://www.yahoomail.com");
				Thread.sleep(10000);
				//Click on signin in yahoo
				driver.findElement(By.linkText("Sign in")).click();
				Thread.sleep(5000);
				//Do login in yahoo
				driver.findElement(By.name("username")).sendKeys("muntha2000@yahoo.com");
				driver.findElement(By.name("signin")).click();
				Thread.sleep(5000);
				driver.findElement(By.name("password")).sendKeys("munthaveeresh2000@123");
				driver.findElement(By.name("verifyPassword")).click();
				Thread.sleep(5000);
				//handle News page if exists
				try
				{
					driver.findElement(By.xpath("//*[@title='Mail']")).click();
					Thread.sleep(5000);
				}
				catch(Exception ex)
				{
				}
				//Do mail compose in yahoo
				driver.findElement(By.linkText("Compose")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("message-to-field")).sendKeys(
						                             "magnitiait@gmail.com");
				driver.findElement(By.xpath("//input[@aria-label='Subject']"))
				                                            .sendKeys("Testing");
				driver.findElement(By.xpath("//div[@aria-label='Message body']"))
				                                     .sendKeys("hi\nhow are you?\nbye");
				driver.findElement(By.xpath("//input[@type='file']"))
				                                   .sendKeys("E:\\Model Resume Exp.doc");
				Thread.sleep(10000);
				//send mail in yahoo and get output message
				driver.findElement(By.xpath("//button[@title='Send this email']")).click();
				Thread.sleep(3000);
				String x=driver.findElement(By.xpath(
						"//div[@data-test-id='notifications']/descendant::span[1]"))
						.getText();
				System.out.println(x);
				//Take new Window or tab and switch to it
				driver.switchTo().newWindow(WindowType.TAB);
				Set<String> s=driver.getWindowHandles(); 
				ArrayList<String> l=new ArrayList<String>(s);
				//Switch to new window or tab(index is 1)
				driver.switchTo().window(l.get(1));
				//Launch Gmail site
				driver.get("https://www.gmail.com");
				Thread.sleep(5000);
				//Do login in Gmail site
				driver.findElement(By.name("identifier")).sendKeys("magnitiait"); 
				driver.findElement(By.xpath("//[text()='Next']/parent::")).click();
				Thread.sleep(5000);
				driver.findElement(By.name("Passwd")).sendKeys("44@Magnitia");
				driver.findElement(By.xpath("//[text()='Next']/parent::")).click();
				Thread.sleep(10000);
				//Check "from" address of latest mail
				String y=driver.findElement(By.xpath(
				                 "(//table)[6]/tbody/tr[1]/td[4]/div[2]/span/span"))
						                                     .getAttribute("email");
				if(y.contains("magnitiabatch251"))
				{
					System.out.println("Yahoo mail sent to Gmail completly working");
				}
				else
				{
					System.out.println(
							"Yahoo mail sent to Gmail not completly working");
				}
				//do logout in Gmail
				driver.findElement(By.xpath(
						"//a[contains(@aria-label,'Google Account')]/child::img")).click();
				Thread.sleep(5000);
				try
				{
					driver.findElement(By.linkText("Sign out")).click();
					Thread.sleep(5000);
				}
				catch(Exception ex)
				{
					driver.switchTo().frame("account"); 
					driver.findElement(By.xpath("//div[text()='Sign out']")).click();
					Thread.sleep(5000);
					driver.switchTo().defaultContent();
				}
				//Close Gmail site
				driver.close();
				//Back to Yahoo
				driver.switchTo().window(l.get(0));
				//Do logout in yahoo
				driver.findElement(By.xpath("(//img[@alt='Profile image'])[1]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[text()='Sign out']")).click();
				Thread.sleep(5000);
				//Close yahoo site
				driver.close();
	}

}
