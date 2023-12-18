package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author naseema
 * BrowserUtil is having multiple generic methods to handle various browser actions
 *
 */

public class BrowserUtil {

	private WebDriver driver;
	/**
	 *
	 * this method is used to luanch the browser on the basis of given browsername
	 * @param browserName
	 * @return this returns driver instance
	 */
	
	public WebDriver LuanchBrowser(String browserName) {
		
		System.out.println("browser name:"+browserName);
      switch(browserName.toLowerCase().trim()) {
  	case "chrome":
		driver=new ChromeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
	case "edge":
		driver=new EdgeDriver();
		break;
	case "safari":
		driver=new SafariDriver();
		break;
	default:
		System.out.println("Please pass the right browser");
		throw new AutomationException("Invalid Browser");
	   
	
	}

	return driver;
}
	/**
	 * 
	 * @param url
	 * this method is used to luanch the url
	 */
	public void luanchUrl(String url) {
		if(url==null) {
			System.out.println("URL is NULL");
			throw new AutomationException("NULL URL");
		}
		
		//https://www.goggle.com
		if(url.indexOf("https")==0) {
			driver.get(url);
		}
		else {
			throw new AutomationException("HTTP is missing");
		}
		
	}
	
	public String getPageTitle() {
		String Title=driver.getTitle();
		System.out.println("page title is:"+Title);
		return Title;
	}
	
	public String getPageUrl() {
		String url=driver.getCurrentUrl();
		System.out.println("page url is:"+url);
		return url;

		}
	
	public boolean getPageSource(String value) {
		String pageSource=driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	
	public void CloseBrowser() {
		driver.close();
		System.out.println("browser is closed");
	}
	public void QuitBrowser() {
		driver.quit();
		System.out.println("browser is closed");
	
	}
	
	
	
	
	
}
