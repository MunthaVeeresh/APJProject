package AutomationPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetPageSource3 {
	public static void main(String[] args) {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.sentia.in");
		String x = driver.getPageSource();
		System.out.println(x);
		driver.close();
	}

}
