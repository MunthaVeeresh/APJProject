package AutomationPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Gmailallmethods7 {
	public static void main(String[] args) throws InterruptedException, AWTException {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		// Minimize browser
		driver.manage().window().minimize();
		Thread.sleep(5000);
		// Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// get current size
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w + " " + h);
		// Resize browser
		Dimension d = new Dimension(800, 300); // width and height
		// driver.manage().window().setSize(d);
		Thread.sleep(5000);
		// get current position
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println(x + " " + y);
		// Relocate browser on Desktop
		Point p = new Point(200, 200); // xAnd y coordinates
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		// get full screen
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		// Back to normal
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
	}

}
