package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChildTables2 {
	public static void main(String[] args) throws InterruptedException {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get(
				"https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/points-table-standings");
		Thread.sleep(5000);
		// collect all tables in page source
		List<WebElement> tables = driver.findElements(By.xpath("//table/tbody"));
		System.out.println(tables.size());
		// collect rows in each table
		for (WebElement table : tables) {
			List<WebElement> rows = table.findElements(By.xpath("child::tr"));
			System.out.println(rows.size());
			// collect all cols in each row
			for (WebElement row : rows) {
				List<WebElement> cols = row.findElements(By.xpath("child::td"));
				System.out.println(cols.size());
			}
		}
		// close site
		driver.close();
	}

}
