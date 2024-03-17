package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadWrite {
	
	public static String readProperty(String filepath, String key) throws IOException {
		Properties prop = new Properties();
		FileReader reader = new FileReader(filepath);
		prop.load(reader);
		String value = prop.getProperty(key);
		return value;
		
	}

}
