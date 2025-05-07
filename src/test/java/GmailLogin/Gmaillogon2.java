package GmailLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmaillogon2 {
	public static void main(String[] args) throws InterruptedException {
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// Do login
		driver.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(10000);
		// get count of mails received on march,2022
		int mc = 0;
		while (true) // infinite loop for pagination
		{
			// step-1: collect all mails(rows) in current page's table
			List<WebElement> mails = driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
			// step-2: goto each mail to check whether is it received on march,2022
			for (WebElement mail : mails) {
				WebElement e = mail.findElement(By.xpath("child::td[8]/span"));
				String msg = e.getAttribute("title");
				if (msg.contains("Mar") && msg.contains("2024")) {
					mc++;
				}
			}
			// step-3: goto next page
			try {
				String temp = driver.findElement(By.xpath("//div[@aria-label='Older']")).getAttribute("aria-disabled");
				// If in last page, value is true
				// If not in last page, value is NULL so there is "NullPointerException"
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
		System.out.println("mails recieved in March 2024 count is " + mc);
		// do logout

		// Close site
		//driver.close();
	}
}
