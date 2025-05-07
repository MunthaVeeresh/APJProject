package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames10 {
	public static void main(String[] args) throws Exception{
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames");
		Thread.sleep(5000);
		driver.switchTo().frame("iamframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("MUntha Veeresh");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("animals")).click();
		Actions as = new Actions(driver);
		driver.switchTo().defaultContent();
	}

}
