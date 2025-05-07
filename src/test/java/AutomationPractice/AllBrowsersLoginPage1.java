package AutomationPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllBrowsersLoginPage1 {
	public static void main(String[] args) {
		// This Is Chrome Browser
		// Download Latest Chrome Driver Software
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using that Chrome driver Softwrae
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		// This is Firefox browser
		// Download Latest gecko Driver Software
		WebDriverManager.firefoxdriver().setup();
		// Open firefox Browser Using that firefox driver Softwrae
		RemoteWebDriver driver1 = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		// THis Is Internet Explorer
		// Download Latest ie Driver Software
		WebDriverManager.iedriver().setup();
		// Open ie Browser Using that ie driver Softwrae
		RemoteWebDriver driver2 = new InternetExplorerDriver();
		// This Is Edge Browser
		// Download Latest ie Driver Software
		WebDriverManager.edgedriver().setup();
		// Open edge Browser Using that edge driver Softwrae
		RemoteWebDriver driver3 = new EdgeDriver();
		// This is Opera Browser
		// Download Latest ie Driver Software
		WebDriverManager.operadriver().setup();
		// Open opera Browser Using that edge driver Softwrae
		// OperaDriver driver4 = new OperaDriver();

	}

}
