package PracticeXpath;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class java8 {
	public static void main(String[] args) throws InterruptedException, IOException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// take screenshot of a hidden element
		WebElement e = driver.findElement(By.name("hiddenPassword"));
		File dest = new File("target\\hiddenelementpic.png");
		File src = e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		// generate blank screen shot as per width & height of element in page source.
		// close site
		driver.close();
	}

}
