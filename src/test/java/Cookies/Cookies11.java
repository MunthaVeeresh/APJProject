package Cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies11 {
	public static void main(String[] args) {
		// Open browser(opens without history and cookies)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.gmail.com");
		// Add our own cookie
		Cookie cc = new Cookie("magntia", "abdulkalam");
		driver.manage().addCookie(cc);
		// Collect all loaded cookies along with added cookie
		Set<Cookie> s = driver.manage().getCookies();
		List<Cookie> l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + s.size());
		for (Cookie c : l) {
			System.out.println(c.getName() + "----" + c.getValue() + "----" + c.getDomain());
		}
		// Get specific cookie using cookie's name
		Cookie c = driver.manage().getCookieNamed("NID");
		System.out.println(c.getName() + "----" + c.getValue() + "----" + c.getDomain());
		// Delete specific cookie(ex:- 2nd cookie) using Cookie class's object
		driver.manage().deleteCookie(l.get(1));
		// Delete specific cookie(ex:- 1st cookie) using name
		driver.manage().deleteCookieNamed(l.get(0).getName());
		// delete all cookies
		driver.manage().deleteAllCookies();
		// Close site
		driver.close();
	}

}
