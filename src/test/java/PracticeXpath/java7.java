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

public class java7 {
	public static void main(String[] args) throws IOException, InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site and locate an hidden element
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// Locate an element, which is visible in page
		WebElement e = driver.findElement(By.name("identifier"));
		e.sendKeys("abdulkalam");
		// get screenshot of that element(Way-1)
		File src = e.getScreenshotAs(OutputType.FILE);
		File dest = new File("target//myelement.png");
		FileHandler.copy(src, dest);
		// Way-2: as Base64 string
		String src2 = e.getScreenshotAs(OutputType.BASE64);
		System.out.println(src2);
		// Way-3: as bytes
		byte src3[] = e.getScreenshotAs(OutputType.BYTES);
		// use src3 array in cucumber reports
		// Close site
		driver.close();
	}

}
