package GmailLogin;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailogin5 {
	public static void main(String[] args) throws InterruptedException {
		// Take a word to search
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word to search");
		String x = sc.nextLine();
		sc.close();
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Search the word
		driver.findElement(By.name("q")).sendKeys(x, Keys.ENTER);
		Thread.sleep(5000);
		// pagination
		int count = 0;
		int pn = 2;
		while (true) {
			// step-1: collect results in current page
			List<WebElement> reslist = driver.findElements(By.xpath("//div[starts-with(@class,'g ')]"));
			// Step-2: count results
			count = count + reslist.size();
			// Step-3: goto next page via page number
			try {
				driver.findElement(By.linkText("" + pn)).click();
				Thread.sleep(3000);
				pn++;
			} catch (Exception ex) // if no Next link(means we are in last page)
			{
				break; // to terminate from loop
			}
		}
		System.out.println("Results count is " + count);
		// close site
		driver.close();
	}

}
