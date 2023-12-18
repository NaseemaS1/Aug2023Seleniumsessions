package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWithTitleUrl {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By About_US = By.linkText("About Us");
		driver.findElement(About_US).click();

		String title=waitFortitleContains("About", 5);
		System.out.println(title);
	}
	
	
	
	public static String waitFortitleContains(String titleFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(titleFraction + "title value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	

	
	public static String waitFortitleIs(String titleFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.titleIs(titleFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(titleFraction + "title value is not present....");
        	e.printStackTrace();
        }

		return null;
	}

	
	public static String waitForURLContains(String urlFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(urlFraction + "url value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	


	
	public static String waitForURLToBe(String urlFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(urlFraction + "url value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	


	

	
	
	
	

}
