package GmailLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmaillogin3 {
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
		Thread.sleep(5000);
		// delete mails received on August,2022
		int dmc = 0;
		while (true) // infinite loop for pagination
		{
			// step-1: collect all mails(rows) in current page's table
			List<WebElement> mails = driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
			// step-2: goto each mail to check whether is it received on August,2022
			for (int i = 0; i < mails.size(); i++) {
				WebElement e = mails.get(i).findElement(By.xpath("child::td[8]/span"));
				String msg = e.getAttribute("title");
				if (msg.contains("Aug") && msg.contains("2022")) {
					dmc++;
					// 1. select corresponding check-box
					mails.get(i).findElement(By.xpath("child::td[2]/div[@role='checkbox']")).click();
					Thread.sleep(3000);
					// 2. click on delete icon
					mails.get(i).findElement(By.xpath("child::td[9]/ul/li[2]")).click();
					Thread.sleep(3000);
					// 3. close banner related to delete operation
					driver.findElement(By.xpath("//div[@role='alert']/descendant::div[@role='button']")).click();
					Thread.sleep(3000);
					// 4. to cover next mail, which replaces deleted mail
					i--;
					// 5. recollect rows/mails to avoid "StaleElementReferenceException"
					mails = driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
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
		System.out.println("deleted mails recieved in August 2022 count is " + dmc);
		// do logout

		// Close site
		driver.close();
	}

}
