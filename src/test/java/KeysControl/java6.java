package KeysControl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java6 {
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
		// before right click
		String x1 = e.getCssValue("color");
		System.out.println(x1);
		String x2 = e.getCssValue("background-color");
		System.out.println(x2);
		// right click
		Actions act = new Actions(driver);
		act.contextClick(e).perform();
		Thread.sleep(5000);
		// after right click
		String y1 = e.getCssValue("color");
		System.out.println(y1);
		// background is coming as pseudo-element
		String y2 = (String) driver.executeScript("var ps=window.getComputedStyle(arguments[0],'::after');"
				+ "var s=ps.getPropertyValue('background-color');" + "return(s);", e);
		System.out.println(y2);
		// close site
		driver.close();
	}

}
