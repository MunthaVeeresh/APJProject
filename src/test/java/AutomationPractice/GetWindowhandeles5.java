package AutomationPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWindowhandeles5 {
	public static void main(String[] args) throws Exception {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tag_input.asp");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@title='W3Schools Certificates'])[1]")).click();
		Thread.sleep(5000);
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> l = new ArrayList<String>(s);
		// switch to 2nd window/tab
		driver.switchTo().window(l.get(1));
		driver.close();
		// switch to back to 1st window/tab
		driver.switchTo().window(l.get(0));
		driver.findElement(By.xpath("(//a[@title='W3Schools Certificates'])[1]")).click();
		Thread.sleep(5000);
		// closed all window/tabs
		driver.quit();

	}

}
