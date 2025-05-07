package GmailLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmaillogin1 {
	public static void main(String[] args) throws InterruptedException {
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Do login
		driver.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(10000);
		// get count of unread mails, read mails and all mails
		int amc = 0;
		int rmc = 0;
		int urmc = 0;
		while (true) // infinite loop for pagination
		{
			// step-1: collect all mails(rows) in current page's table
			List<WebElement> mails = driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
			amc = amc + mails.size();
			// step-2: goto each mail to check read/unread
			for (WebElement mail : mails) {
				WebElement e = mail.findElement(By.xpath("child::td[4]/div[1]"));
				String msg = (String) driver.executeScript("return(arguments[0].textContent);", e);
				if (msg.startsWith("unread")) {
					urmc++;
				} else {
					rmc++;
				}
			}
			// step-3: goto next page
			try {
				String temp = driver.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled");
				if (temp.equals("true")) // in last page
				{
					break; // terminate from loop
				}
			} catch (Exception ex) // not in last page
			{
				// goto next page
				driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
				Thread.sleep(5000);
			}
		}
		System.out.println("All mails count is " + amc);
		System.out.println("Unread mails count is " + urmc);
		System.out.println("Read mails count is " + rmc);
		// do logout

		// Close site
		driver.close();
	}

}
