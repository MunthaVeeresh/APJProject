package Cookies;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies8 {
	public static void main(String[] args) throws InterruptedException {
		// Open chrome browser(opens without any history and cookies by default)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		Thread.sleep(5000);
		// Launch site and do login
		driver1.get("https://www.gmail.com");
		driver1.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver1.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver1.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver1.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		// Collect all loaded cookies for chrome
		Set<Cookie> s = driver1.manage().getCookies();
		ArrayList<Cookie> l = new ArrayList<Cookie>(s);
		// take different browser
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver2 = new FirefoxDriver();
		driver2.manage().window().maximize();
		Thread.sleep(5000);
		// Launch gmail site
		driver2.get("http://www.gmail.com");
		Thread.sleep(5000);
		// Add cookies of chrome to firefox browser because both browsers are different
		for (Cookie c : l) {
			try {
				driver2.manage().addCookie(c);
			} catch (Exception ex) {
			}
		}
		driver2.navigate().refresh();
		Thread.sleep(5000);
		try {
			if (driver2.findElement(By.xpath("//*[text()='Compose']")).isDisplayed()) {
				System.out.print("Gmail Session cookie is working correctly");
			}
		} catch (NoSuchElementException ex) {
			if (driver2.getCurrentUrl().contains("https")) {
				System.out.println("HTTPS based sites cannot respond for shared cookies "
						+ "from one type of browser to another type due to different encryptions");
			} else // http only
			{
				System.out.print("Gmail Session cookie is not working correctly");
			}
		}
		// close site
		driver1.close();
		driver2.close();
	}

}
