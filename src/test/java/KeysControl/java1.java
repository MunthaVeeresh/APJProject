package KeysControl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java1 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// element covered by other element like banner
		// but sendKeys() is working successfully
		driver.findElement(By.name("q")).sendKeys("mobiles", Keys.ESCAPE);
		Thread.sleep(5000);
		// clear that value using clear() method
		// It will work successfully. Otherwise we go to keyboard keys automation
		driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, Keys.ESCAPE);
		Thread.sleep(5000);
	}

}
