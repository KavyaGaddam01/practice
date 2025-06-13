package fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/LoginData.properties/");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);

		return value;
	}

}
