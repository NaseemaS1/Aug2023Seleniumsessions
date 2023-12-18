package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

		Actions act = new Actions(driver);

		act.sendKeys(driver.findElement(By.id("input-email")), "naseema@gmail.com").perform();
		act.sendKeys(driver.findElement(By.id("input-password")), "naseema@gmail.com").perform();
		act.click(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"))).perform();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public static void doActionsSendKeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

	}
	public static void doActionsClick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();

	}

}
