package AutomationPractice2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLoginpage1 {
	public static void main(String[] args) throws Exception {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("munthaveeresh2000@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("This is Mail Sending");
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Heli/muntha veeresh/how are you/");
		driver.findElement(By.xpath("//input[@name='Filedata']"))
				.sendKeys("C:\\Users\\Muntha Veeresh\\Downloads//WhatsApp Image 2024-03-07 at 7.16.25 PM.jpeg");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Send']/parent::div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@role='button'])[4]/parent::div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Sign out']")).click();
	}

}
