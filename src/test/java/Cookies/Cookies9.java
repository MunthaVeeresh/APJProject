package Cookies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies9 {
	public static void main(String[] args) {
		// Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); // browser opens without history and cookies
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.gmail.com");
		// Add cookie(way-1)
		Cookie cc = new Cookie("magntia", "abdulkalam");
		driver.manage().addCookie(cc);
		// Collect all loaded cookies along with added cookie
		Set<Cookie> s = driver.manage().getCookies();
		List<Cookie> l = new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is " + s.size());
		for (Cookie c : l) {
			System.out.println(c.getName() + "----" + c.getValue() + "----" + c.getDomain());
		}
		// Close site
		driver.close();
	}

}
