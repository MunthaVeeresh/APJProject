package ExcelSheet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Excel5 {
	public static void main(String[] args) throws IOException, ConfigurationException {
		// Open an existing file, read values, edit values and save that file
		File f = new File("C:\\Users\\Muntha Veeresh\\Documents\\Zoom\\Excelfile.xlsx)");
		// Edit values
		PropertiesConfiguration pc = new PropertiesConfiguration(f);
		pc.setProperty("name", "Mr. abdul kalam sir");
		pc.setProperty("url", "http://www.apjabdulkalam.com");
		pc.setProperty("age", "94");
		pc.save();
		// Read values
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		Set<Object> keys = p.keySet(); // get all keys
		for (Object key : keys) // get values using keys
		{
			System.out.println(key.toString() + "=" + p.getProperty(key.toString()));
		}
	}

}
