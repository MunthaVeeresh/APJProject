package KeysControl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java2 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site(operation)
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Locate element
		WebElement e = driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		// use getAttribute() to get HTML attribute value
		// 1.null will come when HTML attribute name spelling is wrong in our automation
		// code.
		// 2.null will come when no given HTML attribute in element source.
		// 3.null will come when no value to given HTML attribute in element source.
		// 4.if all are correct, value will come.
		// 5. no chance for any exception in getAttribute() method.
		String x = e.getAttribute("type"); // "type" is HTML attribute
		System.out.println(x);
		// use getCssValue() to get CSS attribute value
		// 1.blank will come when CSS attribute name spelling is wrong in our automation
		// code.
		// 2.blank will come when no given CSS attribute in element source.
		// 3.blank will come when no value to given CSS attribute in element source.
		// 4.if all are correct, value will come.
		// 5. no chance for any exception in getCssValue() method.
		// 6. In java language, null and blank(nothing) are same.
		String y = e.getCssValue("color"); // "color" is CSS property
		System.out.println(y);
		// close site
		//driver.close();
	}

}
