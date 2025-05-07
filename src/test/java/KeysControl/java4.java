package KeysControl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java4 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site(operation)
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Locate element
		WebElement e = driver.findElement(By.xpath("//div[@jsname='RNNXgb']"));
		// get details before focus
		String x = e.getCssValue("box-shadow"); // no shadow
		System.out.println(x);
		// get focus
		Actions act = new Actions(driver);
		act.moveToElement(e).perform();
		Thread.sleep(5000);
		// get details after focus
		String y = e.getCssValue("box-shadow"); // shadow exists
		System.out.println(y);
		// close site
		//driver.close();
	}

}
