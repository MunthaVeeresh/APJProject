package Brokenlinkscorrectlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class links3 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
//		driver.get("http://www.gmail.com");
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
//		// Challenge-1: element found in Page source but not present on page.
//		// So, we get "ElementNotInteractableException" when we click on hidden element.
//		driver.findElement(By.xpath("//input[@type='password']")).click();
//		
				//Launch site 
//				driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
//				Thread.sleep(5000); 
				//Challenge-2: element found in page source and present on page but disabled.
				//So, no reaction and no exception
//				driver.switchTo().frame("iframeResult");
//				driver.findElement(By.name("lname")).click();
		//driver.get("https://www.facebook.com");
				//driver.findElement(By.name("email")).sendKeys("abdul",Keys.TAB,"kalam",Keys.TAB,Keys.ENTER);
				//fill fields
//				driver.findElement(By.name("email")).sendKeys("abdul",
//													Keys.chord(Keys.CONTROL,"a"),
//													Keys.chord(Keys.CONTROL,"c"));
//				Thread.sleep(5000); 
//				driver.findElement(By.name("pass")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				
				//Launch site 
				driver.get("http://www.gmail.com");
				Thread.sleep(5000); 
				//Challenge-1: element found in Page source but not present on page.
				//So, we get "ElementNotInteractableException" when we fill that hidden element.
				driver.findElement(By.name("identifier")).sendKeys("abdulkalam");
	}

}
