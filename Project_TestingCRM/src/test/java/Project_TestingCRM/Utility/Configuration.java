package Project_TestingCRM.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

	Properties prop;

	public Configuration() {

		File fis = new File("./Configuration/Configure.properties");

		try {
			
			FileInputStream src = new FileInputStream(fis);

			prop = new Properties();

			prop.load(src);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getDataConfig(String KeyToSearch) {
		
		
		return KeyToSearch;
		
	}

	public String getBrowser() {

		return prop.getProperty("Browser");

	}

	public String getBrowserUrl() {

		return prop.getProperty("QAEnvironmentURL");

	}

}
