package KeysControl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java10 {
	public static void main(String[] args) throws InterruptedException {
		//open browser
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				//Launch site 
				driver.get("https://www.google.co.in");
				driver.manage().window().maximize();
				Thread.sleep(5000);
				WebElement e=driver.findElement(By.name("q")); //text box
				//Test case-1
				if(e.isDisplayed())
				{
					System.out.println("Element is visible in page");
				}
				else
				{
					System.out.println("Element is not visible in page");
				}
				//close site
				driver.close();
	}

}
