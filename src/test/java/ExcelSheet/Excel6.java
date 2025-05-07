package ExcelSheet;

import java.util.Properties;
import java.util.Set;

public class Excel6 {
	public static void main(String[] args) {
		// Get in-built properties related to our System
		Properties p = System.getProperties(); // key and value pairs
		Set<Object> keys = p.keySet(); // get all keys
		for (Object key : keys) // get values using keys
		{
			System.out.println(key.toString() + "=" + p.getProperty(key.toString()));
		}
	}

}
