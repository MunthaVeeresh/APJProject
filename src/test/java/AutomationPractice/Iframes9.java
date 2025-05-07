package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes9 {
	public static void main(String[] args) throws Exception {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@value='John']")).clear();
		driver.findElement(By.id("fname")).sendKeys("Muntha");
		driver.findElement(By.id("lname")).clear();
		driver.findElement(By.id("lname")).sendKeys("Veeresh");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.switchTo().defaultContent();
	}

}
