package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputTagsinifelses4 {
	public static void main(String[] args) throws InterruptedException {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		// Collect <input> tag elements
		List<WebElement> l = driver.findElements(By.tagName("input"));
		System.out.println("Count of input tag elemens is " + l.size());
		// Segregate <input> tag elements
		int ctb = 0;
		int crb = 0;
		int ccb = 0;
		int ceb = 0;
		int cpb = 0;
		int cu = 0;
		int ct = 0;
		int csb = 0;
		int ch = 0;
		int others = 0;
		for (int i = 0; i < l.size(); i++) {
			String x = l.get(i).getAttribute("type");
			if (x.equals("text")) {
				ctb++;
			} else if (x.equals("radio")) {
				crb++;
			} else if (x.equals("password")) {
				cpb++;
			} else if (x.equals("checkbox")) {
				ccb++;
			} else if (x.equals("email")) {
				ceb++;
			} else if (x.equals("tel")) {
				ct++;
			} else if (x.equals("url")) {
				cu++;
			} else if (x.equals("submit")) {
				csb++;
			} else if (x.equals("hidden")) {
				ch++;
			} else {
				others++;
				System.out.println(x);
			}
		}
		System.out.println("count of text boxes " + ctb);
		System.out.println("count of password boxes " + cpb);
		System.out.println("count of check boxes " + ccb);
		System.out.println("count of radio buttons " + crb);
		System.out.println("count of email boxes " + ceb);
		System.out.println("count of url elements " + cu);
		System.out.println("count of telephone elements " + ct);
		System.out.println("count of submit buttons " + csb);
		System.out.println("count of hidden elements " + ch);
		System.out.println("count of others " + others);
		// close site
		driver.close();
	}

}
