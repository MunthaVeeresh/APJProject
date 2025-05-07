package Cookies;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Cookies10 {
	public static void main(String[] args) throws InterruptedException {
		//open browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver(); //browser opens without any history and cookies
				//Launch site
				driver.get("http://www.youtube.com");
				driver.manage().window().maximize();
				Thread.sleep(5000);
				//Create any type of cookie(7 types) using "Cookie.Builder" class(way-2)
			    Date today=new Date();
			    Date tomorrow=new Date(today.getTime()+(24*60*60*1000));
			    Cookie.Builder b=new Cookie.Builder("session-id-time","magnitia"); //Name & value
			    Cookie nc=
			    	b.domain("www.youtube.com").path("/").expiresOn(tomorrow).isSecure(true).build();
				driver.manage().addCookie(nc);
				Thread.sleep(5000); //waiting
				//Collect all cookies after waiting
				Set<Cookie> s=driver.manage().getCookies();
				System.out.println("Count of cookies is "+s.size());
				for(Cookie c:s)
				{
					System.out.println(c.getName()+"<-->"+c.getValue()+"<-->"+c.getDomain()
					                                                        +"<-->"+c.getExpiry());
				}
				//Close site
				driver.close();
	}

	
}
