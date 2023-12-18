package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Actions actions=new Actions(driver);
		
		/*
		 * actions.sendKeys(Keys.PAGE_DOWN).perform();
		 *  Thread.sleep(1000);
		 * actions.sendKeys(Keys.PAGE_DOWN).perform(); 
		 * Thread.sleep(1000);
		 * 
		 * actions.sendKeys(Keys.PAGE_UP).perform();
		 */
		
		//CMD/CNTRL + ARROW KEY DOWN
		/*
		 * actions.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		 * Thread.sleep(1000);
		 * actions.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		 * Thread.sleep(1000);
		 * actions.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		 */
		
		//Scroll to Element
		
		//actions.scrollToElement(driver.findElement(By.linkText("Help"))).click(driver.findElement(By.linkText("Help"))).build().perform();
		
		//refresh page:
		//driver.navigate.refresh();
		
		//control+f5
		actions.keyDown(Keys.COMMAND).sendKeys(Keys.F5).keyUp(Keys.COMMAND).build().perform();
		
		
		
		
		
	}

}
