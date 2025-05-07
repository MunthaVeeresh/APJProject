package Flipkart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slidesebay2 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("http://www.ebay.com");
		Thread.sleep(5000);
		// Locate carousel slider element
		WebElement cslider = driver.findElement(By.xpath("(//ul[@class='carousel__list'])[1]"));
		// Test case-1: get count of slides in that carousel slider
		int count = 0;
		if (cslider.getTagName().equalsIgnoreCase("ul") || cslider.getTagName().equalsIgnoreCase("ol")) {
			count = cslider.findElements(By.xpath("child::li")).size();
		} else if (cslider.getTagName().equalsIgnoreCase("div")) {
			List<WebElement> temp1 = cslider.findElements(By.xpath("child::div"));
			List<WebElement> temp2 = new ArrayList<WebElement>(); // new list
			// filter cloned slides
			for (WebElement e : temp1) {
				try {
					if (!e.getAttribute("class").contains("clone")) {
						if (e.getAttribute("data-clone").equals("false")) {
							temp2.add(e); // data-clone is false to an element
						}
					}
				} catch (Exception ex) {
					temp2.add(e); // no data-clone attribute to an element, means visible
				}
			}
			count = temp2.size();
		} else {
			System.out.println("Unknown tag used by dev team for carousel slider");
			System.exit(0); // stop execution forcibly
		}
		System.out.println(count);
		// Test case-2: is it 2D or 3D?
		// "transform" and "transform-style" are CSS properties
		String value = cslider.getCssValue("transform");
		if (value.equals("none")) {
			// take transform-style property value
			value = cslider.getCssValue("transform-style");
		}
		System.out.println(value);
		// verification
		if (value.contains("3d")) {
			System.out.println("3D slider");
		} else {
			System.out.println("2D slider");
		}
		// test case-3: direction of slides movement
		String value2 = cslider.getCssValue("transform");
		if (value2.equals("none")) {
			// take transform-style property value
			value2 = cslider.getCssValue("transform-style");
		}
		System.out.println(value2);
		String[] p = value2.split(","); // comma(,) is separator
		p[4] = p[4].trim(); // remove unwanted spaces
		p[5] = p[5].trim(); // remove unwanted spaces
		p[5] = p[5].replace(")", ""); // remove ")" symbol
		float tx = Float.parseFloat(p[4]);
		float ty = Float.parseFloat(p[5]);
		if (tx < 0 && ty == 0) {
			System.out.println("Slides are moving from Right to left");
		} else if (tx > 0 && ty == 0) {
			System.out.println("Slides are moving from Left to Right");
		} else if (tx == 0 && ty < 0) {
			System.out.println("Slides are moving from Bottom to top");
		} else if (tx == 0 && ty > 0) {
			System.out.println("Slides are moving from Top to bottom");
		} else // tx and ty both are zero
		{
			System.out.println("Not moving");
		}
		// test case-4: style of slides movement
		String value3 = cslider.getCssValue("transition");
		System.out.println(value3);
		String[] y = value3.split(" "); // space is the separator
		y[3] = y[3].replace(",", ""); // replace "," with blank
		System.out.println("Duration of each slide movement is " + y[1]);
		System.out.println("Style of each slide movement is " + y[2]);
		System.out.println("Delay between slides movement is " + y[3]);
		// close site
		driver.close();
	}

}
