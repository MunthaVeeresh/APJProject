package AutomationPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlewithMultipleframes11 {
	public static void main(String[] args) throws Exception {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site using base URL
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// click on a link
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.partialLinkText("Visit W3Schools")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// Goto 2nd tab/window
		Set<String> s = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(5000);
		driver.close(); // 2nd window/tab is only closing
		Thread.sleep(5000);
		// Back to 1st browser window/tab
		driver.switchTo().window(l.get(0));
		driver.findElement(By.partialLinkText("Get your")).click();
		Thread.sleep(5000);
		// recollect window handles due to new tab/window
		s = driver.getWindowHandles();
		l = new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		driver.close(); // 2nd window/tab is only closing
		Thread.sleep(5000);
		// Back to 1st browser window/tab
		driver.switchTo().window(l.get(0));
		driver.close();

	}

}
