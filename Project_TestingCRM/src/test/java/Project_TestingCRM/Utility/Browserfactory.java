package Project_TestingCRM.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {

	public static WebDriver startApplication(WebDriver driver, String browser, String appURL) {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");

			driver = new FirefoxDriver();

		}

		else {

			System.out.println("we do not support this type of browser");

		}

		String currentBrowser = browser;
		
		System.out.println(currentBrowser);
		
		Helper.getCurrentBrowserInstance(currentBrowser);
		
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get(appURL);
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		
		

		driver.quit();

	}

}
