package Project_TestingCRM.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	static String cb;

	public static void takingScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(src, new File("./Screenshots/Free_CRM_" + takeScreenshotCurrentTimeStamp() + ".png"));
		} catch (Exception e) {

			System.out.println("Unable to take screenshot" + e.getMessage());

		}

	}

	public static String takeScreenshotCurrentTimeStamp() {

		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		return timestamp;

	}

	/*
	 * public static void checkWebElementClickable(WebDriver driver, String path) {
	 * 
	 * System.out.println("Method Calling");
	 * 
	 * 
	 * WebDriverWait w = new WebDriverWait(driver, 1000); WebElement element =
	 * w.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	 * element.click();
	 * 
	 * }
	 */

	public static void CheckElementNotCliakable(WebDriver driver, String path) {

		WebElement element = driver.findElement(By.xpath(path));

		System.out.println(path);

		if (cb.equalsIgnoreCase("Firefox")) {

			System.out.println("Firefox Checking");

			Actions actions = new Actions(driver);

			actions.moveToElement(element).click().build().perform();

		} else if (cb.equalsIgnoreCase("Chrome")) {

			System.out.println("Chrome Checking");

			element.click();
		}

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Method Calling");

	}

	public static String getCurrentBrowserInstance(String checkbrowserinstance) {

		cb = checkbrowserinstance;

		System.out.println("Check the browser instance : " + cb);

		return cb;

	}

}
