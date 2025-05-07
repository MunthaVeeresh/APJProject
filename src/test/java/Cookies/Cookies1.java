package Cookies;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies1 {
	public static void main(String[] args) throws InterruptedException {
		// Open browser(fresh browser will be opened without any history and cookies)
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(3000);
		// Display cookies
		Set<Cookie> s = driver.manage().getCookies();
		List<Cookie> l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + l.size());
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
		for (Cookie c : l) {
			try {
				System.out.println(c.getName() + " expires on " + sf.format(c.getExpiry()));
			} catch (Exception ex) {
				System.out.println(c.getName());
			}
		}
		// close site
		driver.close();
	}

}
