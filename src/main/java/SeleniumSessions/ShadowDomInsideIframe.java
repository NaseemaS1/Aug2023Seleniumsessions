package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomInsideIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		driver.switchTo().frame("pact");
		
		
		String tea_script="return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		JavascriptExecutor js = (JavascriptExecutor) driver;
	      WebElement tea=(WebElement)js.executeScript(tea_script);
			
	      tea.sendKeys("masala tea");
	      driver.quit();
			
	}

}
