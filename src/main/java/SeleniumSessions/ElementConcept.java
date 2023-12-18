package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);

		// DOM:document object model:HTML code
		// 1st:
		// driver.findElement(By.id("input-email")).sendKeys("Test@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("Test@1234");

		// 2nd:
		// WebElement emailId=driver.findElement(By.id("input-email"));
		// WebElement password=driver.findElement(By.id("input-password"));
		// emailId.sendKeys("test@gmail.com");
		// password.sendKeys("Test@1234");

		// 3rd:by locator
		/*
		 * By eId=By.id("input-email"); By pwd=By.id("input-password");
		 * 
		 * WebElement emailId=driver.findElement(eId); WebElement
		 * password=driver.findElement(pwd);
		 * 
		 * emailId.sendKeys("Test@gmail.com"); password.sendKeys("Test@1234");
		 * 
		 */
		// 4th:by locator+generic methods for element
		// By eId=By.id("input-email");
		// By pwd=By.id("input-password");

		// getElement(eId).sendKeys("Test@gmail.com");
		// getElement(pwd).sendKeys("Test@1234");

		// 5th:by locator+generic methods for element and action
		/*
		 * By eId = By.id("input-email"); By pwd = By.id("input-password");
		 * doSendKeys(eId, "Test@gmail.com"); doSendKeys(pwd, "Test@1234");
		 */
		// 6th:by locator+genric mwthods and actions in other element util class

		/*
		 * By eId = By.id("input-email"); By pwd = By.id("input-password");
		 * 
		 * ElementUtil eleUtil = new ElementUtil(driver); eleUtil.doSendKeys(eId,
		 * "test@gmail.com"); eleUtil.doSendKeys(pwd, "Test@1234");
		 */
		// 7th:BrowserUtil + ElememtUtil

		// 8th:by locator ----->String locators
		String emailId = "input-email";
		String password = "input-password";
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", emailId, "Tom@gmail.com");
		eleUtil.doSendKeys("id", password, "Tom@1234");

		// 9th:POM + framework

	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
