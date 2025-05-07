package ExcelSheet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Excel3 {
	public static void main(String[] args) throws IOException {
		// Create object to "Properties" class
		Properties p = new Properties();
		// define Key-value pairs
		p.setProperty("name", "abdul kalam");
		p.setProperty("email", "apj@abdulkalam.com");
		// Save a new properties file with those pairs
		File f = new File("C:\\Users\\Muntha Veeresh\\Pictures\\Saved Pictures\\Book1.xlsx");
		FileWriter fw = new FileWriter(f); // WRITE mode
		p.store(fw, "My results Properties file");
	}

}
