package AutomationPractice;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrassingBrowsingTesting {
	public static void main(String[] args) throws Exception{
		// get data from KeyBoard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String x = sc.nextLine();
		// Declare Global Object to parent class
		RemoteWebDriver driver = null;
		if (x.equals("Chrome")) {
			// Download Latest Chrome Driver Software
			WebDriverManager.chromedriver().setup();
			// Open Chrome Browser Using thst Chrome Driver
			driver = new ChromeDriver();
		} else if (x.equals("Firefox")) {
			// Download Latest firefox Driver Software
			WebDriverManager.firefoxdriver().setup();
			// Open Firefox Browser Using thst Firefox Driver
			driver = new FirefoxDriver();
//		} else if (x.equals("Opera")) {
//			// Download Latest Opera Driver Software
//			WebDriverManager.operadriver().setup();
//			// Open Opera Browser Using thst Opera Driver
//			driver = new OperaDriver();
		} else if (x.equals("IE")) {
			// Download Latest ie Driver Software
			WebDriverManager.iedriver().setup();
			// Open InternetExplorer Browser Using thst InternetExplorer Driver
			driver = new InternetExplorerDriver();
		} else if (x.equals("Edge")) {
			// Download Latest Edge Driver Software
			WebDriverManager.edgedriver().setup();
			// Open Edge Browser Using thst Edge Driver
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter Wrong Browser Name");
			System.exit(0);
		}
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();
	}

}
