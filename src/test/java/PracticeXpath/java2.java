package PracticeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java2 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.xpath("//input[@value='HTML']")); // radio button
		Thread.sleep(5000);
		if (e.isDisplayed()) {
			System.out.println("Element is visible in page");
			if (e.isEnabled()) {
				System.out.println("Element is enabled in page");
				// when element is radio-button / check-box / drop-down(not for all)
				e.click(); // select element
				Thread.sleep(5000);
				if (e.isSelected()) {
					System.out.println("Element is selected successfully in page");
				} else {
					System.out.println("Element is not selected in page");
				}
			} else {
				System.out.println("Element is disabled in page");
			}
		} else {
			System.out.println("Element is not visible in page");
		}
		// close site
		// driver.close();
	}

}
