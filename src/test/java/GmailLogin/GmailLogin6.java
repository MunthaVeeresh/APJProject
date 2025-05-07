package GmailLogin;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin6 {
	public static void main(String[] args) throws InterruptedException {
		// Open Chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		// close banner if exists
		try {
			driver.findElement(By.xpath("(//span[text()='Login'])[1]/preceding::button[1]")).click();
			Thread.sleep(5000);
		} catch (Exception ex) {
			System.out.println("No banner for this time");
		}
		// click on "mobiles" link
		driver.findElement(By.xpath("//img[@alt='Mobiles']/parent::div")).click();
		Thread.sleep(5000);
		//scroll-down 
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,600)");
		// click on "realme" for 1st product
		driver.findElement(By.xpath("(//div[@class='Ip5wZF'])[1]/div/div/a")).click();
		Thread.sleep(5000);
		// collect and display name and price of each model via pagination
		int total = 0;
		while (true) {
			// Step-1:collect all models in current page
			List<WebElement> models = driver.findElements(By.xpath("//div[starts-with(@data-id,'MOB')]"));
			// other xpath is
			// (//div[starts-with(@data-id,'MOBG')])|(//div[starts-with(@data-id,'MOBF')])
			total = total + models.size();
			// Step-2:goto each model to get name and price
			for (WebElement model : models) {
				String name = model.findElement(By.xpath("(child::div/a/div[2]/div/div)[1]")).getText();
				String price = model.findElement(By.xpath("child::div/a/div[2]/div[2]/div[1]/div[1]/div[1]")).getText();
				String discount = "";
				try {
					discount = model.findElement(By.xpath("child::div/a/div[2]/div[2]/div[1]/div[1]/div[3]/span"))
							.getText();
				} catch (Exception e) {
					discount = "0%";
				}
				System.out.println("Name:" + name + " & Price:" + price + " & Disc:" + discount);
			}
			// Step-3:goto next page if exists
			try {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {
				break; // terminate from loop
			}
		}
		System.out.println("Total models are " + total);
		// close
		driver.close();
	}

}
