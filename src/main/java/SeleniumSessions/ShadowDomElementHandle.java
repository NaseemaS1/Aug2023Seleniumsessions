package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElementHandle {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("chrome://settings/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		String search_script="return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement search=(WebElement)js.executeScript(search_script);
		
      search.sendKeys("notification");
		
		
      //document.querySelector("body > settings-ui").shadowRoot.querySelector("#toolbar").shadowRoot.querySelector("#search").shadowRoot.querySelector("#searchInput")
		
		
		
		
	}

}
