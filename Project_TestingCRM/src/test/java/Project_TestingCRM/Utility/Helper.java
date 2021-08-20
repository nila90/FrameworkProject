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

	public static void takingScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(src, new File("./Screenshots/Free_CRM_"+takeScreenshotCurrentTimeStamp()+".png"));
		} catch (Exception e) {

			System.out.println("Unable to take screenshot"+e.getMessage());
			
		}

	}

	
	   public static String takeScreenshotCurrentTimeStamp() {
		
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		return timestamp;
		
	}
	   
	/*   public static void checkWebElementClickable(WebDriver driver, String path) {
		   
		   System.out.println("Method Calling");

		   
		   WebDriverWait w = new WebDriverWait(driver, 1000);
		   WebElement element = w.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		   element.click();
		   
	   }*/
	   
	   public static void CheckElementNotCliakable(WebDriver driver, String path) {
		   
		   WebElement element = driver.findElement(By.xpath(path));

		   Actions actions = new Actions(driver);

		   actions.moveToElement(element).click().perform();
		   
		   try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   
	   
	   
	
}
