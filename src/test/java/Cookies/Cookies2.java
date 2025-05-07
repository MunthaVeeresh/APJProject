package Cookies;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies2 {
	public static void main(String[] args) throws InterruptedException {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		// Display cookies
		System.out.println("Cookies after launching");
		System.out.println("------------------------");
		Set<Cookie> s = driver.manage().getCookies();
		List<Cookie> l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + l.size());
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
		for (Cookie c : l) {
			System.out.println(c.getName() + " expires on " + sf.format(c.getExpiry()));
		}
		// do login
		driver.findElement(By.name("identifier")).sendKeys("choomu15@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("choomu@123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		// Display cookies
		System.out.println("Cookies after login");
		System.out.println("-------------------");
		s = driver.manage().getCookies();
		l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + l.size());
		for (Cookie c : l) {
			System.out.println(c.getName() + " expires on " + sf.format(c.getExpiry()));
		}
		// Do logout
		driver.findElement(By.xpath("//a[starts-with(@aria-label,'Google Account')]")).click();
		try {
			driver.switchTo().frame("account");
			Thread.sleep(5000);// needed even if we have implicit wait also
			driver.findElement(By.xpath("//div[text()='Sign out']")).click();
			driver.switchTo().defaultContent(); // back to page
		} catch (Exception ex) {
			driver.findElement(By.linkText("Sign out")).click();
		}
		// Display cookies
		System.out.println("Cookies after logout");
		System.out.println("-------------------");
		s = driver.manage().getCookies();
		l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + l.size());
		for (Cookie c : l) {
			System.out.println(c.getName() + " expires on " + sf.format(c.getExpiry()));
		}
		// close site
		driver.close();
	}

}
