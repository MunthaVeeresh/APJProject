package Cookies;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies5 {
	public static void main(String[] args) throws InterruptedException {
		// Open chrome browser(opens without history and cookies by default)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Launch site and do login
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		// do login
		driver.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		// take new window/tab in chrome and switch to that new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh = driver.getWindowHandles();
		List<String> lwh = new ArrayList<String>(swh);
		driver.switchTo().window(lwh.get(1));
		// Launch same site by skipping login due to session cookie
		driver.get("http://www.testyou.in/Login.aspx");
		Thread.sleep(5000);
		try {
			if (driver.findElement(By.className("signout")).isDisplayed()) {
				System.out.print("Session cookie is working correctly");
			}
		} catch (Exception ex) {
			System.out.print("Session cookie is not working correctly");
		}
		// close all browser windows/tabs
		// driver.quit();
	}

}
