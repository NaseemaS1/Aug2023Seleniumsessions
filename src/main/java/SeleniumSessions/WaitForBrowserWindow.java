package SeleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForBrowserWindow {

	static WebDriver driver;
	public static void main(String[] args) {

		 driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		By twitter=By.xpath("//a[contains(@href,'twitter')]");
		
		waitForVisibilityOfElement(twitter, 10).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		if(CheckNewWindowExist(10, 2)) {
			// fetch the window
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();

			String parentWimdowId = it.next();
			System.out.println("Parent Window ID:"+parentWimdowId);
			
			String ChildWindowId=it.next();
			System.out.println("Child Window Id"+ChildWindowId);
			
			//Switching work
			driver.switchTo().window(ChildWindowId);
			System.out.println("Child Window URL: "+driver.getCurrentUrl());
			driver.close();
			
			driver.switchTo().window(parentWimdowId);
			System.out.println("parent window URL"+driver.getCurrentUrl());
			driver.quit();
			
		}

	}
	
	public static boolean CheckNewWindowExist(int timeout,int ExpectedNoOfWindows) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(timeout))) {
			return true;
		}
		}
		catch(TimeoutException e) {
			System.out.println("windows are not same....");
		}
		return false;
	}
	

	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
