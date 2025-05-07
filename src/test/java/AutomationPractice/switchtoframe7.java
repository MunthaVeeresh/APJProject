package AutomationPractice;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchtoframe7 {
	public static void main(String[] args) throws Exception {
		// Download Latest Chrome Driver Softwrae
		WebDriverManager.chromedriver().setup();
		// Open Chrome Browser Using That Chrome Driver Software
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("myfile"))
				.sendKeys("C:\\Users\\Muntha Veeresh\\Downloads//MicrosoftTeams-image (5).png");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

}
