package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel3 {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// Open Chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=htmlform1");
		Thread.sleep(5000);
		// Access Excel file for reading and writing
		File f = new File("C:\\Users\\Muntha Veeresh\\Documents\\manual & Automation_Resume\\Book1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fi); // get workbook
		Sheet sh = wb.getSheetAt(0); // get 1st sheet from workbook
		int RowNum = sh.getPhysicalNumberOfRows(); // count of Rows
		int ColNum = sh.getRow(0).getLastCellNum(); // get last ColNum
		// Create Result column
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt = new Date();
		sh.getRow(0).createCell(ColNum).setCellValue("Result on " + sf.format(dt));
		for (int i = 1; i < RowNum; i++) // Loop works from 2nd row bcz 1st row has headings
		{
			// Take test data from row
			DataFormatter df = new DataFormatter();
			String a = df.formatCellValue(sh.getRow(i).getCell(0));
			String b = df.formatCellValue(sh.getRow(i).getCell(1));
			String c = df.formatCellValue(sh.getRow(i).getCell(2));
			String d = df.formatCellValue(sh.getRow(i).getCell(3));
			String e = df.formatCellValue(sh.getRow(i).getCell(4));
			// fill fields in page
			driver.switchTo().frame("iframewrapper");
			driver.findElement(By.id("register_name")).sendKeys(a);
			driver.findElement(By.id("register_password")).sendKeys(b);
			driver.findElement(By.id("register_email")).sendKeys(c);
			if (d.equalsIgnoreCase("male")) {
				driver.findElement(By.id("register_gendermale")).click();
			} else {
				driver.findElement(By.id("register_genderfemale")).click();
			}
			WebElement ele = driver.findElement(By.id("register_country"));
			Select s = new Select(ele);
			if (e.equalsIgnoreCase("india")) {
				s.selectByIndex(0);
			} else if (e.equalsIgnoreCase("pakistan")) {
				s.selectByIndex(1);
			} else if (e.equalsIgnoreCase("africa")) {
				s.selectByIndex(2);
			} else if (e.equalsIgnoreCase("china")) {
				s.selectByIndex(3);
			} else {
				s.selectByIndex(4);
			}
			Thread.sleep(5000);
			// submit data
			driver.findElement(By.id("register_0")).click();
			Thread.sleep(5000);
			// get output message and write into last column as test result
			String o = driver.findElement(By.tagName("h1")).getText();
			sh.getRow(i).createCell(ColNum).setCellValue(o);
			sh.autoSizeColumn(ColNum); // auto-fit
			// Back to page and refresh
			driver.switchTo().defaultContent();
			driver.navigate().refresh(); // for next iteration
			Thread.sleep(5000);
		}
		// Save excel file
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
		// close site
		driver.close();
		// zip the excel file

		// email to manager
	}

}
