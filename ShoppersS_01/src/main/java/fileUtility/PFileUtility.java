package fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PFileUtility {
	public String getFileData(String key) throws Exception, FileNotFoundException {
		FileInputStream fis=new FileInputStream("./testData/configurationData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
}
