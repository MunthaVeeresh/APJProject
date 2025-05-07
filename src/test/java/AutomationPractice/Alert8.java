package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert8 {
	public static void main(String[] args) throws Exception {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
		Thread.sleep(5000);
		driver.switchTo().frame("iframewrapper");
		driver.findElement(By.xpath("//input[@value='Click me']")).click();

		Thread.sleep(5000);
		String x = driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();

	}

}
