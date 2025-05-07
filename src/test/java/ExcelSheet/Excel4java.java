package ExcelSheet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Excel4java {
	public static void main(String[] args) throws IOException {
		// Open existing file in read mode
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Saved Pictures\\Book1.xlsx");
		FileReader fr = new FileReader(f);
		// Load file into RAM as a properties file
		Properties p = new Properties();
		p.load(fr);
		System.out.println("Count of properties in file is " + p.keySet().size());
		// Get properties values from that file
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("email"));
	}

}
