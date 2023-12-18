package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// ExplicitWait:
		// concept of dynamic wait for the specific element/non webelement
		// on the basis of some expected conditions
		// wait(I) until(); <---- FluentWait (Class) until(){} + other methods <----
		// WebDriverWait(class)

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		By AboutUS = By.linkText("About Us");

		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * WebElement
		 * Email_ele=wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		 * Email_ele.sendKeys("test@gmail.com");
		 * 
		 * driver.findElement(pwd).sendKeys("test@123");
		 * driver.findElement(loginButton).click();
		 */
		waitForPresenceOfElement(AboutUS, 5).click();

	}

	public static WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public static List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}
	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public static List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public static void DoClickWithWait(By locator, int timeout) {
         waitForVisibilityOfElement(locator, timeout).click();
	}
	
	public static void DoSendKeysWithWait(By locator,String value,int timeout) {
		waitForVisibilityOfElement(locator, timeout).sendKeys(value);
	}
	
	

}
