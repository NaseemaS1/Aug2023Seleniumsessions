package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabKeysConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.get("https://www.amazon.com/");


		/*
		 * Actions act = new Actions(driver);
		 * 
		 * WebElement FirstName=driver.findElement(By.id("input-firstname"));
		 * 
		 * act.sendKeys(FirstName, "naseema")
		 *  .sendKeys(Keys.TAB) .pause(500)
		 * .sendKeys("Automatiion") 
		 * .sendKeys(Keys.TAB) .pause(500)
		 * .sendKeys("automation@gmail.com") 
		 * .sendKeys(Keys.TAB) .pause(500)
		 * .sendKeys("956665889") 
		 * .sendKeys(Keys.TAB) 
		 * .pause(500) .build().perform();
		 */
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB) .pause(500)
		.sendKeys(Keys.TAB) .pause(500)
		.sendKeys(Keys.TAB) .pause(500)
		.sendKeys(Keys.TAB) .pause(500)
		.sendKeys(Keys.TAB) .pause(500)
		.sendKeys("macbook pro")
		.sendKeys(Keys.ENTER).build();
		
		
		actions.perform();
		
		
		
		
	}

}
